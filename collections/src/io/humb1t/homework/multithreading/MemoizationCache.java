package io.humb1t.homework.multithreading;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoizationCache {

    static Map<Integer, Integer> cache = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        System.out.println(square(5));
        System.out.println(square(5));
        System.out.println(square(67));
    }

    private static Integer square(Integer number) {
        return (number != null) ? cache.computeIfAbsent(number, square -> square * square) : 0;
    }
}
