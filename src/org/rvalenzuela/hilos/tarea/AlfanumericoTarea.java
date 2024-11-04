package org.rvalenzuela.hilos.tarea;

import java.io.IOException;

public class AlfanumericoTarea implements Runnable{
    private static Tipo tipo;

    public static void main(String[] args) throws IOException {

        Object inData = System.in.read();


        System.out.println(tipo);

    }
    @Override
    public void run() {
        for (int i=1; i<10;i++){
            System.out.println("numeros "+i);
        }
    }

}
