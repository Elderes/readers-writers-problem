package com.ifpb.edu.so;

public class Escritor implements Runnable {
    @Override
    public void run() {
        while (true) {
            // Escritores usam o lock de escrita
            LeitoresEscritores.lock.writeLock().lock();
            try {
                LeitoresEscritores.recursoCompartilhado++;
                System.out.println(Thread.currentThread().getName() +
                        " escreveu no recurso: " + LeitoresEscritores.recursoCompartilhado);
            } finally {
                LeitoresEscritores.lock.writeLock().unlock(); // Libera o lock de escrita
            }
            try {
                Thread.sleep(2000); // Simula tempo de escrita
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
