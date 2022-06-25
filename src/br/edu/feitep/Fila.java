package br.edu.feitep;

import java.util.Arrays;

public class Fila {

    private final int[] buffer;
    private int inicio, fim, n;

    public Fila(int tamanhoBuffer) {
        this.buffer = new int[tamanhoBuffer];
        this.inicio = 0;
        this.fim = 0;
        this.n = 0;
    }

    public void enfileirar(int numero) {

        buffer[fim] = numero;

        if(fim == buffer.length-1) {
            fim = 0; /* Garantir o enfileiramento circular */
        } else {
            fim +=1;

        }

        n++; /* Incrementa 1 no tamanho do buffer */

    }

    public int desenfileirar() {

        int primeiro = buffer[inicio];
        buffer[inicio] = 0; /* "Removendo" o valor do buffer */

        if(inicio == buffer.length-1) {
            inicio = 0; /* Garantir o enfileiramento circular */
        } else {
            inicio++;
        }

        n--;

        return primeiro;

    }

    public boolean isVazia() {
        return n == 0;
    }

    public boolean isCheia() {
        return n == buffer.length;
    }

    @Override
    public String toString() {
        return "Buffer: " + Arrays.toString(buffer);
    }

}