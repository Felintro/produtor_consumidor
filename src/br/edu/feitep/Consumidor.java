package br.edu.feitep;

public class Consumidor extends Thread {

    private Fila buffer;
    private long tempo;

    public Consumidor(Fila buffer, long tempo) {
        this.buffer = buffer;
        this.tempo = tempo;
    }

    public void consumir() throws InterruptedException {

        while(true) {

            synchronized (buffer) {

                while (buffer.isVazia()) { /* Ao detectar a fila vazia, o consumidor dorme */
                    System.out.println("Consumidor aguardando produção no buffer!");

                    buffer.wait();
                }

                int produto = buffer.desenfileirar();
                buffer.notify();

                System.out.println("# " + produto + " consumido com sucesso! #");

            }

            System.out.println(buffer.toString());
            sleep(tempo);

        }

    }

    @Override
    public void run() {
        try {
            consumir();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}