package threads;

import resource.*;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import enums.VegetablesEnum;

public class Farmer extends Thread {
    
    private Market market;
    private String nombre;
    private int cantidadDeVegetales;
    private int maxTiempoDeProduccion;

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Farmer(Market market, String nombre, int cantidadDeVegetales, int maxTiempoDeProduccion){
        this.market = market;
        this.nombre = nombre;
        this.cantidadDeVegetales = cantidadDeVegetales;
        this.maxTiempoDeProduccion = maxTiempoDeProduccion;
    }
    
    public void run(){
        
        for (int i = 0; i < this.cantidadDeVegetales; i++) {
            try {
                int indiceAleatorio = new Random().nextInt(VegetablesEnum.values().length);
                VegetablesEnum vegetal = VegetablesEnum.values()[indiceAleatorio];

                market.producir(vegetal);
                System.out.println(ANSI_RED + nombre + " ha depositado " + vegetal + ANSI_RESET);
                
                sleep((int) (Math.random() * this.maxTiempoDeProduccion));
            } catch (InterruptedException ex) {
                Logger.getLogger(Farmer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}