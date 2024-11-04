package org.rvalenzuela.hilos.ejemplotimer;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAgendarTareaPeriodo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        AtomicInteger contadorAtomic = new AtomicInteger(3);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int i = contadorAtomic.getAndDecrement();
                if(i>0){
                    toolkit.beep();
                    System.out.println("Tarea "+i+" periódica en: "+ new Date() + " Nombre del thread: " + Thread.currentThread().getName());
                } else {

                    System.out.println("Finaliza el tiempo");
                    timer.cancel();
                }
            }
        }, 5000,10000);
        System.out.println("Agendamos una tarea para 5 segundos más ...");
    }
}
