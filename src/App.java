import resource.*;
import threads.*;

public class App {

    public static void main(String[] args) {
        Market mercado = new Market(5);

        Farmer adrian = new Farmer(mercado, "Adrián", 5, 2000);
        Client goyo = new Client(mercado, "Goyo", 5, 8000);
        
        adrian.start();
        goyo.start();
    }
}