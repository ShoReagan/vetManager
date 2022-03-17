package shelter;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;

public class Shelter {
    String name;
    ArrayList<Animal> animals = new ArrayList<>();
    public Shelter(String name) {
        this.name = name;
    }
    public Shelter(BufferedReader br) throws IOException{
        name = br.readLine();
        int size = Integer.parseInt(br.readLine());
        for(int i = 0; i < size; i++) {
            String dogOrCat = br.readLine();
            if(dogOrCat.contains("Dog")) {
                animals.add(new Dog(DogBreed.valueOf(br.readLine()), br.readLine(), Gender.valueOf(br.readLine()), Integer.parseInt(br.readLine())));
            }
            else if (dogOrCat.contains("Cat")) {
                animals.add(new Cat(CatBreed.valueOf(br.readLine()), br.readLine(), Gender.valueOf(br.readLine()), Integer.parseInt(br.readLine())));
            }
        }
    }
    public void save(BufferedWriter bw) throws IOException{
        bw.write("" + name + '\n');
        bw.write("" + animals.size() + '\n');
        for(Animal a : animals) {
            bw.write("" + a.getClass() + '\n');
            bw.write("" + a.breed() + '\n');
            bw.write("" + a.name() + '\n');
            bw.write("" + a.gender() + '\n');
            bw.write("" + a.age() + '\n');
        }
    }
    public String name() {
        return name;
    }
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
    public int numAnimals() {
        return animals.size();
    }
    public Animal getAnimal(int index) {
        return animals.get(index);
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for(Animal a : animals) {
            result.append((first ? "" : "\n") + a);
            first = false;
        }
        return result.toString();
    }
}
