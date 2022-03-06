package shelter;
public class Cat extends Animal {
    private CatBreed breed;

    public Cat(CatBreed breed, String name, Gender gender, int age) {
        super(name, gender, age);
        this.breed = breed;
    }

    @Override
    public String family() {
        return "Cat";
    } 

    @Override
    public String breed() {
        return breed.toString();
    }

    @Override
    public String toString() {
        return name + " is a " + age + " year old " + gender + " cat";
    }
}