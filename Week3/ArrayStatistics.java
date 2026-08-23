import java.util.Scanner;
public class ArrayStatistics {
    public void stats(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the elements of the array: ");
        for(int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        int sum = 0;
        int minimum = 0;
        int maximum = 0;
        int even = 0;
        int odd = 0;
        int positive = 0;
        int negative = 0;
        int zero = 0;
        for(int i = 0; i < size; i++){
            sum += arr[i];
            if(i == 0){
                minimum = arr[i];
            } else {
                if(arr[i] < minimum){
                    minimum = arr[i];
                }
            }
            if(i == 0){
                maximum = arr[i];
            } else {
                if(arr[i] > maximum){
                    maximum = arr[i];
                }
            }
            if(arr[i] % 2 == 0){
                even++;
            } else {
                odd++;
            }
            if(arr[i] > 0){
                positive++;
            } else if(arr[i] < 0){
                negative++;
            } else {
                zero++;
            }
        }
        System.out.println("Sum of the array elements: " + sum);
        int avg = sum / size;
        System.out.println("Average of the array elements: " + avg);
        System.out.println("Minimum element in the array: " + minimum);
        System.out.println("Maximum element in the array: " + maximum);
        System.out.println("Number of even elements in the array: " + even);
        System.out.println("Number of odd elements in the array: " + odd);
        System.out.println("Number of positive elements in the array: " + positive);
        System.out.println("Number of negative elements in the array: " + negative);
        System.out.println("Number of zero elements in the array: " + zero);
    }

}
