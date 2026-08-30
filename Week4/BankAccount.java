class Account {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public Account(String accountNumber, String ownerName){
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("accountNumber must be non-null and non-blank");
        }
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("ownerName must be non-null and non-blank");
        }
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0.0;
    }
    
    public Account(String accountNumber, String ownerName, double openingBalance){
        this(accountNumber, ownerName);
         if (openingBalance < 0) {
            throw new IllegalArgumentException("openingBalance must be non-negative");
        }
        this.balance = openingBalance;
    }
    public boolean deposit(double amount){
        if(amount <= 0){
            return false;
        }
        this.balance += amount;
        return true;
    }
    public boolean withdraw(double amount){
        if(amount <= 0 || amount > this.balance){
            return false;
        }
        this.balance -= amount;
        return true;
    }
    public String getAccountNumber() {
        return this.accountNumber;
    }
 
    public String getOwnerName() {
        return this.ownerName;
    }
 
    public double getBalance() {
        return this.balance;
    }
    @Override
public String toString() {
    return "Account{" +
            "accountNumber='" + accountNumber + '\'' +
            ", ownerName='" + ownerName + '\'' +
            ", balance=" + balance +
            '}';
}
}

public class BankAccount{
    public static void main(String[] args){
        
        Account acc1 = new Account("ACC001", "Harshit");
        Account acc2 = new Account("ACC002", "Laddu", 500.0);

        System.out.println("--- Initial state ---");
        System.out.println(acc1);
        System.out.println(acc2);

        System.out.println("\n--- Testing deposits on acc1 ---");
        System.out.println("Deposit 100 (positive) -> " + acc1.deposit(100));
        System.out.println(acc1);

        System.out.println("Deposit 0 (zero) -> " + acc1.deposit(0));
        System.out.println(acc1);
 
        System.out.println("Deposit -50 (negative) -> " + acc1.deposit(-50));
        System.out.println(acc1);

        System.out.println("\n--- Testing withdrawals on acc2 ---");
        System.out.println("Withdraw 200 (valid) -> " + acc2.withdraw(200));
        System.out.println(acc2);
 
        System.out.println("Withdraw 10000 (excessive) -> " + acc2.withdraw(10000));
        System.out.println(acc2);

        System.out.println("\n--- Final state (independence check) ---");
        System.out.println(acc1);
        System.out.println(acc2);
    }
}
