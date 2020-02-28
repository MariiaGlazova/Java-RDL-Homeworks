package org.fundamentals.homework;

public interface SwimmingBehavior extends Behavior {
    @Override
    default String behave() {
        return "swim in the sea";
    }
}
