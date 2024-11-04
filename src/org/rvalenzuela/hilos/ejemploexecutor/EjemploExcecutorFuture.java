package org.rvalenzuela.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExcecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
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

        Future<String> resultado = executorService.submit(tarea);
        executorService.shutdown();
        System.out.println("Continuando con la ejecución del método main 1");

        //System.out.println(resultado.isDone());
        while (!resultado.isDone()){
            System.out.println("ejecutando tarea ...");
            TimeUnit.MILLISECONDS.sleep(1500);
        }

        System.out.println("Obtenemos resultado de la tarea: "+resultado.get());
        System.out.println("Finaliza la tarea: "+resultado.isDone());
    }
}
