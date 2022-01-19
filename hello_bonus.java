import java.util.Scanner;

public class hello_bonus{
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter Name");

        String name = myScanner.nextLine();
        System.out.println("Hello, " + name);
    }
}