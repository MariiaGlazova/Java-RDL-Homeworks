package org.fundamentals.homework;

public interface BlubSounds extends Sounds {
    @Override
    default String soundsLike() {
        return "'blub'";
    }
}
