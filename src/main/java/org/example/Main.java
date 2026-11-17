package org.example;

public class Main {
    public static void main(String[] args) {
        int[] vetor = MatematicaUtil.gerarVetorAleatorio(1000, -9999, 9999);

        System.out.println("Vetor na ordem de geracao:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println("\n");

        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        for (int i = 0; i < vetor.length; i++) {
            lista.inserirOrdenado(vetor[i]);
        }

        System.out.println("Lista em ordem crescente:");
        lista.exibir();
        System.out.println();

        System.out.println("Lista em ordem decrescente:");
        lista.exibirReverso();
        System.out.println();

        lista.removerPrimos();

        System.out.println("Lista apos remocao dos numeros primos (ordem crescente):");
        lista.exibir();
        System.out.println("Tamanho final da lista: " + lista.tamanhoLista());
    }
}