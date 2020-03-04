package org.fundamentals.homework;

public class Main3 {
    public static void main(String[] args) {
        printAnimalDescription(getAnimalByName(args[0]));
    }

    private static Animal getAnimalByName(String name) {
        switch (name.toLowerCase()) {
            case "dog":
                return new DogAnimal();
            case "fox":
                return new FoxAnimal();
            case "fish":
                return new FishAnimal();
            default:
                return new UnknownAnimal(name);
        }
    }

    private static void printAnimalDescription(Animal animal) {
        System.out.println(animal.getDescription());
    }
}
