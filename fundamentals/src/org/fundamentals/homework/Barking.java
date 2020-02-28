package org.fundamentals.homework;

public interface Barking extends Sounds {
    @Override
    default String soundsLike() {
        return "'woof-woof'";
    }
}
