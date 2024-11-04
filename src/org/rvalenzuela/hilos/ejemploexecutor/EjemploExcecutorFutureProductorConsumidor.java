package org.rvalenzuela.hilos.ejemploexecutor;

import org.rvalenzuela.hilos.ejemplossync.Panaderia;
import org.rvalenzuela.hilos.ejemplossync.runnable.Consumidor;
import org.rvalenzuela.hilos.ejemplossync.runnable.Panadero;

import java.util.concurrent.*;

public class EjemploExcecutorFutureProductorConsumidor {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println("Tamaño del pool: "+ executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: "+ executor.getQueue().size());

        Panaderia p = new Panaderia();
        Runnable productor = new Panadero(p);
        Runnable consumidor = new Consumidor(p);

        Future<?> futuro1 = executor.submit(productor);
        Future<?> futuro2 = executor.submit(consumidor);



        System.out.println("Tamaño del pool: "+ executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: "+ executor.getQueue().size());
        
        executor.shutdown();


    }
}
