package threads;

import java.util.logging.Level;
import java.util.logging.Logger;

import enums.VegetablesEnum;
import resource.Market;

public class Client extends Thread {

    private Market market;
    private String nombre;
    private int cantidadDeConsumiciones;
    private int maxTiempoDeConsumir;

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Client(Market market, String nombre, int cantidadDeConsumiciones, int maxTiempoDeConsumir) {
        this.market = market;
        this.nombre = nombre;
        this.cantidadDeConsumiciones = cantidadDeConsumiciones;
        this.maxTiempoDeConsumir = maxTiempoDeConsumir;
    }

    public void run() {
        for (int i = 0; i < this.cantidadDeConsumiciones; i++) {
            try {
                VegetablesEnum vegetal = this.market.consumir();
                System.out.println(ANSI_GREEN + nombre + " ha consumido " + vegetal + ANSI_RESET);

                sleep((int) (Math.random() * this.maxTiempoDeConsumir));
            } catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}