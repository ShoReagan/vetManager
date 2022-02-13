import java.util.Scanner;

public class Crypto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner strscanner = new Scanner(System.in);
        String key = new String(args[0]);

        while(true){   
            try{
                Substitution sub = new Substitution(key);

                while(true) {
                    System.out.println("(e)crypt, (d)ecrypt, or (q)uit? ");
                    char choice = scanner.next().charAt(0);

                    if(choice == 'e'){
                        System.out.println("Enter text to encrypt");
                        String txt = new String(strscanner.nextLine());
                        System.out.println(sub.encrypt(txt));
                    }
                    else if(choice == 'd'){
                        System.out.println("Enter text to decrypt");
                        String txt = new String(strscanner.nextLine());
                        System.out.println(sub.decrypt(txt));
                    }
                    else if(choice == 'q')
                        System.exit(1);
                    else
                        System.out.println("Not a valid input");
                    
            
                }
            }
            catch(IllegalArgumentException e) {
                System.out.println(e);
                System.out.print("Enter a valid key: ");
                key = scanner.nextLine();
            }
        }
    }
                


}