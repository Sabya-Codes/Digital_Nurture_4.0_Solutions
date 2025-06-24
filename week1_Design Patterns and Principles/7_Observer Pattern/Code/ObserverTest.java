import java.util.*;

interface Observer {
    void update(String stock);
}

interface Stock {
    void register(Observer o);
    void deregister(Observer o);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stock;

    public void setStock(String stock) {
        this.stock = stock;
        notifyObservers();
    }

    public void register(Observer o) { observers.add(o); }
    public void deregister(Observer o) { observers.remove(o); }
    public void notifyObservers() {
        for (Observer o : observers) o.update(stock);
    }
}

class MobileApp implements Observer {
    public void update(String stock) {
        System.out.println("Mobile: " + stock);
    }
}

class WebApp implements Observer {
    public void update(String stock) {
        System.out.println("Web: " + stock);
    }
}

public class ObserverTest {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();
        Observer mob = new MobileApp();
        Observer web = new WebApp();
        market.register(mob);
        market.register(web);
        market.setStock("AAPL: 150");
    }
}
