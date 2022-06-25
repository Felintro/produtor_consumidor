package br.edu.feitep;

import java.util.Arrays;
import java.util.Random;

public class Buffer {

    private final int[] buffer;
    private int n;

    public Buffer(int tamanhoBuffer) {
        this.buffer = new int[tamanhoBuffer];
        this.n = 0;
    }

    public void inserir(int numero) {

        if(isCheia()) {
            return;
        } else {
            buffer[new Random().nextInt(buffer.length)] = numero; /* Insere numero em uma posição aleatória */
            n++; /* Incrementa 1 no tamanho do buffer */
        }

    }

    public int remover() {

        int posicao = new Random().nextInt(buffer.length);
        int valor = buffer[posicao];

        if (valor == 0){
            return 0;
        } else {
            buffer[posicao] = 0; /* "Removendo" o valor do buffer */
            n--; /* Decrementa 1 no tamanho do buffer */
            return valor;
        }

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