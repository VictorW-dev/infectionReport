package br.com.ufape.aedii.grafos;
import java.time.LocalDate;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.DAYS;

public class Grafo<T> {
    private ArrayList<Vertice<T>> vertices;
    private ArrayList<Aresta<T>> arestas;

    public Grafo(){
        this.vertices = new ArrayList<Vertice<T>>();
        this.arestas = new ArrayList<Aresta<T>>();
    }

    public void adicionarVertice(T dado){
        Vertice<T> novoVertice = new Vertice<T>(dado);
        this.vertices.add(novoVertice);
    }

    public void adicionarAresta(T inicio, T fim, LocalDate dataInicial, int diasDeContato){
        Vertice<T> i = this.getVertice(inicio);
        Vertice<T> f = this.getVertice(fim);

        int peso = 0;

        LocalDate dataPossivelInfeccaoVerticeInicio = i.getDataDado();
        f.setDataDado(dataInicial.plusDays(diasDeContato));

        long diasDeDiferenca = Math.abs(DAYS.between(dataPossivelInfeccaoVerticeInicio, f.getDataDado()));

        // independente do período de contato de um paciente B e C, se o peso de quem teve contato com B já tiver sido 3,
        // não existe a chance de C precisar de quarentena, pois A e B já tiveram um contato seguro.
        if (i.getArestasEntrada().size() > 0 && i.getArestasEntrada().get(0).getPeso() == 3)
        {
            peso = 3;
        }
        else{
            if(diasDeDiferenca > 5){
                peso = 3;
            }
            else if(diasDeDiferenca == 5){
                peso = 5;
            }
            else{
                peso = 8;
            }
        }

        Aresta<T> aresta = new Aresta<T>(i, f, peso);
        i.addArestaSaida(aresta);
        f.addArestaEntrada(aresta);
        this.arestas.add(aresta);
    }

    public void mostrarGraus(){
        for (Vertice vertice : vertices){
            System.out.println(vertice.getDado() + " possui grau de entrada: " + vertice.getGrauEntrada() + " e grau de saida: " + vertice.getGrauSaida());

        }
    }

    public Vertice<T> getVertice(T dado){
        Vertice<T> vertice = null;

        for(int i = 0; i < this.vertices.size(); i++){
            if(this.vertices.get(i).getDado().equals(dado)){
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }

    public void mostrarArestas(){
        for(Aresta aresta : arestas){
            System.out.println("(" + aresta.getInicio().getDado() + ", " + aresta.getFim().getDado() + ")");
        }
    }

    public int quantidadeVertices(){
        return vertices.size();
    }

    public int buscaEmLargura(){
        int tamanho = 1;

        ArrayList<Vertice<T>> marcados = new ArrayList<Vertice<T>>();
        ArrayList<Vertice<T>> fila = new ArrayList<Vertice<T>>();

        Vertice<T> atual = this.vertices.get(0);
        marcados.add(atual);
        System.out.println(atual.getDado());
        fila.add(atual);

        while(fila.size() > 0){
            Vertice<T> visitado = fila.get(0);

            for (int i = 0; i < visitado.getArestasSaida().size(); i++){
                Vertice<T> proximo = visitado.getArestasSaida().get(i).getFim();

                if (!marcados.contains(proximo)){
                    marcados.add(proximo);
                    tamanho += 1;
                    System.out.println(proximo.getDado());
                    fila.add(proximo);
                }
            }
            fila.remove(0);
        }
        return tamanho;
    }

    public void caminhosEntrePacientes(){
        String caminho = "";
        for (Vertice vertice : vertices){
            ArrayList<Aresta> arestasSaida = vertice.getArestasSaida();

            for (Aresta aresta : arestasSaida){
                caminho = "(" + vertice.getDado();

                ArrayList<Aresta> arestas1 = aresta.getFim().getArestasSaida();
                caminho += ", " + aresta.getFim().getDado();

                while (arestas1.size() != 0){
                        caminho += ", " + arestas1.get(0).getFim().getDado();
                        arestas1 = arestas1.get(0).getFim().getArestasSaida();
                }

                caminho += ")";

                System.out.println(caminho);
            }
        }
    }

    private boolean caminhoDireto(Vertice<Paciente> v1, Vertice<Paciente> v2){
        ArrayList<Aresta<Paciente>> arestasv1 = v1.getArestasSaida();
        ArrayList<Aresta<Paciente>> arestasv2 = v2.getArestasEntrada();

        for(Aresta<Paciente> arestav1 : arestasv1){
            for(Aresta<Paciente> arestav2 : arestasv2){
                if(arestav1.getInicio() == arestav2.getInicio()){
                    return true;
                }
            }
        }
        return false;
    }

    private int pesoArestas(Vertice<Paciente> v1, Vertice<Paciente> v2){
        ArrayList<Aresta<Paciente>> arestasv1 = v1.getArestasSaida();
        ArrayList<Aresta<Paciente>> arestasv2 = v2.getArestasEntrada();

        for(Aresta<Paciente> arestav1 : arestasv1){
            for(Aresta<Paciente> arestav2 : arestasv2){
                if(arestav1.getInicio() == arestav2.getInicio()){
                    return arestav2.getPeso();
                }
            }
        }

        return 0;
    }

    // Calculando a matriz adjacencia, lembrando que nosso grafo é ponderado e dirigido.
    private int[][] matrizAdjacencia(){
        int dimensao = quantidadeVertices() - 1;
        int matriz[][] = new int[dimensao][dimensao];

        for(int i = 0; i < dimensao; i++){
            for(int j = 0; j < dimensao; j++) {
                if (i == j){
                    matriz[i][j] = 0;
                }
                else{
                    Vertice<Paciente> v1 = (Vertice<Paciente>) vertices.get(i);
                    Vertice<Paciente> v2 = (Vertice<Paciente>) vertices.get(j);

                    if(caminhoDireto(v1, v2)){
                        matriz[i][j] = pesoArestas(v1,v2);
                    }
                    else
                    {
                        matriz[i][j] = 0;
                    }
                }
            }
        }

        return matriz;
    }

    public void analiseCompleta(){
        int matriz[][] = matrizAdjacencia();
        int dimensao = quantidadeVertices() - 1;
        String recomendacao = "";
        
        System.out.println("========== Relatório final de contágio. Indicação de quarentena ==========\n");
        
        System.out.println("v1 está infectado. Precisa fazer a quarentena.");

        for(int i = 0; i < dimensao; i++){
            for(int j = 0; j < dimensao; j++) {
                int peso = matriz[i][j];

                if (peso != 0){
                    if(peso == 3){
                        recomendacao = "v" + (i+1) + " teve um contato direto com v" + (j+1) + ", expressando um peso " + peso + ", o que significa que v" + (j+1) + " aparentemente não precisa de quarentena";
                    }
                    else if(peso == 5){
                        recomendacao = "v" + (i+1) + " teve um contato direto com v" + (j+1) + ", expressando um peso " + peso + ", o que significa que v" + (j+1) + " talvez precise de quarentena";
                    }
                    else if(peso == 8){
                        recomendacao = "v" + (i+1) + " teve um contato direto com v" + (j+1) + ", expressando um peso " + peso + ", o que significa que é recomendado v" + (j+1) + " fazer quarentena";
                    }

                    System.out.println(recomendacao);
                }
            }
        }
    }
}
