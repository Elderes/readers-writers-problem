package com.ifpb.edu.so;

/**
 * A classe Leitor implementa a interface Runnable e simula o comportamento de um leitor
 * que acessa um recurso compartilhado controlado por semáforos. O leitor verifica se é
 * permitido ler, simula a leitura e libera o recurso após terminar.
 */
public class Leitor extends Thread {    
    /**
     * Método que será executado quando o objeto Leitor for usado em uma thread.
     * O método tenta adquirir um semáforo para realizar a leitura,
     * simula o tempo de leitura com um intervalo, e depois libera o semáforo.
     */
    @Override
    public void run() {
        try {
            // Tenta adquirir o semáforo para iniciar a leitura
            Semaphores.bloqLeitor.acquire();
            Semaphores.contaLeitor++;
            // Se for o primeiro leitor a chegar, bloqueia o acesso a escritores.
            if (Semaphores.contaLeitor == 1) {
                Semaphores.bloqEscritor.acquire();
            }
            // Libera o semáforo para que outro leitor possa compartilhar o recurso.
            Semaphores.bloqLeitor.release();

            System.out.println("Leitor " + Thread.currentThread().getName() + " Está lendo");
            // Simula o tempo gasto na leitura (2,5 segundos)
            Thread.sleep(1500);
            System.out.println("Leitor " + Thread.currentThread().getName() + " terminou de ler");

            // Adquire o semáforo antes de decrementá-lo
            Semaphores.bloqLeitor.acquire();
            Semaphores.contaLeitor--;
            // Se for o último leitor, libera o semáforo para os escritores
            if(Semaphores.contaLeitor == 0) {
                Semaphores.bloqEscritor.release();
            }
            // Por último, libera o semáforo para outros leitores
            Semaphores.bloqLeitor.release();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}