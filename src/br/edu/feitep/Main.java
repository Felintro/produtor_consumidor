package br.edu.feitep;

import br.edu.feitep.buffer.Fila;
import br.edu.feitep.fabrica.Consumidor;
import br.edu.feitep.fabrica.Produtor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("======== Bem vindo ao PRODUTOR-CONSUMIDOR ==========");
        System.out.println("======== Insira o intervalo desejado (em ms): ======");
        System.out.println("======== Recomendados: 500, 1000, 2000 =============");
        long tempo = scanner.nextLong();

        System.out.println("======== Quantas threads produtores deseja iniciar? ======");
        int qtdeProdutores = scanner.nextInt();

        System.out.println("======== Quantas threads consumidores deseja iniciar? ======");
        int qtdeConsumidores = scanner.nextInt();

        System.out.println("======== Insira o tamanho do buffer desejado: ==============");
        int tamanhoBuffer = scanner.nextInt();

        scanner.close();

        Fila buffer = new Fila(tamanhoBuffer);
        Produtor produtores[] = new Produtor[qtdeProdutores];
        Consumidor consumidores[] = new Consumidor[qtdeConsumidores];

        for(int i = 0; i < qtdeProdutores; i++) {
            produtores[i] = new Produtor(buffer, tempo);
            System.out.println("Produtor nº" + i + " preparado!");
        }

        System.out.println("");

        for(int i = 0; i < qtdeConsumidores; i++) {
            consumidores[i] = new Consumidor(buffer, tempo);
            System.out.println("Consumidor nº" + i + " preparado!");
        }

        System.out.println("");
        System.out.println("Teste do buffer: " + buffer.toString());
        System.out.println("");

        for(int i = 0; i < qtdeProdutores; i++) {
            produtores[i].start();
            System.out.println("Produtor nº" + i + " lançado!");
        }

        System.out.println("");

        for(int i = 0; i < qtdeConsumidores; i++) {
            consumidores[i].start();
            System.out.println("Consumidor nº" + i + " lançado!");
        }

        for(int i = 0; i < qtdeProdutores; i++) {
            produtores[i].join();
        }

        for(int i = 0; i < qtdeConsumidores; i++) {
            consumidores[i].join();
        }

    }

}