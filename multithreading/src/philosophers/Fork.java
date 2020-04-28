package philosophers;

import java.util.concurrent.locks.ReentrantLock;

class Fork {
    private final String name;
    private final ReentrantLock locker = new ReentrantLock();

    public Fork(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean take() {
        return locker.tryLock();
    }

    public void release() {
        locker.unlock();
    }
}
