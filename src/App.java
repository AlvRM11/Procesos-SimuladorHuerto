import resource.*;
import threads.*;

public class App {

    public static void main(String[] args) {
        Market mercado = new Market(5);

        Farmer adrian = new Farmer(mercado, "Adrián", 5, 4000);
        Client goyo = new Client(mercado, "Goyo", 5, 4000);
        
        adrian.setPriority(Thread.MAX_PRIORITY);
        
        adrian.start();
        goyo.start();
    }
}