package org.fundamentals.homework;

public class UnknownAnimal extends Animal {

    private String name;

    UnknownAnimal(String name) {
        this.name = name;
    }

    @Override
    protected String getName() {
        return name;
    }

    @Override
    public String soundsLike() {
        return "unknown sound";
    }

    @Override
    public String behave() {
        return "has unclear behavior";
    }
}
