import java.time.LocalDate;

public interface Animal {
    public String getBreed();
    public String getName();
    public double getCost();
    public String getCharacter();
    LocalDate getBirthDate();
}
