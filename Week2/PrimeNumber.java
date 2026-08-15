import java.util.Scanner;
public class PrimeNumber {
    public boolean isPrime(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number:");
        int num = sc.nextInt();
        sc.close();
        if (num <= 1) {
            System.out.println(num + " is not a prime number.");
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                System.out.println("" + num + " is not a prime number.");
                    return false;
            }
        }
        System.out.println(num + " is a prime number.");
        return true;
    }
}
