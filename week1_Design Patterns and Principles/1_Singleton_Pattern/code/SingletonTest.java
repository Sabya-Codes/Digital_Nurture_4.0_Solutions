class Logger {
    private static Logger instance;
    private Logger() {}
    public static Logger getInstance() {
        if (instance == null) instance = new Logger();
        return instance;
    }
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

public class SingletonTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log("Message 1");
        logger2.log("Message 2");
        System.out.println(logger1 == logger2);
    }
}
