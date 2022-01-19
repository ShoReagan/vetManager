import java.io.BufferedReader;
import java.io.InputStreamReader;

public class hello_extreme_bonus{
    public static void main(String[] args){
        String command = "git config user.name";

        Process proc = Runtime.getRuntime().exec(command);

        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

        String username = "";
        username = reader.readLine();

        System.out.println("Hello, " + username);
            
    }
}