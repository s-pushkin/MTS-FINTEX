import java.time.LocalDate;

public abstract class AbstractAnimal implements Animal {
    private final String character;
    private final String breed;
    private final String name;
    private final Double cost;

    protected abstract String breed();
    protected abstract String name();
    protected abstract Double cost();
    protected abstract String character();
    protected LocalDate birthDate;

    public AbstractAnimal (String breed, String name, Double cost, String character, LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
    }

    protected abstract LocalDate birthDate();

    @Override
    public String getBreed() { return breed; }
    public String getName() { return name; }
    public double getCost() { return cost; }
    public String getCharacter() { return character; }
    public LocalDate getBirthDate() { return birthDate; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Animal)) return false;
        Animal animal = (Animal) obj;
        return Double.compare(animal.getCost(), cost) == 0 &&
                breed.equals(animal.getBreed()) &&
                name.equals(animal.getName()) &&
                character.equals(animal.getCharacter()) &&
                birthDate.equals(animal.getBirthDate());
    }

    public abstract LocalDate getBirthdate();
}
