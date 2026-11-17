package org.example;

public class No {
    int valor;
    No anterior;
    No proximo;

    public No(int valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }
}