import shelter.Cat;
import shelter.Dog;
import shelter.Shelter;
import shelter.DogBreed;
import shelter.CatBreed;
import shelter.Gender;
import shelter.Animal;

public class Mass {
    public static void main(String[] args){
        Shelter Heaven = new Shelter("Heaven");
        Dog Jim = new Dog(DogBreed.beagle, "Jim", Gender.male, 7);
        Cat Sarah = new Cat(CatBreed.Burmese, "Sarah", Gender.female, 10);
        
        System.out.println(Jim.breed());
        System.out.println(Sarah.breed());

        Heaven.addAnimal(Jim);
        Heaven.addAnimal(Sarah);

        System.out.println(Heaven.toString());
    }
}