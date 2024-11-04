package org.rvalenzuela.hilos.ejemplos.thread;

public class NombreThread  extends Thread{
    public NombreThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Se inicia el método run del hilo: " + getName());
        for (int i = 0; i<9; i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName());
        }
        System.out.println("finaliza el hilo");
    }
}
