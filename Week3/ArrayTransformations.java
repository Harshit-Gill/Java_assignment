import java.util.Scanner;
public class ArrayTransformations {
    public void transform(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i<size; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        int length = arr.length;
        int right = length - 1;
        int left = 0;
        while (left< right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left += 1;
            right -= 1;
        }
        for (int num : arr) {
        System.out.print(num + " ");
        }
    }
}
