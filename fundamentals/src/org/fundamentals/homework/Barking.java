package org.fundamentals.homework;

public interface BarkingSounds extends Sounds {
    @Override
    default String soundsLike() {
        return "'woof-woof'";
    }
}
