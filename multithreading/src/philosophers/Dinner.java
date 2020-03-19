package philosophers;

public class Dinner {
    private static final int NUMBER_OF_PERSONS = 5;

    public static void main(String[] args) {
        Fork[] fork = new Fork[NUMBER_OF_PERSONS];

        for (int i = 0; i < fork.length; i++) {
            fork[i] = new Fork("№" + i);

        }
        for (int i = 0; i < NUMBER_OF_PERSONS; ) {
            new Philosopher("P №" + i, fork[i], fork[++i % NUMBER_OF_PERSONS]).start();
        }
    }
}




