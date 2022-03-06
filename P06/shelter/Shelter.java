package shelter;
import java.util.ArrayList;
public class Shelter {
    private String name;
    private ArrayList<Animal> animals = new ArrayList<Animal>();

    public Shelter(String name) {
        this.name = name;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    @Override
    public String toString() {
        String sum = new String();
        for(Animal a : animals) {
            sum += a + "\n";
        }
        sum = sum.substring(0, sum.length() - 1); //removes last newline character
        return sum;
    }
}