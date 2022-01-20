import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Hello{
    public static void main(String[] args){

        String command = "git config user.name";
        try{
            Process proc = Runtime.getRuntime().exec(command);

            BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

            String username = "";
            username = reader.readLine();

            System.out.println("Hello, " + username);
        } 
        catch(IOException e) {
            e.printStackTrace();
        }

            
    }
}