package org.fundamentals.homework;

public class DogAnimal extends Animal implements Barking,
        GuardingBehavior {
    @Override
    protected String getName() {
        return "Dog";
    }
}
