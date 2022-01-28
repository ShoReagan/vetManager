import java.util.Scanner;
import java.util.ArrayList;

// Array Lists are better than arrays in this problem because we do not know how many sides the polygon will have.
// Because of this I just initialized the array in bonus to have 255 open slots for a side. If they were to have 256 or more sides then i would
// run into problems. With an array list though, we do not need to specify a length. No changes were required to the main method.

public class Polygon {  
    private int sides;
    private double perimeter;
    private ArrayList<Double> lengths = new ArrayList<Double>();

    public Polygon(int sides, double perimeter) {
        this.sides = sides;
        this.perimeter = perimeter;
    }

    double addSide(double length) {
        if(length > 0) {
            lengths.add(length);
            sides++;    
        }
        return length;
    }

    int getSides() {
        return sides;
    }

    double getPerimeter() {
        for(double i : lengths) {
            perimeter += i;
        }
        return perimeter;
    }

    double getArea(double apothem) {
        return perimeter * .5 * apothem;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Polygon polygon = new Polygon(0, 0);
        double length = 0;
        double apothem = 0;

        System.out.print("Side Length (0 when done): ");
        while(polygon.addSide(myScanner.nextDouble()) > 0) {
            System.out.print("Side Length (0 when done): ");

        }
        System.out.print("Apothem: ");
        apothem = myScanner.nextDouble();
        System.out.printf("Perimeter of %d-sided polygon is %.2f\n", polygon.getSides(), polygon.getPerimeter());
        System.out.printf("Area is %.2f\n", polygon.getArea(apothem));
    }
}
