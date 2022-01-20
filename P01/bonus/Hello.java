import java.util.Scanner;

public class Hello{
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter Name");

        String name = myScanner.nextLine();
        System.out.println("Hello, " + name);
    }
}