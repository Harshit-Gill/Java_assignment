abstract class Shape {
    private String color;
 
    public Shape(String color) {
        this.color = color;
    }
 
    public String getColor() {
        return color;
    }
 
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
 
    @Override
    public String toString() {
        return String.format("%-10s | color=%-7s | area=%8.2f | perimeter=%8.2f",
                getClass().getSimpleName(), color, calculateArea(), calculatePerimeter());
    }
}
 
class Circle extends Shape {
    private double radius;
 
    public Circle(String color, double radius) {
        super(color); 
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
        this.radius = radius;
    }
 
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
 
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
 
    public void rollDistance(int rotations) {
        double distance = rotations * calculatePerimeter();
        System.out.printf("    -> Circle-only: rolling %d times covers %.2f units%n", rotations, distance);
    }
}
 
class Rectangle extends Shape {
    private double length;
    private double width;
 
    public Rectangle(String color, double length, double width) {
        super(color);
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Length and width must be positive");
        }
        this.length = length;
        this.width = width;
    }
 
    @Override
    public double calculateArea() {
        return length * width;
    }
 
    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
 
    
    public double diagonalLength() {
        double diagonal = Math.sqrt(length * length + width * width);
        System.out.printf("    -> Rectangle-only: diagonal length = %.2f%n", diagonal);
        return diagonal;
    }
}
 

class Triangle extends Shape {
    private double sideA, sideB, sideC;
 
    public Triangle(String color, double sideA, double sideB, double sideC) {
        super(color);
        if (sideA <= 0 || sideB <= 0 || sideC <= 0
                || sideA + sideB <= sideC
                || sideB + sideC <= sideA
                || sideA + sideC <= sideB) {
            throw new IllegalArgumentException("Invalid triangle sides");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
 
    @Override
    public double calculateArea() {
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
 
    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    public void classifyTriangle() {
        String type;
        if (sideA == sideB && sideB == sideC) {
            type = "Equilateral";
        } else if (sideA == sideB || sideB == sideC || sideA == sideC) {
            type = "Isosceles";
        } else {
            type = "Scalene";
        }
        System.out.println("    -> Triangle-only: type = " + type);
    }
}
 

public class ShapeManagementApp {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[] {
                new Circle("Red", 5.0),
                new Circle("Blue", 2.5),
                new Rectangle("Green", 4.0, 6.0),
                new Rectangle("Yellow", 3.0, 3.0),
                new Triangle("Black", 3.0, 4.0, 5.0),
                new Triangle("White", 6.0, 6.0, 6.0)
        };
 
        System.out.println("=== All Shapes ===");
        for (Shape s : shapes) {
            System.out.println(s); 
        }
 
        
        double totalArea = 0;
        for (Shape s : shapes) {
            totalArea += s.calculateArea();
        }
        System.out.printf("%nTotal area of all shapes: %.2f%n", totalArea);
 
        
        Shape largest = shapes[0];
        for (Shape s : shapes) {
            if (s.calculateArea() > largest.calculateArea()) {
                largest = s;
            }
        }
        System.out.println("\nShape with largest area:");
        System.out.println(largest);
 
        
        System.out.println("\n=== Subtype-specific behaviour ===");
        for (Shape s : shapes) {
            System.out.println(s);
            if (s instanceof Circle) {
                ((Circle) s).rollDistance(3);
            } else if (s instanceof Rectangle) {
                ((Rectangle) s).diagonalLength();
            } else if (s instanceof Triangle) {
                ((Triangle) s).classifyTriangle();
            }
        }
    }
}
 
