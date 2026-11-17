package org.example;

public class ListaDuplamenteEncadeada {
    No inicio;
    No fim;
    int tamanho;

    public ListaDuplamenteEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public boolean estaVazia() {
        return this.inicio == null;
    }

    public int tamanhoLista() {
        return this.tamanho;
    }

    public void esvaziar() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void inserirInicio(int valor) {
        No novoNo = new No(valor);
        if (estaVazia()) {
            this.inicio = novoNo;
            this.fim = novoNo;
        } else {
            novoNo.proximo = this.inicio;
            this.inicio.anterior = novoNo;
            this.inicio = novoNo;
        }
        this.tamanho++;
    }

    public void inserirMeio(int posicao, int valor) {
        if (posicao <= 0) {
            inserirInicio(valor);
        } else if (posicao >= this.tamanho) {
            inserirFim(valor);
        } else {
            No novoNo = new No(valor);
            No atual = this.inicio;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.proximo;
            }
            novoNo.proximo = atual.proximo;
            novoNo.anterior = atual;
            atual.proximo.anterior = novoNo;
            atual.proximo = novoNo;
            this.tamanho++;
        }
    }

    public void inserirFim(int valor) {
        No novoNo = new No(valor);
        if (estaVazia()) {
            this.inicio = novoNo;
            this.fim = novoNo;
        } else {
            this.fim.proximo = novoNo;
            novoNo.anterior = this.fim;
            this.fim = novoNo;
        }
        this.tamanho++;
    }

    public void inserirOrdenado(int valor) {
        if (estaVazia() || valor <= this.inicio.valor) {
            inserirInicio(valor);
        } else if (valor >= this.fim.valor) {
            inserirFim(valor);
        } else {
            No novoNo = new No(valor);
            No atual = this.inicio;
            while (atual != null && atual.valor < valor) {
                atual = atual.proximo;
            }
            novoNo.proximo = atual;
            novoNo.anterior = atual.anterior;
            atual.anterior.proximo = novoNo;
            atual.anterior = novoNo;
            this.tamanho++;
        }
    }

    public void removerInicio() {
        if (estaVazia()) {
            return;
        }
        if (this.inicio == this.fim) {
            this.inicio = null;
            this.fim = null;
        } else {
            this.inicio = this.inicio.proximo;
            this.inicio.anterior = null;
        }
        this.tamanho--;
    }

    public void removerFim() {
        if (estaVazia()) {
            return;
        }
        if (this.inicio == this.fim) {
            this.inicio = null;
            this.fim = null;
        } else {
            this.fim = this.fim.anterior;
            this.fim.proximo = null;
        }
        this.tamanho--;
    }

    public void removerMeio(int posicao) {
        if (estaVazia() || posicao < 0 || posicao >= this.tamanho) {
            return;
        }
        if (posicao == 0) {
            removerInicio();
        } else if (posicao == this.tamanho - 1) {
            removerFim();
        } else {
            No atual = this.inicio;
            for (int i = 0; i < posicao; i++) {
                atual = atual.proximo;
            }
            atual.anterior.proximo = atual.proximo;
            atual.proximo.anterior = atual.anterior;
            this.tamanho--;
        }
    }

    public void remover(int valor) {
        No atual = this.inicio;
        while (atual != null) {
            if (atual.valor == valor) {
                if (atual == this.inicio) {
                    removerInicio();
                } else if (atual == this.fim) {
                    removerFim();
                } else {
                    atual.anterior.proximo = atual.proximo;
                    atual.proximo.anterior = atual.anterior;
                    this.tamanho--;
                }
                break;
            }
            atual = atual.proximo;
        }
    }

    public void removerPrimos() {
        No atual = this.inicio;
        while (atual != null) {
            No proximoNo = atual.proximo;
            if (MatematicaUtil.ehPrimo(atual.valor)) {
                if (atual == this.inicio) {
                    removerInicio();
                } else if (atual == this.fim) {
                    removerFim();
                } else {
                    atual.anterior.proximo = atual.proximo;
                    atual.proximo.anterior = atual.anterior;
                    this.tamanho--;
                }
            }
            atual = proximoNo;
        }
    }

    public boolean buscar(int valor) {
        No atual = this.inicio;
        while (atual != null) {
            if (atual.valor == valor) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public void exibir() {
        if (estaVazia()) {
            System.out.println("Lista vazia");
            return;
        }
        No atual = this.inicio;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public void exibirReverso() {
        if (estaVazia()) {
            System.out.println("Lista vazia");
            return;
        }
        No atual = this.fim;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.anterior;
        }
        System.out.println();
    }
}