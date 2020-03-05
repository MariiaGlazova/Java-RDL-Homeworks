package io.humb1t.homework;
import java.util.HashMap;
import java.util.TreeMap;

public class Benchmark {

    private static final HashMap<Integer, String> hashMap = new HashMap<>();
    private static final TreeMap<Integer, String> treeMap = new TreeMap<>();

    public static void main(String[] args) {
        System.out.println("-------------------------------------------------");
        put(1000_000);
        System.out.println("-------------------------------------------------");
        read();
        System.out.println("-------------------------------------------------");
        delete();
        System.out.println("-------------------------------------------------");
        put(10_000_000);
        System.out.println("-------------------------------------------------");
        read();
        System.out.println("-------------------------------------------------");
        delete();
        System.out.println("-------------------------------------------------");
    }


    public static void put(int number) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < number; i++) {
            hashMap.put(i, "");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("HashMap put " + number + " elements. Execution time: " + (endTime - startTime) + "ms");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < number; i++) {
            treeMap.put(i, "");
        }
        endTime = System.currentTimeMillis();
        System.out.println("TreeMap put " + number + " elements. Execution time: " + (endTime - startTime) + "ms");
    }


    public static void read() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < hashMap.size(); i++) {
            hashMap.get(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("HashMap read "+ hashMap.size() + " elements. Execution time: " + (endTime - startTime) + "ms");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < treeMap.size(); i++) {
            treeMap.get(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("TreeMap read "+ treeMap.size() + " elements. Execution time: " + (endTime - startTime) + "ms");
    }

    public static void delete() {
        long startTime = System.currentTimeMillis();
        int size = hashMap.size();
        for (int i = 0; i < size; i++) {
            hashMap.remove(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("HashMap delete " + size + " elements. Execution time: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            treeMap.remove(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("TreeMap delete " + size + " elements. Execution time: " + (endTime - startTime) + "ms");
    }

}
