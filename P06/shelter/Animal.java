package shelter;
public abstract class Animal {
    protected String name;
    protected Gender gender;
    protected int age;

    public Animal(String name, Gender gender, int age){
        if(age < 0)
            throw new IllegalArgumentException("Age cannot be negative");
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    public abstract String family();
    public abstract String breed();
    public abstract String toString();
}