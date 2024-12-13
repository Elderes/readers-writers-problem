package com.ifpb.edu.so;

import java.util.concurrent.Semaphore;

/**
 * A classe Semaphores centraliza a gestão de recursos compartilhados no problema dos
 * leitores e escritores. Fornece semáforos para controlar o acesso de leitores e escritores,
 * além de um contador para monitorar o número de leitores ativos.
 */
public class Semaphores {
    /**
     * Semáforo usado para controlar o acesso dos leitores ao recurso compartilhado.
     * Garante que as operações de leitura sejam realizadas de forma sincronizada.
     */
    public static Semaphore bloqLeitor = new Semaphore(1);
    /**
     * Semáforo usado para controlar o acesso dos escritores ao recurso compartilhado.
     * Garante exclusão mútua, permitindo apenas um escritor por vez.
     */
    public static Semaphore bloqEscritor = new Semaphore(1);
    /**
     * Contador que monitora o número de leitores simultaneamente ativos.
     * É usado para permitir que múltiplos leitores leiam simultaneamente,
     * desde que não haja escritores acessando o recurso.
     */
    public static int contaLeitor = 0;

}
