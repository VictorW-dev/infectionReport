package br.com.ufape.aedii.grafos;
import java.time.LocalDate;
import java.util.ArrayList;

public class Vertice<T> {
    private T dado;
    private ArrayList<Aresta<T>> arestasEntrada;
    private ArrayList<Aresta<T>> arestasSaida;
    private int grauEntrada;
    private int grauSaida;

    public Vertice(T valor){
        this.dado = valor;
        this.arestasEntrada = new ArrayList<Aresta<T>>();
        this.arestasSaida = new ArrayList<Aresta<T>>();
        setGrauEntrada(0);
        setGrauSaida(0);
    }

    public void addArestaEntrada(Aresta<T> aresta){
        imcrementarGrauEntrada();
        this.arestasEntrada.add(aresta);

    }

    public void addArestaSaida(Aresta<T> aresta){
        imcrementarGrauSaida();
        this.arestasSaida.add(aresta);
    }

    private void imcrementarGrauSaida(){
        setGrauSaida(getGrauSaida() + 1);
    }

    private void imcrementarGrauEntrada(){
        setGrauEntrada(getGrauEntrada() + 1);
    }

    public int getGrauEntrada() {
        return grauEntrada;
    }

    public void setGrauEntrada(int grauEntrada) {
        this.grauEntrada = grauEntrada;
    }

    public int getGrauSaida() {
        return grauSaida;
    }

    public void setGrauSaida(int grauSaida) {
        this.grauSaida = grauSaida;
    }

    public T getDado() {
        return dado;
    }

    public LocalDate getDataDado() {
        Paciente paciente = (Paciente) dado;
        return paciente.getDataPossivelInfeccao();
    }
    public void setDataDado(LocalDate date) {
        Paciente paciente = (Paciente) dado;
        paciente.setDataPossivelInfeccao(date);
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public ArrayList<Aresta<T>> getArestasEntrada() {
        return arestasEntrada;
    }

    public void setArestasEntrada(ArrayList<Aresta<T>> arestasEntrada) {
        this.arestasEntrada = arestasEntrada;
    }

    public ArrayList<Aresta<T>> getArestasSaida() {
        return arestasSaida;
    }

    public void setArestasSaida(ArrayList<Aresta<T>> arestasSaida) {
        this.arestasSaida = arestasSaida;
    }
}
