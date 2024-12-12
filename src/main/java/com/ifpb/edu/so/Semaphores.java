package com.ifpb.edu.so;

import java.util.concurrent.Semaphore;

public class Semaphores {
    public static Semaphore bloqLeitor = new Semaphore(1);
    public static Semaphore bloqEscritor = new Semaphore(1);
    public static int contaLeitor = 0;

}
