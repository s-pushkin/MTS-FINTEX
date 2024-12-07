public interface SearchService {
    String[] findLeapYearNames(Animal[] animals);
    Animal[] findOlderAnimal(Animal[] animals, int age);
    void findDuplicate(Animal[] animals);
}
