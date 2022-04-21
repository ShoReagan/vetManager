package shelter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;

public class Dog extends Animal {
    public Dog(DogBreed breed, String name, Gender gender, int age) {
        super(name, gender, age);
        this.breed = breed;
    }
    @Override
    public String family() {
        return "dog";
    }
    @Override
    public String breed() {
        return breed.name();
    }
    @Override
    public String toString() {
        return super.toString() + " " + breed.name() + " dog";
    }
    //@Override
    // public void create(Object breed, String name, Gender gender, int age) {
    //     this.breed = breed;
    // }
    private DogBreed breed;
}
