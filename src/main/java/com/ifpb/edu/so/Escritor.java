package com.ifpb.edu.so;

/**
 * A classe Escritor implementa a interface Runnable e simula o comportamento de um escritor
 * que acessa um recurso compartilhado controlado por semáforos. O escritor precisa adquirir
 * o semáforo antes de iniciar a escrita e libera o semáforo ao finalizar.
 */
public class Escritor implements Runnable {

    /**
     * Método que será executado quando o objeto Escritor for usado em uma thread.
     * O método tenta adquirir um semáforo para realizar a escrita,
     * simula o tempo de escrita com um intervalo, e depois libera o semáforo.
     */
    @Override
    public void run() {
        try {
            // Tenta adquirir o semáforo para iniciar a escrita
            Semaphores.bloqEscritor.acquire();
            System.out.println("Escritor " + Thread.currentThread().getName() + " está escrevendo");

            // Simula o tempo gasto na escrita (2,5 segundos)
            Thread.sleep(2500);

            System.out.println("Escritor " + Thread.currentThread().getName() + " terminou de escrever");

            // Libera o semáforo após concluir a escrita
            Semaphores.bloqEscritor.release();
        } catch (InterruptedException e) {
            // Trata a interrupção da thread, exibindo a mensagem de erro
            System.out.println(e.getMessage());
        }
    }
}