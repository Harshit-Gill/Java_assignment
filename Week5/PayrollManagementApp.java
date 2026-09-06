abstract class Employee implements Payable {
    protected String employeeId;
    protected String name;
    protected String department;
 
    public Employee(String employeeId, String name, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
    }
 
    public String getEmployeeId() {
        return employeeId;
    }
 
    public String getName() {
        return name;
    }
 
    public String getDepartment() {
        return department;
    }
 
   
    @Override
    public abstract double calculatePayment();
 
    @Override
    public String getDescription() {
        return "Employee[" + employeeId + "] " + name + " (" + department + ")";
    }
 
    @Override
    public String toString() {
        return String.format("%s - Pay: $%.2f", getDescription(), calculatePayment());
    }
}
 

class SalariedEmployee extends Employee {
    private double monthlySalary;
 
    public SalariedEmployee(String employeeId, String name, String department, double monthlySalary) {
        super(employeeId, name, department);
        this.monthlySalary = monthlySalary;
    }
 
    @Override
    public double calculatePayment() {
        return monthlySalary;
    }
 
    @Override
    public String toString() {
        return super.toString() + " [Salaried]";
    }
}
 

class HourlyEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;
 
    public HourlyEmployee(String employeeId, String name, String department,
                           double hourlyRate, double hoursWorked) {
        super(employeeId, name, department);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
 
    @Override
    public double calculatePayment() {
        final double overtimeThreshold = 40.0;
        if (hoursWorked <= overtimeThreshold) {
            return hoursWorked * hourlyRate;
        }
        double regularPay = overtimeThreshold * hourlyRate;
        double overtimeHours = hoursWorked - overtimeThreshold;
        double overtimePay = overtimeHours * hourlyRate * 1.5;
        return regularPay + overtimePay;
    }
 
    @Override
    public String toString() {
        return super.toString() + " [Hourly, " + hoursWorked + " hrs]";
    }
}
 

class CommissionEmployee extends Employee {
    private double baseSalary;
    private double salesAmount;
    private double commissionRate;
 
    public CommissionEmployee(String employeeId, String name, String department,
                               double baseSalary, double salesAmount, double commissionRate) {
        super(employeeId, name, department);
        this.baseSalary = baseSalary;
        this.salesAmount = salesAmount;
        this.commissionRate = commissionRate;
    }
 
    @Override
    public double calculatePayment() {
        return baseSalary + (salesAmount * commissionRate);
    }
 
    @Override
    public String toString() {
        return super.toString() + " [Commission]";
    }
}

class SupplierBill implements Payable {
    private String billId;
    private String supplierName;
    private double amountDue;
    private double lateFee;
 
    public SupplierBill(String billId, String supplierName, double amountDue, double lateFee) {
        this.billId = billId;
        this.supplierName = supplierName;
        this.amountDue = amountDue;
        this.lateFee = lateFee;
    }
 
    @Override
    public double calculatePayment() {
        return amountDue + lateFee;
    }
 
    @Override
    public String getDescription() {
        return "SupplierBill[" + billId + "] " + supplierName;
    }
 
    @Override
    public String toString() {
        return String.format("%s - Pay: $%.2f", getDescription(), calculatePayment());
    }
}
 

class PayrollProcessor {
    private Payable[] payables;
    private int count;
 
    public PayrollProcessor(int capacity) {
        payables = new Payable[capacity];
        count = 0;
    }
 
    
    public boolean addPayable(Payable p) {
        if (p == null || count >= payables.length) {
            return false;
        }
        payables[count] = p;
        count++;
        return true;
    }
 
    
    public double calculateTotalPayment() {
        double total = 0.0;
        for (int i = 0; i < count; i++) {
            total += payables[i].calculatePayment();
        }
        return total;
    }
 
    
    public Payable findLargestPayment() {
        if (count == 0) {
            return null;
        }
        Payable largest = payables[0];
        for (int i = 1; i < count; i++) {
            if (payables[i].calculatePayment() > largest.calculatePayment()) {
                largest = payables[i];
            }
        }
        return largest;
    }
 
   
    public int[] countEmployeesAndOthers() {
        int employeeCount = 0;
        int otherCount = 0;
        for (int i = 0; i < count; i++) {
            if (payables[i] instanceof Employee) {
                employeeCount++;
            } else {
                otherCount++;
            }
        }
        return new int[] { employeeCount, otherCount };
    }
 
   
    public void displayAll() {
        for (int i = 0; i < count; i++) {
            Payable p = payables[i];
            System.out.println(p.toString());
            if (p instanceof Employee) {
                Employee e = (Employee) p;
                System.out.println("    -> Department: " + e.getDepartment());
            }
        }
    }
 
    public int getCount() {
        return count;
    }
 
    public int getCapacity() {
        return payables.length;
    }
}

public class PayrollManagementApp {
    public static void main(String[] args) {
        PayrollProcessor processor = new PayrollProcessor(10);
 
        Employee e1 = new SalariedEmployee("E100", "Asha Verma", "Engineering", 65000.0);
        Employee e2 = new HourlyEmployee("E101", "Rohit Kumar", "Support", 25.0, 48.0);
        Employee e3 = new CommissionEmployee("E102", "Priya Singh", "Sales", 2000.0, 15000.0, 0.05);
        Employee e4 = new HourlyEmployee("E103", "Farhan Ali", "Warehouse", 18.5, 35.0);
        Payable p1 = new SupplierBill("B200", "Bright Steel Co.", 4200.0, 150.0);
        Payable p2 = new SupplierBill("B201", "GreenPack Supplies", 980.0, 0.0);
 
        processor.addPayable(e1);
        processor.addPayable(e2);
        processor.addPayable(e3);
        processor.addPayable(e4);
        processor.addPayable(p1);
        processor.addPayable(p2);
 
        System.out.println("===== Payroll Register =====");
        processor.displayAll();
 
        System.out.println();
        System.out.printf("Total payment due: $%.2f%n", processor.calculateTotalPayment());
 
        Payable largest = processor.findLargestPayment();
        if (largest != null) {
            System.out.println("Largest single payment: " + largest.getDescription()
                    + String.format(" ($%.2f)", largest.calculatePayment()));
        }
 
        int[] counts = processor.countEmployeesAndOthers();
        System.out.println("Employee payables: " + counts[0]
                + " | Non-employee payables: " + counts[1]);
 
        System.out.println("Processor holding " + processor.getCount()
                + "/" + processor.getCapacity() + " payables.");
    }
}
