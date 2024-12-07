import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public interface CreateAnimalService {
    Random random = new Random();


    default List<AbstractAnimal> createAnimal(){
        int i=0;
        List<AbstractAnimal> animals = new ArrayList<>();
        while(i<10){
            animals.add(createRandomAnimal());
            i++;
        }
        return animals;
    }
    static AbstractAnimal createRandomAnimal(){
        String[] names = {"Лайка", "Мурка", "Дарик", "Барсик", "Джери", "Том"};
        String[] breeds = {"Восточно-европейская овчарка", "Цвергпинчер", "Сфинкс", "Русская голубая кошка",
                "Полярный волк", "Койот", "Акула-молот", "Мегалодон"};
        String[] characters = {"Добрый","Злой", "Спокойный", "Активный", "Депрессивный"};

        String breed = breeds[random.nextInt(breeds.length)];
        String name = names[random.nextInt(names.length)];
        Double cost = (double) Math.round(1000.0 + (random.nextDouble() * 9000)); // цена от 10000 до 100000
        String character = characters[random.nextInt(characters.length)];
        int year = random.nextInt(14) + 2010; // 2010-2023
        int month = random.nextInt(12) + 1; // 1-12
        int day = random.nextInt(28) + 1; // 1-28
        LocalDate birthDate = LocalDate.of(year, month, day);

        AbstractAnimal[] animals= {new Dog(breed, name, cost, character, birthDate),
                new  Cat(breed, name, cost, character, birthDate),
                new Wolf(breed, name, cost, character, birthDate),
                new Shark(breed, name, cost, character, birthDate)};
        int randomIndex = random.nextInt(animals.length);
        return animals[randomIndex];
    }

    void createDefaultAnimals();


}
