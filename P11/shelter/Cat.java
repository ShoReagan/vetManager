package shelter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;

public class Cat extends Animal {
    public Cat(CatBreed breed, String name, Gender gender, int age) {
        super(name, gender, age);
        this.breed = breed;
    }
    @Override
    public String family() {
        return "cat";
    }
    @Override
    public String breed() {
        return breed.name();
    }
    @Override
    public String toString() {
        return super.toString() + " " + breed.name() + " cat)";
    }
    //@Override
    // public void create(Object breed, String name, Gender gender, int age) {
    //     super(name, gender, age);
    //     this.breed = breed;
    // }
    private CatBreed breed;
}
