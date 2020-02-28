package org.fundamentals.homework;

public class FishAnimal extends Animal implements BlubSounds, SwimmingBehavior {
    @Override
    protected String getName() {
        return "Fish";
    }
}
