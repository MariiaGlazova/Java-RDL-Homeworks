package org.fundamentals.homework;

public abstract class Animal implements Sounds, Behavior {
    protected abstract String getName();

    String getDescription() {
        return getName() + " says " + soundsLike() + " and " + behave() + ".";
    }
}
