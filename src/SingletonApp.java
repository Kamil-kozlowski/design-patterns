import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonApp {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20; i++) {
            executorService.submit(OneAndOnly::getInstance);
        }
    }
}

class OneAndOnly {
    private static volatile OneAndOnly instance;

    static OneAndOnly getInstance() {
        synchronized (OneAndOnly.class) {
            if (instance == null) {
                instance = new OneAndOnly();
            }
            return instance;
        }
    }

    private OneAndOnly() {
        System.out.println("You should see this message only once");
    }
}
