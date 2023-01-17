import resource.*;
import threads.*;

public class App {

    public static void main(String[] args) {
        Market mercado = new Market(10);

        Farmer oscar = new Farmer(mercado, "Óscar", 5, 4000);
        Client juan = new Client(mercado, "Juan", 5, 4000);
        
        oscar.start();
        juan.start();
    }
}