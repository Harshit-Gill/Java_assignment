import java.util.Scanner;

public class LoopPatterns {
    public void Patter(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        sc.close();
        
        // pattern A
        for(int i = 1; i<=rows; i++){
            System.out.println("****");
        }

        // pattern B
        for(int i = 1; i<=rows; i++){
            for(int j = 1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        // pattern C
        for(int i = 1; i<=rows; i++){
            for(int j = 1; j<=i; j++){
                System.out.print(j);
            }
            System.out.println();
        }

        // pattern D
        for(int i = rows; i>=1; i--){
            for(int j = 1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        // pattern E
        for(int i = 1; i<=rows; i++){
            for(int j = 1; j<=i; j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
