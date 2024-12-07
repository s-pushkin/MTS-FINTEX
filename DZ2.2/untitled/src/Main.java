import java.util.List;

public class Main {
    public static void main(String[] args) {
        CreateAnimalService obj = new OutputAnimals();
        List<AbstractAnimal> OutputAnimals = obj.createAnimal();
        for (AbstractAnimal abstractAnimal : OutputAnimals) {
            System.out.println(abstractAnimal.getBreed() + " " + abstractAnimal.getName()
                    + " " + abstractAnimal.getCost() + " " + abstractAnimal.getCharacter() + " " + abstractAnimal.getBirthDate());
        }
        CreateAnimalServiceImpl animalService = new CreateAnimalServiceImpl();
        System.out.println("\nСоздание 5 животных с помощью цикла for:");
        animalService.createAnimals(5);

        System.out.println("\nСоздание 3 животных с помощью do-while:");
        animalService.createAnimalsDoWhile(3);

        SearchService searchService = new SearchServiceImpl();

        System.out.println("\nЖивотные, родившиеся в високосных годах:");
        String[] leapYearNames = searchService.findLeapYearNames(animalService.getAnimals());
        for (String name : leapYearNames) {
            System.out.println(name);
        }

        System.out.println("\nЖивотные, старше 5 лет:");
        Animal[] olderAnimals = searchService.findOlderAnimal(animalService.getAnimals(), 5);
        for (Animal animal : olderAnimals) {
            System.out.println(animal.getName() + ", Порода: " + animal.getBreed());
        }

        searchService.findDuplicate(animalService.getAnimals());

    }
}
