package org.rvalenzuela.hilos.ejemplossync;

import org.rvalenzuela.hilos.ejemplossync.runnable.Consumidor;
import org.rvalenzuela.hilos.ejemplossync.runnable.Panadero;

public class EjemploProductorConsumidor {
    public static void main(String[] args) {
        Panaderia p = new Panaderia();
        new Thread(new Panadero(p)).start();
        new Thread(new Consumidor(p)).start();
    }
}
