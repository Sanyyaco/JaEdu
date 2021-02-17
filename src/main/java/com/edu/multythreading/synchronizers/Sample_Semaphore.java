package com.edu.multythreading.synchronizers;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

public class Sample_Semaphore {

    private static int number_of_places = 1;
    private static int number_of_cars = 6;
    private static final String PARKING = "PARKING";
    private static final Semaphore SEMAPHORE = new Semaphore(number_of_places, true);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Parking with "+ number_of_places +" car-place");
        for (int i = 1; i <= number_of_cars; i++){
            new Thread(new Car(i)).start();
            Thread.sleep(400);
        }
    }

    @AllArgsConstructor
    static class Car implements Runnable{

        private int carNumber;

        @SneakyThrows
        @Override
        public void run() {
            System.out.println("Car # " + carNumber+ " on enter to parking");

            SEMAPHORE.acquire();
            System.out.println("Car # " + carNumber+ " tries to enter parking");

            System.out.println("Car # " + carNumber+ " enters parking");
            System.out.println("Car # " + carNumber+ " occupies " + PARKING);
            System.out.println("Car # " + carNumber+ " waits");
            Thread.sleep(3000);

            SEMAPHORE.release();
            System.out.println("Car # " + carNumber+ " leaves parking");
        }
    }
}
