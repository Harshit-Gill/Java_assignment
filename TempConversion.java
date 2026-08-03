import java.util.Scanner;
public class TempConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature in celsius to convert it to fahrenhiet: ");
        float celsius = sc.nextFloat();
        float fahrenhiet = (float)(celsius*(9.0/5.0) +32.0);
        System.out.println("The temperature in fahrenhiet is "+ fahrenhiet);
        sc.close();
    }
}