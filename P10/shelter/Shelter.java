package shelter;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import java.util.StringTokenizer;

public class Shelter {
    String name;
    ArrayList<Animal> animals = new ArrayList<>();
    ArrayList<Client> clients = new ArrayList<>();
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
            else if (dogOrCat.contains("Pig")) {
                animals.add(new Pig(PigBreed.valueOf(br.readLine()), br.readLine(), Gender.valueOf(br.readLine()), Integer.parseInt(br.readLine())));
            }
            else
            {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String number = st.nextToken();
                clients.add(new Client(name, number));
            }
        }
    }
    public void save(BufferedWriter bw) throws IOException{
        bw.write("" + name + '\n');
        int size = animals.size() + clients.size();
        bw.write("" + size + '\n');
        for(Animal a : animals) {
            bw.write("" + a.getClass() + '\n');
            bw.write("" + a.breed() + '\n');
            bw.write("" + a.name() + '\n');
            bw.write("" + a.gender() + '\n');
            bw.write("" + a.age() + '\n');
        }
        for(Client i : clients) {
            bw.write("" + "client" + '\n');
            bw.write("" + i.toString() + '\n');
        }
    }
    public String name() {
        return name;
    }
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
    public void addClient(Client client) {
        clients.add(client);
    }
    public int numAnimals() {
        return animals.size();
    }
    public Animal getAnimal(int index) {
        return animals.get(index);
    }
    public String clientToString() {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for(Client a : clients) {
            result.append((first ? "" : "\n") + a);
            first = false;
        }
        return result.toString();
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
