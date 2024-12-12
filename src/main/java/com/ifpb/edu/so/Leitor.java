package com.ifpb.edu.so;

public class Leitor implements Runnable {
    @Override
    public void run() {
        while (true) {
            // Leitores usam o lock de leitura
            LeitoresEscritores.lock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() +
                        " leu o recurso: " + LeitoresEscritores.recursoCompartilhado);
            } finally {
                LeitoresEscritores.lock.readLock().unlock(); // Libera o lock de leitura
            }
            try {
                Thread.sleep(1000); // Simula tempo de leitura
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
