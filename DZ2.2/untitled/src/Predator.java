import java.time.LocalDate;

public class Predator extends AbstractAnimal{
    private String breed;
    private String name;
    private double cost;
    private String character;
    private LocalDate birthDate;

    public Predator(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
    }

    @Override
    protected LocalDate birthDate() {return this.birthDate;}

    @Override
    protected String breed() {
        return this.breed;
    }

    @Override
    protected String name() {
        return this.name;
    }

    @Override
    protected Double cost() {
        return this.cost;
    }

    @Override
    protected String character() {
        return this.character;
    }

    @Override
    public String getBreed() {

        return this.breed;
    }

    @Override
    public String getName() {

        return this.name;
    }

    @Override
    public double getCost() {

        return this.cost;
    }

    @Override
    public String getCharacter() {

        return this.character;
    }

    @Override
    public LocalDate getBirthdate() {
        return this.birthDate;
    }
}
