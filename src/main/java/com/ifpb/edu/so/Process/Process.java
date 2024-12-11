package com.ifpb.edu.so.Process;

public abstract class Process {

    private String name;

    /* Define a situação em que o processo se encontra.
     * Quando verdadeiro, indica que o processo está
     * "acordado" ou disponível para execução. Quando
     * falso, indica que o processo está "dormindo" ou
     * indisponível, e precisa ficar disponível antes
     * de poder ser executado.
     */
    private boolean situation;

    /* Define o estado em que o processo se encontra.
     * Quando verdadeiro, indica que o processo está
     * sendo executado. Quando falso, indica que o
     * processo está em modo de espera.
     */
    private boolean state;

    private int processing;

    /* O construtor de Process inicia com o processo
     * "acordado" mas em modo de espera.
     */
    public Process(String name) {
        this.name = name;
        this.situation = true; 
        this.state = false;
    }

}
