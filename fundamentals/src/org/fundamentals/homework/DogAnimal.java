package org.fundamentals.homework;

public class DogAnimal extends Animal implements BarkingSounds,
        GuardingBehavior {
    @Override
    protected String getName() {
        return "Dog";
    }
}
