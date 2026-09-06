import java.util.Arrays;
abstract class Person {
 
    private final String name;
    private final int id;
    private final String campusCategory;
 
    public Person(String name, int id, String campusCategory) {
        this.name = name;
        this.id = id;
        this.campusCategory = campusCategory;
    }
 
    public String getName() {
        return name;
    }
 
    public int getId() {
        return id;
    }
 
    public String getCampusCategory() {
        return campusCategory;
    }
 
    public abstract String describeRole();
 
    @Override
    public String toString() {
        return "[ID: " + id + " | Name: " + name + " | Category: " + campusCategory + "]";
    }
}
 
class Student extends Person {
 
    private final String major;
    private final int[] scores; 
 
    public Student(String name, int id, String major, int[] scores) {
        super(name, id, "Student - " + major);
        this.major = major;
        this.scores = scores;
    }
 
    public int[] getScores() {
        return scores;
    }
 
    public double calculateAverage() {
        if (scores == null || scores.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int s : scores) {
            sum += s;
        }
        return (double) sum / scores.length;
    }
 
    @Override
    public String describeRole() {
        return "Student majoring in " + major + " (avg score: "
                + String.format("%.2f", calculateAverage()) + ")";
    }
 
    @Override
    public String toString() {
        return super.toString() + " Major: " + major + " Scores: " + Arrays.toString(scores);
    }
}
 

class Instructor extends Person {
 
    private final String department;
    private final int yearsOfService;
 
    public Instructor(String name, int id, String department, int yearsOfService) {
        super(name, id, "Instructor - " + department);
        this.department = department;
        this.yearsOfService = yearsOfService;
    }
 
    public int getYearsOfService() {
        return yearsOfService;
    }
 
    @Override
    public String describeRole() {
        return "Instructor in " + department + " with " + yearsOfService + " years of service";
    }
 
    @Override
    public String toString() {
        return super.toString() + " Dept: " + department + " Years: " + yearsOfService;
    }
}
 

class Librarian extends Person {
 
    private final String sectionManaged;
    private final int booksCatalogued;
 
    public Librarian(String name, int id, String sectionManaged, int booksCatalogued) {
        super(name, id, "Librarian - " + sectionManaged);
        this.sectionManaged = sectionManaged;
        this.booksCatalogued = booksCatalogued;
    }
 
    @Override
    public String describeRole() {
        return "Librarian managing the " + sectionManaged + " section ("
                + booksCatalogued + " books catalogued)";
    }
 
    @Override
    public String toString() {
        return super.toString() + " Section: " + sectionManaged + " Books: " + booksCatalogued;
    }
}
 

class CampusRegistry {
 
    private final Person[] people;
    private int count;
 
    public CampusRegistry(int capacity) {
        people = new Person[capacity];
        count = 0;
    }
 
    
    public boolean addPerson(Person p) {
        if (p == null || count >= people.length) {
            return false;
        }
        people[count] = p;
        count++;
        return true;
    }
 
 
    public Person searchByName(String name) {
        for (int i = 0; i < count; i++) {
            if (people[i].getName().equalsIgnoreCase(name)) {
                return people[i];
            }
        }
        return null;
    }
 

    public Student findTopStudent() {
        Student top = null;
        double bestAverage = -1.0;
 
        for (int i = 0; i < count; i++) {
            Person current = people[i];
            if (current instanceof Student) {
                Student s = (Student) current; 
                double avg = s.calculateAverage();
                if (avg > bestAverage) {
                    bestAverage = avg;
                    top = s;
                }
            }
        }
        return top;
    }
 
    
    public void printDirectory() {
        System.out.println("---- Campus Registry Directory (" + count + " people) ----");
        for (int i = 0; i < count; i++) {
            Person p = people[i]; 
            System.out.println((i + 1) + ". " + p + " -> " + p.describeRole());
        }
    }
 
    public int getCount() {
        return count;
    }
}
 

public class CampusManagementApp {
 
    public static void main(String[] args) {
 
        CampusRegistry registry = new CampusRegistry(10);
 
        Student s1 = new Student("Harshit Gill", 101, "AIML", new int[]{88, 92, 79, 95});
        Student s2 = new Student("Rina Kapoor", 102, "CSE", new int[]{60, 65, 70, 58});
        Instructor i1 = new Instructor("Dr. Meera Nair", 201, "Computer Science", 12);
        Instructor i2 = new Instructor("Prof. Alok Sharma", 202, "Mathematics", 7);
        Librarian l1 = new Librarian("Sunita Verma", 301, "Digital Archives", 4300);
 
        registry.addPerson(s1);
        registry.addPerson(s2);
        registry.addPerson(i1);
        registry.addPerson(i2);
        registry.addPerson(l1);
 
        System.out.println("Total people registered: " + registry.getCount());
        System.out.println();
 
        registry.printDirectory();
        System.out.println();
 
        String lookupName = "Dr. Meera Nair";
        Person found = registry.searchByName(lookupName);
        if (found != null) {
            System.out.println("Search result for \"" + lookupName + "\": " + found.describeRole());
        } else {
            System.out.println("No person found with name \"" + lookupName + "\".");
        }
        System.out.println();
 
        Student top = registry.findTopStudent();
        if (top != null) {
            System.out.println("Top-performing student: " + top.getName()
                    + " (" + top.describeRole() + ")");
        } else {
            System.out.println("No students currently registered.");
        }
    }
}