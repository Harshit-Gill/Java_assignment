class Rectangle {
    private double width;
    private double height;

    public Rectangle(){
        this(1);
        System.out.println("  <- no-arg Rectangle() finished");
    }
    public Rectangle(double len){
        this(len, len);
        System.out.println("  <- 1-arg Rectangle() finished");
    }
    public Rectangle(double w, double h){
        System.out.println("  -> two-arg Rectangle(width, height) running");
        // if (width <= 0 || height <= 0) {
        //     throw new IllegalArgumentException("Width and height must be positive.");
        // }
        this.width = w;
        this.height = h;
    }
    public double getArea() {
        return width * height;
    }
 
    public double getPerimeter() {
        return 2 * (width + height);
    }
 
    public boolean isSquare() {
        return width == height;
    }
    public Rectangle scale(double factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Scale factor must be positive.");
        }
        return new Rectangle(width * factor, height * factor);
    }
    @Override
    public String toString() {
        return String.format("Rectangle[width=%.2f, height=%.2f, area=%.2f, perimeter=%.2f, square=%b]",
                width, height, getArea(), getPerimeter(), isSquare());
    }
}

public class RectangleModel{
    public static void main(String[] args) {
        System.out.println("=== Creating no-arg Rectangle() ===");
        Rectangle r1 = new Rectangle();
        System.out.println(r1);
 
        System.out.println("\n=== Creating one-arg Rectangle(5) ===");
        Rectangle r2 = new Rectangle(5);
        System.out.println(r2);
 
        System.out.println("\n=== Creating two-arg Rectangle(4, 9) ===");
        Rectangle r3 = new Rectangle(4, 9);
        System.out.println(r3);
 
        System.out.println("\n=== Scaling r3 by 2x ===");
        Rectangle r4 = r3.scale(2);
        System.out.println(r4);
 
        System.out.println("\n=== Validation check: negative dimension ===");
        // try {
        //     Rectangle bad = new Rectangle(-3, 4);
        // } catch (IllegalArgumentException e) {
        //     System.out.println("Caught expected exception: " + e.getMessage());
        // }
    }
}
