package com.ifpb.edu.so;

import java.util.concurrent.Semaphore;

public class LeitoresEscritores {
    public static Semaphore bloqLeitor = new Semaphore(1);
    public static Semaphore bloqEscritor = new Semaphore(1);
    public static int contaLeitor = 0;
    
    public static void main(String[] args) throws Exception {
        
        Leitor leitor = new Leitor();
        Escritor escritor = new Escritor();
        
        Thread t1 = new Thread(leitor);
        Thread t2 = new Thread(leitor);
        Thread t3 = new Thread(leitor);
        Thread t4 = new Thread(leitor);
        Thread t5 = new Thread(escritor);
        Thread t6 = new Thread(escritor);

        t1.setName("thread 1");
        t2.setName("thread 2");
        t3.setName("thread 3");
        t4.setName("thread 4");
        t5.setName("thread 5");
        t6.setName("thread 6");
        
        t3.start();
        t1.start();
        t2.start();
        t4.start();
        t5.start();
        t6.start();
    }
}