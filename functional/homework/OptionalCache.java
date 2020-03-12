package homework;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class OptionalCache {
    static Map<Integer, Integer> cache = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        System.out.println(square(null));
        System.out.println(square(5));
        System.out.println(square(5));
        System.out.println(square(67));
    }

    private static Integer square(Integer number) {
        return Optional.ofNullable(number).isPresent() ? cache.computeIfAbsent(number, square -> square * square) : null;
    }
}
