public class Product {
    private String code;
    private String name;
    private double unitPrice;
    private int quantity;

    private static int Productcounter;

    public Product(String code, String name, double unitPrice){
        this(code,name,unitPrice,0);
    }
    public Product(String code, String name, double unitPrice, int quantity){
        if(code ==null){
            System.out.println("Code can never be null");
            return;
        }
        if(name==null){
            System.out.println("Name can never be null");
            return;
        }
        if(unitPrice<=0){
            System.out.println("Unit price must be greater than 0");
            return;
        }
        if(quantity<0){
            System.out.println("Quantity can never be less than 0");
            return;
        }
        this.code = code;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        Productcounter++;
    }
    public void reStock(int amount){
        if(amount<=0){
            System.out.println("Amount must be greater than 0 for restock");
            return;
        }
        quantity+=amount;
    }
    public boolean sell(int amount){
        if(amount<=0){
            System.out.println("Amount can never be negative");
            return false;
        }
        quantity = quantity-amount;
        return true;
    }
    public double getInventoryValue(){
        return unitPrice*quantity;
    }
    public static int getProductCount(){
        return Productcounter;
    }
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", inventoryValue=" + getInventoryValue() +
                '}';
    }
}
