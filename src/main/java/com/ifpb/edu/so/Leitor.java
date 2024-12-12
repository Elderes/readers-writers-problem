package com.ifpb.edu.so;

public class Leitor extends Thread {    
    @Override
    public void run() {
        try {
            //Acquire Section
            Semaphores.bloqLeitor.acquire();
            Semaphores.contaLeitor++;
            if (Semaphores.contaLeitor == 1) {
                Semaphores.bloqEscritor.acquire();
            }
            Semaphores.bloqLeitor.release();

            //Reading section
            System.out.println("Leitor "+Thread.currentThread().getName() + " Está lendo");
            Thread.sleep(1500);
            System.out.println("Leitor "+Thread.currentThread().getName() + " terminou de ler");

            //Releasing section
            Semaphores.bloqLeitor.acquire();
            Semaphores.contaLeitor--;
            if(Semaphores.contaLeitor == 0) {
                Semaphores.bloqEscritor.release();
            }
            Semaphores.bloqLeitor.release();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}