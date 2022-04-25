package shelter;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Shelter {
    String name;
    ArrayList<Animal> animals = new ArrayList<>();
    ArrayList<Client> clients = new ArrayList<>();
    HashMap<Animal, Client> adoptions = new HashMap<>();
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
    public ListIterator<Client> clientListIterator() {
        ListIterator<Client> clientIterator = clients.listIterator();
        return clientIterator;
    }
     public Dog returnDog(String values) {
         StringTokenizer str = new StringTokenizer(values, " ");
         String name = str.nextToken();
         int age = Integer.parseInt(str.nextToken());
         str.nextToken();
         str.nextToken();
         Gender gender = Gender.valueOf(str.nextToken());
         DogBreed breed = DogBreed.valueOf(str.nextToken());

        Dog dog = new Dog(breed, name, gender, age);

        return dog;
    }

    public Cat returnCat(String values) {
         StringTokenizer str = new StringTokenizer(values, " ");
         String name = str.nextToken();
         int age = Integer.parseInt(str.nextToken());
         str.nextToken();
         str.nextToken();
         Gender gender = Gender.valueOf(str.nextToken());
         CatBreed breed = CatBreed.valueOf(str.nextToken());

        Cat dog = new Cat(breed, name, gender, age);

        return dog;
    }

    public Pig returnPig(String values) {
         StringTokenizer str = new StringTokenizer(values, " ");
         String name = str.nextToken();
         int age = Integer.parseInt(str.nextToken());
         str.nextToken();
         str.nextToken();
         Gender gender = Gender.valueOf(str.nextToken());
         PigBreed breed = PigBreed.valueOf(str.nextToken());

        Pig dog = new Pig(breed, name, gender, age);

        return dog;
    }

    public void removeAnimal(String values) {
        StringTokenizer str = new StringTokenizer(values, " ");
        String name = str.nextToken();
        int index;
        for(Animal a : animals) {
            if(a.name().contains(name))
                animals.remove(animals.indexOf(a));

        }
    }

    public Client returnClient(String values) {
         StringTokenizer str = new StringTokenizer(values, " ");
         String name = str.nextToken();
         String number = str.nextToken();

        Client client = new Client(name, number);

        return client;


     }
    public ListIterator<Animal> animalListIterator() {
        ListIterator<Animal> animalIterator = animals.listIterator();
        return animalIterator;
    }
    public ListIterator<Animal> adoptionsListIterator() {
        Set<Animal> animalSet = new HashSet<>();
        animalSet = adoptions.keySet();
        ArrayList<Animal> animalslist = new ArrayList<>(animalSet);
        ListIterator<Animal> adoptionsIterator = animalslist.listIterator();
        return adoptionsIterator;
    }

    public void adopt(Animal animal, Client client) {
        adoptions.put(animal, client);
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
    public String adoptionsToString() {
        StringBuilder ans = new StringBuilder();
        for(Animal a : adoptions.keySet()){
            ans.append(a.toString());
            ans.append(" adopted by ");
            ans.append(adoptions.get(a).toString());
            ans.append("\n");
        } 
        return ans.toString();
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
