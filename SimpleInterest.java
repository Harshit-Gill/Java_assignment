import java.util.Scanner;
public class SimpleInterest {
    public static void Calculate(float principal, float rate, float time){
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the principal amount : ");
        float principal = sc.nextFloat();

        System.out.print("Enter the rate of Interest : ");
        float rate = sc.nextFloat();

        System.out.print("Enter the time in years : ");
        float time = sc.nextFloat();

        float SimpleInterest = principal*rate*time/100;
        System.out.println("The simple interest of given anount is " + SimpleInterest);
        System.out.println("The final payable amount is "+ (SimpleInterest+principal));
        sc.close();
    }
}