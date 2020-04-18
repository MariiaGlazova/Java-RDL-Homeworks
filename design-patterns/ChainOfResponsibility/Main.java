
package ChainOfResponsibility;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        IHandler primeNumberHandler = new PrimeNumberHandler();
        IHandler evenNumberHandler = new EvenNumberHandler();
        IHandler dividedByThreeNumberHandler = new DivideByThreeNumberHandler();
        IHandler errorHandler = new ErrorHandler();

        dividedByThreeNumberHandler.setNextHandler(errorHandler);
        evenNumberHandler.setNextHandler(dividedByThreeNumberHandler);
        primeNumberHandler.setNextHandler(evenNumberHandler);

        int[] array = new int[30];
        Arrays.setAll(array, i -> (int) (Math.random() * 1000) + 11);
        for (int i : array) {
            primeNumberHandler.handle(new Request(i));
        }
    }
}
