package br.edu.feitep.fabrica;

import br.edu.feitep.buffer.Fila;

import java.util.Random;

public class Produtor extends Thread {

    private Fila buffer;
    private long tempo;

    public Produtor(Fila buffer, long tempo) {
        this.buffer = buffer;
        this.tempo = tempo;
    }

    public void produzir() throws InterruptedException {

        int produto;

        while(true) {

            synchronized (buffer) {

                produto = new Random().nextInt(100) + 1; /* Produzir um numero pseudoaleatório de 1 a 100 */

                while (buffer.isCheia()) { /* Ao detectar a fila cheia, o produtor dorme */
                    System.out.println("Produtor aguardando espaço no buffer!");
                    buffer.wait();
                }

                buffer.enfileirar(produto);
                buffer.notify();

                System.out.println("# " + produto + " produzido com sucesso! #");

            }

            System.out.println(buffer.toString());
            sleep(tempo);

        }

    }

    @Override
    public void run() {
        try {
            produzir();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}