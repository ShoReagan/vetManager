import java.util.Scanner;

public class Polygon {  
    private int sides;
    private double perimeter;

    public Polygon(int sides, double perimeter) {
        this.sides = sides;
        this.perimeter = perimeter;
    }

    double addSide(double length) {
        if(length > 0) {
            sides++;
            perimeter += length;
        }
        return length;
    }

    int getSides() {
        return sides;
    }

    double getPerimeter() {
        return perimeter;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Polygon polygon = new Polygon(0, 0);
        double length = 0;

        System.out.print("Side Length (0 when done): ");
        while(polygon.addSide(myScanner.nextDouble()) > 0) {
            System.out.print("Side Length (0 when done): ");

        }
        System.out.printf("Perimeter of %d-sided polygon is %.2f\n", polygon.getSides(), polygon.getPerimeter());
    }
}
