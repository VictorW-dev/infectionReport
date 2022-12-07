package br.com.ufape.aedii.grafos;
import java.time.LocalDate;
import java.util.Date;

public class Paciente {
    private String Nome;
    private LocalDate DataPossivelInfeccao;

    public Paciente(String nome){
        setNome(nome);
    }

    public LocalDate getDataPossivelInfeccao() {
        return DataPossivelInfeccao;
    }

    public void setDataPossivelInfeccao(LocalDate dataPossivelInfeccao) {
        DataPossivelInfeccao = dataPossivelInfeccao;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
