package org.rvalenzuela.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExcecutorFuture2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println("Tamaño del pool: "+ executorService.getPoolSize());
        System.out.println("Cantidad de tareas en cola: "+ executorService.getQueue().size());
        Callable<String> tarea = () -> {
            System.out.println("inicio de la tarea... ");
            try {
                System.out.println("Nombre del thread "+ Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Filaniza la tarea ...");

            return "Algun resusltaod importante de la tarea";
        };
        executorService.submit(tarea);

        Callable<Integer> tarea2 = () -> {
            System.out.println("iniando tarea 2 ...");
            TimeUnit.SECONDS.sleep(3);
            return 10;
        };

        Future<String> resultado = executorService.submit(tarea);
        Future<String> resultado2 = executorService.submit(tarea);
        Future<Integer> resultado3 = executorService.submit(tarea2);

        System.out.println("Tamaño del pool: "+ executorService.getPoolSize());
        System.out.println("Cantidad de tareas en cola: "+ executorService.getQueue().size());

        executorService.shutdown();
        System.out.println("Continuando con la ejecución del método main 1");

        //System.out.println(resultado.isDone());
        while (!(resultado.isDone() && resultado2.isDone() && resultado3.isDone())){
            System.out.println(String.format("Resultado1: %s - resustado2: %s -resultado3: %s",
                    resultado.isDone()?"Finalizó":"en proceso",
                    resultado2.isDone()?"Finalió":"en proceso",
                    resultado3.isDone()?"finalizó":"en proceso"));
            TimeUnit.MILLISECONDS.sleep(1000);
        }

        System.out.println("Obtenemos resultado de la tarea: "+resultado.get());
        System.out.println("Finaliza la tarea: "+resultado.isDone());
        System.out.println("Obtenemos resultado de la tarea2: "+resultado2.get());
        System.out.println("Finaliza la tarea: "+resultado2.isDone());
        System.out.println("Obtenemos resultado de la tarea3: "+resultado3.get());
        System.out.println("Finaliza la tarea: "+resultado3.isDone());
    }
}
