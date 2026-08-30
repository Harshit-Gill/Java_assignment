class Student {
    private String name;
    private String studentId;
    private int mark;

    public Student(String name, String studentId, int mark){
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name must be non-null and non-blank");
        }
        if (studentId == null || studentId.trim().isEmpty()) {
            throw new IllegalArgumentException("studentId must be non-null and non-blank");
        }
        if (mark < 0 || mark > 100) {
            throw new IllegalArgumentException("mark must be between 0 and 100");
        }
 
        this.name = name;
        this.studentId = studentId;
        this.mark = mark;
    }
    public String getName() {
        return this.name;
    }
 
    public String getStudentId() {
        return this.studentId;
    }
 
    public int getMark() {
        return this.mark;
    }
    public boolean setMark(int newMark) {
        if (newMark < 0 || newMark > 100) {
            return false;
        }
        this.mark = newMark;
        return true;
    }
    public boolean hasPassed() {
        return this.mark >= 50;
    }
 
    public String getClassification() {
        if (this.mark >= 80) {
            return "Distinction";
        } else if (this.mark >= 50) {
            return "Pass";
        } else {
            return "Fail";
        }
    }
    
}
public class StudentRecord {
 
    public static void main(String[] args) {
 
        Student s1 = new Student("Alice", "S001", 49);
        Student s2 = new Student("Bob", "S002", 50);
        Student s3 = new Student("Charlie", "S003", 79);
        Student s4 = new Student("Diana", "S004", 80);
 
        System.out.println("--- Initial records ---");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
 
        System.out.println("\n--- Testing invalid update on Alice (setMark(150)) ---");
        boolean success = s1.setMark(150);
        System.out.println("Update accepted? " + success);
        System.out.println(s1);

        System.out.println("\n--- Testing valid update on Alice (setMark(60)) ---");
        success = s1.setMark(60);
        System.out.println("Update accepted? " + success);
        System.out.println(s1);
    }
}


