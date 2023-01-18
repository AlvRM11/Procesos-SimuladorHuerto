package resource;

import java.util.logging.Level;
import java.util.logging.Logger;

import enums.VegetablesEnum;

public class Market {

    private VegetablesEnum[] lista;
    private int indice;
    private boolean estaVacia;
    private boolean estaLlena;
    
    public Market(int tamanio) {
        this.lista = new VegetablesEnum[tamanio];
        this.indice = 0;
        this.estaVacia = true;
        this.estaLlena = false;
    }

    public synchronized void producir(VegetablesEnum vegetable) {

        while (this.estaLlena) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Market.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        lista[indice] = vegetable;
        indice++;
        this.estaVacia = false;
        
        if (indice == this.lista.length) {
            this.estaLlena = true;
        }
        
        notifyAll();
    }
    
    public synchronized VegetablesEnum consumir() {

        while (this.estaVacia) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Market.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        indice--;
        this.estaLlena = false;

        if (indice == 0) {
            this.estaVacia = true;
        }
        
        notifyAll();
        
        return this.lista[this.indice];
    }
    
}