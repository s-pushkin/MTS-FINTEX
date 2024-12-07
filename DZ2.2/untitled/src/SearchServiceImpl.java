import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SearchServiceImpl implements SearchService {
    @Override
    public String[] findLeapYearNames(Animal[] animals) {
        List<String> leapYearAnimals = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal != null && isLeapYear(animal.getBirthDate().getYear())) {
                leapYearAnimals.add(animal.getName());
            }
        }
        return leapYearAnimals.toArray(new String[0]);
    }

    @Override
    public Animal[] findOlderAnimal(Animal[] animals, int age) {
        List<Animal> olderAnimals = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal != null && (LocalDate.now().getYear() - animal.getBirthDate().getYear()) > age) {
                olderAnimals.add(animal);
            }
        }
        return olderAnimals.toArray(new Animal[0]);
    }

    @Override
    public void findDuplicate(Animal[] animals) {
        System.out.println("Дубликаты животных:");
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null) {
                for (int j = i + 1; j < animals.length; j++) {
                    if (animals[j] != null && animals[i].equals(animals[j])) {
                        System.out.println("Дубликат найден: " + animals[i].getName());
                        break;
                    }
                }
            }
        }
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
