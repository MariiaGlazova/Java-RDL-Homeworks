package singleton;

public class LazySingleton {
    private static volatile LazySingleton instance;

    public static LazySingleton getInstance() {
        LazySingleton someInstance = instance;
        if (someInstance == null) {
            synchronized (LazySingleton.class) {
                someInstance = instance;
                if (someInstance == null) {
                    instance = someInstance = new LazySingleton();
                }
            }
        }
        return someInstance;
    }
}
