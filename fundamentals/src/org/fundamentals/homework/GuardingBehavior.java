package org.fundamentals.homework;

public interface GuardingBehavior extends Behavior {
    @Override
    default String behave() {
        return "guard its shelter";
    }
}
