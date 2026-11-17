package org.example;

public class MatematicaUtil {

    public static int[] gerarVetorAleatorio(int tamanho, int min, int max) {
        int[] vetor = new int[tamanho];
        int intervalo = (max - min) + 1;
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = (int) (Math.random() * intervalo) + min;
        }
        return vetor;
    }

    public static boolean ehPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        if (numero == 2) {
            return true;
        }
        if (numero % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= numero; i += 2) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}