package br.com.ufape.aedii.grafos;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Iniciando grafo
        Grafo<Paciente> grafo = new Grafo<>();

        // Gerando pacientes de teste
        Paciente paciente1 = new Paciente("A");
        Paciente paciente2 = new Paciente("B");
        Paciente paciente3 = new Paciente("C");
        Paciente paciente4 = new Paciente("D");
        Paciente paciente5 = new Paciente("E");
        Paciente paciente6 = new Paciente("F");
        Paciente paciente7 = new Paciente("G");
        Paciente paciente8 = new Paciente("H");
        Paciente paciente9 = new Paciente("I");
        Paciente paciente10 = new Paciente("J");
        Paciente paciente11 = new Paciente("K");
        Paciente paciente12 = new Paciente("L");
        Paciente paciente13 = new Paciente("M");
        Paciente paciente14 = new Paciente("N");
        Paciente paciente15 = new Paciente("O");
        Paciente paciente16 = new Paciente("P");
        Paciente paciente17 = new Paciente("R");
        Paciente paciente18 = new Paciente("S");
        Paciente paciente19 = new Paciente("T");
        Paciente paciente20 = new Paciente("U");
        Paciente paciente21 = new Paciente("V");
        Paciente paciente22 = new Paciente("X");
        Paciente paciente23 = new Paciente("Z");

        // Adicionando pacientes como vértices do grafo
        grafo.adicionarVertice(paciente1);
        grafo.adicionarVertice(paciente2);
        grafo.adicionarVertice(paciente3);
        grafo.adicionarVertice(paciente4);
        grafo.adicionarVertice(paciente5);
        grafo.adicionarVertice(paciente6);
        grafo.adicionarVertice(paciente7);
        grafo.adicionarVertice(paciente8);
        grafo.adicionarVertice(paciente9);
        grafo.adicionarVertice(paciente10);
        grafo.adicionarVertice(paciente11);
        grafo.adicionarVertice(paciente12);
        grafo.adicionarVertice(paciente13);
        grafo.adicionarVertice(paciente14);
        grafo.adicionarVertice(paciente15);
        grafo.adicionarVertice(paciente16);
        grafo.adicionarVertice(paciente17);
        grafo.adicionarVertice(paciente18);
        grafo.adicionarVertice(paciente19);
        grafo.adicionarVertice(paciente20);
        grafo.adicionarVertice(paciente21);
        grafo.adicionarVertice(paciente22);
        grafo.adicionarVertice(paciente23);

        /*
         Criando relação entre os vértices
         Considerando que o vértice pai seja o paciente 1, e que ele esteja infectado, vamos utilizar o peso das arestas
         como sendo a pontuação entre a relação dos pacientes.
         Visto isso, o peso não será passado na construção da aresta, mas será calculado a partir da data de contato.

         Inicialmente assumiremos que o paciente 1 foi infectado no dia de hoje, utilizando uma ferramenta do java

         DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
         Date date = new Date();
         System.out.println(dateFormat.format(date));

         Após isso, passaremos diversas datas que representam quando o paciente X teve contato com o paciente Y,
         e o peso será calculado levando em consideração a janela de contágio de 5 dias

         Exemplos
         Peso 3 = paciente não precisa de quarentena
         Peso 5 = paciente talvez precise de quarentena (avaliar sintomas)
         Peso 8 = paciente precisa de quarentena

        */

        // Pegando a data de agora
        LocalDate date = LocalDate.now();
        
        // Atribuindo a data de agora para a data de possível infecção do paciente 1
        // Isso será importante para calcular os pesos entre os contatos dos pacientes
        paciente1.setDataPossivelInfeccao(date);

        // O valor que estamos passando nessa aresta não é o peso da aresta, mas sim quantos dias após o
        // primeiro dia do sistema
        int diasPassadosDesdeInicio = 0;

        diasPassadosDesdeInicio += 1;
        grafo.adicionarAresta(paciente1, paciente2, date, diasPassadosDesdeInicio);

        diasPassadosDesdeInicio += 2;
        grafo.adicionarAresta(paciente1, paciente3, date, diasPassadosDesdeInicio);

        diasPassadosDesdeInicio += 2;
        grafo.adicionarAresta(paciente1, paciente4, date, diasPassadosDesdeInicio);

        diasPassadosDesdeInicio += 2;
        grafo.adicionarAresta(paciente3, paciente5, date, diasPassadosDesdeInicio);

        diasPassadosDesdeInicio += 1;
        grafo.adicionarAresta(paciente5, paciente9, date, diasPassadosDesdeInicio);

        diasPassadosDesdeInicio += 1;
        grafo.adicionarAresta(paciente4, paciente6, date, diasPassadosDesdeInicio);

        diasPassadosDesdeInicio += 3;
        grafo.adicionarAresta(paciente6, paciente7, date, diasPassadosDesdeInicio);
        grafo.adicionarAresta(paciente6, paciente8, date, diasPassadosDesdeInicio);
        grafo.adicionarAresta(paciente9, paciente10, date, diasPassadosDesdeInicio);
        grafo.adicionarAresta(paciente9, paciente11, date, diasPassadosDesdeInicio);

        diasPassadosDesdeInicio += 3;
        grafo.adicionarAresta(paciente11, paciente12, date, diasPassadosDesdeInicio);

        diasPassadosDesdeInicio += 2;
        grafo.adicionarAresta(paciente12, paciente13, date, diasPassadosDesdeInicio);
        grafo.adicionarAresta(paciente12, paciente14, date, diasPassadosDesdeInicio);

        diasPassadosDesdeInicio += 1;
        grafo.adicionarAresta(paciente12, paciente15, date, diasPassadosDesdeInicio);
        grafo.adicionarAresta(paciente15, paciente16, date, diasPassadosDesdeInicio);
        grafo.adicionarAresta(paciente15, paciente17, date, diasPassadosDesdeInicio);

        diasPassadosDesdeInicio += 6;
        grafo.adicionarAresta(paciente15, paciente18, date, diasPassadosDesdeInicio);
        grafo.adicionarAresta(paciente15, paciente19, date, diasPassadosDesdeInicio);

        diasPassadosDesdeInicio += 2;
        grafo.adicionarAresta(paciente15, paciente20, date, diasPassadosDesdeInicio);
        grafo.adicionarAresta(paciente20, paciente21, date, diasPassadosDesdeInicio);

        diasPassadosDesdeInicio += 9;
        grafo.adicionarAresta(paciente21, paciente22, date, diasPassadosDesdeInicio);
        grafo.adicionarAresta(paciente21, paciente23, date, diasPassadosDesdeInicio);

        // Busca em largura para mostrar todos os vértices que estão interligados de alguma forma
        // Por exemplo, formando caminhos.
        int tamanho = grafo.buscaEmLargura();
        System.out.println("\nO tamanho do grafo atualmente é de: " + tamanho + " vértices\n");

        // Mostra as arestas do grafo
        System.out.println("Arestas: \n");
        grafo.mostrarArestas();
        System.out.println(" ");

        // Mostra grau dos vértices
        // Lembrando que para um grafo do tipo direcionado, temos dois tipos de graus,
        // o grau de entrada, que é igual a quantidade de arestas que chegam ao vértice,
        // e o grau de saída, que é a quantidade de arestas que saem do vértice
        System.out.println("Graus: ");
        grafo.mostrarGraus();
        System.out.println(" ");

        // Mostrando os caminhos de infecção, ou seja, um caminho lógico, do início ao fim, exibindo quem infectou quem.
        System.out.println("Caminhos de Infecção: ");
        grafo.caminhosEntrePacientes();
        System.out.println(" ");

        // Podemos avaliar se todos os pacientes estão infectados a partir da busca em largura, executada previamente
        // Se a busca conseguiu visitar todos os elementos do grafo, significa que todos eles tem conexão possível,
        // portanto, todos estão infectados

        if (tamanho == grafo.quantidadeVertices()){
            System.out.println("Todos os pacientes tiveram algum contato entre si, porém, em períodos diferentes.");
            System.out.println("Precisa-se avaliar o período em que tiveram contato para as possíveis recomendações.\n");
        }
        else{
            System.out.println("Nem todos os pacientes tiveram contato entre si.");
        }

        grafo.analiseCompleta();
    }
}