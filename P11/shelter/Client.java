package shelter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;

public class Client {
    private String name;
    private String phone;

    public Client(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    
    @Override
    public String toString() {
        return name + " " + phone;
    }
}