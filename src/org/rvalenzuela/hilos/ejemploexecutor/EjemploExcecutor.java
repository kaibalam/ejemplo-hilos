package org.rvalenzuela.hilos.ejemploexecutor;

import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploExcecutor {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Runnable tarea = () -> {
            System.out.println("inicio de la tarea... ");
            try {
                System.out.println("Nombre del thread "+ Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Filaniza la tarea ...");
        };
        executorService.submit(tarea);
        executorService.shutdown();
        System.out.println("Continuando con la ejecución del método main 1");
        executorService.awaitTermination(2,TimeUnit.SECONDS);
        System.out.println("Continuando con la ejecución del método main 2");
    }
}
