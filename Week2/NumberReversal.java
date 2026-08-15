import java.util.Scanner;

public class NumberReversal {
    public void reversenumber(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int reversed = 0;
        sc.close();
        while(num!=0 && num > 0){
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;

        }
        System.out.println("Reversed number: " + reversed);
    }
}
