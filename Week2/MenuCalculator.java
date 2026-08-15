import java.util.Scanner;
public class MenuCalculator {
    public double Calculator(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();
        System.out.print("Enter an operator (+, -, *, /): ");
        char operator = sc.next().charAt(0);
        sc.close();
        if(operator == '+'){
            return num1 + num2;
        }
        else if(operator == '-'){
            return num1 - num2;
        }
        else if(operator == '*'){
            return num1 * num2;
        }
        else if(operator == '/'){
            if(num2 != 0){
                return num1 / num2;
            }
            else{
                System.out.println("Error: Division by zero");
                return Double.NaN;
            }
        }
        else{
            System.out.println("Error: Invalid operator");
            return Double.NaN;
        }
        
    }
}
