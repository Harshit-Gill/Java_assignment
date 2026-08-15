import java.util.Scanner;
public class leapyear {
    
    public boolean isLeapYear(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = sc.nextInt();
        boolean result = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
        sc.close();
        if (result){
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }
        return result;
          
    }
}
