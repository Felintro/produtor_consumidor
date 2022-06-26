package br.edu.feitep;

import br.edu.feitep.buffer.Fila;
import br.edu.feitep.fabrica.Consumidor;
import br.edu.feitep.fabrica.Produtor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("======== Bem vindo ao PRODUTOR-CONSUMIDOR ==========");
        System.out.println("======== Insira o intevalo desejado (em ms): =======");
        System.out.println("======== Recomendados: 500, 1000, 2000 =============");

        long tempo = scanner.nextLong();

        Fila buffer = new Fila(20);
        Produtor produtor = new Produtor(buffer, tempo);
        Consumidor consumidor = new Consumidor(buffer, (long) (tempo*1.2));
        Produtor produtor2 = new Produtor(buffer, tempo);
        Consumidor consumidor2 = new Consumidor(buffer, (long) (tempo*1.2));

        produtor.start();
        System.out.println("Produtor iniciado!");
        produtor2.start();
        System.out.println("Produtor 2 iniciado!");

        consumidor.start();
        System.out.println("Consumidor iniciado!");
        consumidor2.start();
        System.out.println("Consumidor 2 iniciado!");

        produtor.join();
        produtor2.join();
        consumidor.join();
        consumidor2.join();

        scanner.close();

    }
}