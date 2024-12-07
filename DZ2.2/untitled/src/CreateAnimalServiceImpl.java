import java.util.Random;

class CreateAnimalServiceImpl implements CreateAnimalService {
    private Animal[] animals = new Animal[10];
    private int count = 0;
    private Random random = new Random();

    @Override
    public void createDefaultAnimals() {
        while (count < 10) {
            animals[count] = CreateAnimalService.createRandomAnimal();
            System.out.println(animals[count].getName() + animals[count].getBreed());
            count++;
        }
    }

    public void createAnimals(int n) {
        for (int i = 0; i < n; i++) {
            if (count < animals.length) {
                animals[count] = CreateAnimalService.createRandomAnimal();
                System.out.println(animals[count].getName() + " " + animals[count].getBreed()
                        + " "  + animals[count].getCost() + " "  + animals[count].getCharacter()
                        + " " + animals[count].getBirthDate());
                count++;
            } else {
                break;
            }
        }
    }

    public void createAnimalsDoWhile(int n) {
        int c = 0;
        do {
            if (count < animals.length) {
                animals[count] = CreateAnimalService.createRandomAnimal();
                System.out.println(animals[count].getName() + " "  + animals[count].getBreed() + " "  +
                        animals[count].getCost() + " "  + animals[count].getCharacter()
                        + " " + animals[count].getBirthDate());
                count++;
                c++;
            } else {
                break;
            }
        } while (c < n);
    }
    public Animal[] getAnimals() {
        return animals;
    }
}