package com.ifpb.edu.so;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LeitoresEscritores {
    // Recurso compartilhado
    public static int recursoCompartilhado = 0;

    // Lock para gerenciar leitores e escritores
    public static final ReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        // Criando threads leitores e escritores
        Thread leitor1 = new Thread(new Leitor(), "Leitor 1");
        Thread leitor2 = new Thread(new Leitor(), "Leitor 2");
        Thread escritor1 = new Thread(new Escritor(), "Escritor 1");

        // Iniciando as threads
        leitor1.start();
        leitor2.start();
        escritor1.start();
    }
}
