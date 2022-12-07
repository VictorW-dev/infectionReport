package br.com.ufape.aedii.grafos;
public class Aresta<T> {
    private Vertice<T> inicio;
    private Vertice<T> fim;
    private int peso;

    public Aresta(Vertice<T> inicio, Vertice<T> fim, int peso) {
        this.inicio = inicio;
        this.fim = fim;
        this.peso = peso;
    }

    public int getPeso(){return peso;}

    public Vertice<T> getInicio() {
        return inicio;
    }

    public void setInicio(Vertice<T> inicio) {
        this.inicio = inicio;
    }

    public Vertice<T> getFim() {
        return fim;
    }

    public void setFim(Vertice<T> fim) {
        this.fim = fim;
    }
}
