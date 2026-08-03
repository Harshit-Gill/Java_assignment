import java.util.Scanner;

public class ArithmeticCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = input.nextInt();
        System.out.print("Enter second number: ");
        int num2 = input.nextInt();
        System.out.println("Enter a choice: 1 for, add 2 for subtraction, 3 for multiplication, 4 for quotient, 5 for remainder: ");
        int choice = input.nextInt();
        if(choice == 1){
            System.out.println("Sum of given number is "+(num1+num2));
        }
        else if(choice ==2){
            System.out.println("Difference of given number is "+ (num1-num2));
        }
        else if(choice ==3){
            System.out.println("The product of given number is "+ (num1*num2));
        }
        else if(choice ==4){
            System.out.println("For quotient "+(num1/num2));
        }
        else if(choice ==5){
            System.out.println("For reminder "+(num1%num2));
        }
        else{
            System.out.println("Wrong choice");
        }
        input.close();
    }
    }
    

