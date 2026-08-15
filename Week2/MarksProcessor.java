import java.util.Scanner;

public class MarksProcessor {
    public void processMarks(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = sc.nextInt();
        int[] marks = new int[numStudents];
        for (int i = 0; i < numStudents; i++){
            System.out.print("Enter marks for student " + (i + 1) + ": ");
            int mark = sc.nextInt();
            if (mark < 0 || mark > 100){
                System.out.println("Invalid marks. Please enter marks between 0 and 100.");
                i--;
            } else {
                marks[i] = mark;
            }
        }
        sc.close();
        int length = marks.length;
        int sum = 0;
        for (int mark : marks){
            sum += mark;
        }
        double average = (double) sum / length;
        int highest = 0;
        for (int mark : marks){
            if (mark > highest){
                highest = mark;
            }
        }
        int pass = 0;
        for (int mark: marks){
            if (mark >= 50){
                pass++;
            }
        }
        int fail = length - pass;
        System.out.println("Average marks: " + average);
        System.out.println("Highest marks: " + highest);
        System.out.println("Number of students passed: " + pass);
        System.out.println("Number of students failed: " + fail);
        System.out.println("Number of valid marks entered: " + length);
        System.out.println("Sum of marks: " + sum);
    }
}
