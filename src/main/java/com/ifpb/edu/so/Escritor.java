package com.ifpb.edu.so;

public class Escritor implements Runnable {
    @Override
    public void run() {
        try {
            Semaphores.bloqEscritor.acquire();
            System.out.println("Escritor "+Thread.currentThread().getName() + " está escrevendo");
            Thread.sleep(2500);
            System.out.println("Escritor "+Thread.currentThread().getName() + " terminou de escrever");
            Semaphores.bloqEscritor.release();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}