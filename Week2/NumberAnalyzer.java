import java.util.Scanner;
public class NumberAnalyzer {
    public void analyzeNumbers(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = sc.nextInt();
        sc.close();
        if (num % 2 == 0){
            System.out.println("The number " + num + " is even");
        }
        if ( num > 0){
            System.out.println("The number " + num + " is positive");
        }
        System.out.println("The absolute value of " + num + " is: " + Math.abs(num));
        int count = 0;

        if (num == 0) {
            count = 1;
        } 
        else {
            int number = Math.abs(num);  
            while (number > 0) {
                number = number / 10;
                count++;
            }
        }
        System.out.println("Digit count: " + count);
        int sum = 0;
        num = Math.abs(num);
        while (num > 0 ){
            sum = sum + (num % 10);
            num = num / 10;
        }
        System.out.println("Sum of digits: " + sum);
    }
}
