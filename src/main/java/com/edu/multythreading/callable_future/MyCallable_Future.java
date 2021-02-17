package com.edu.multythreading.callable_future;

import java.util.concurrent.*;

import static sun.swing.SwingUtilities2.submit;

public class MyCallable_Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable task = ()->{
            return "Hello World";
        };
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> result =  executor.submit(task);
        System.out.println(result.get());
        executor.shutdown();
    }
}
