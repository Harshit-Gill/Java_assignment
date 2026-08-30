public class CourseEnrollment {
    private String code;
    private String title;
    private int capacity;
    private int enrollCount;

    public CourseEnrollment(String code, String title, int capacity){
        if(code==null){
            System.out.println("Code can never be null");
            return;
        }
        if(title==null){
            System.out.println("Title can never be null");
            return;
        }
        if(capacity<=0){
            System.out.println("Capacity can never be less than zero");
            return;
        }
        this.code = code;
        this.title = title;
        this.capacity = capacity;
        this.enrollCount = 0;
    }
    public boolean enroll(){
        if(capacity<=enrollCount){
            System.out.println("Sorry! Seats are full");
            return false;
        }
        enrollCount++;
        return true;
    }
    public boolean withdraw(){
        if(enrollCount==0){
            System.out.println("No, Student is enrolled");
            return false;
        }
        enrollCount--;
        return true;
    }
    public boolean isFull(){
        return capacity==enrollCount;
    }
    public int getAvailableSeats(){
        return capacity-enrollCount;
    
    }
    public String toString(){
        return "Course{" +
                "courseCode='" + code + '\'' +
                ", title='" + title + '\'' +
                ", capacity=" + capacity +
                ", enrolledCount=" + enrollCount +
                ", availableSeats=" + getAvailableSeats() +
                '}';
    }
}
