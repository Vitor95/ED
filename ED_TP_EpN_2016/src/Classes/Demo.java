/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import ED_12_Parte1_Ex2.Network;
import ED_12_Parte1_Ex2.NetworkADT;
import Ficheiros.DataManagement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Vitor
 */
public class Demo {

    static GestorViagem gestorViagem;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        gestorViagem = new GestorViagem();

        gestorViagem.networkCidades = (Network) new DataManagement().obterNetwork("./Ficheiros/Network.csv");
//        System.out.println(n.size());
//        System.out.println(n.isConnected());
//
//        //Tirar util !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//        Iterator i = n.iteratorBFS(0);
//
//        while (i.hasNext()) {
//            System.out.println(((Cidade) i.next()).getNome());
//        }
//
//        GestorViagem gestorViagem = new GestorViagem();
//        gestorViagem.introduzirDuracaoTotalMaximaViagem();
//        gestorViagem.introduzirPrecoMaximoTroco();

        menuPrincipal();

    }

    public static void menuPrincipal() throws IOException {
        int opcao;
        do {
            System.out.println(div());
            System.out.println("\tFIND YOUR TRIP");
            System.out.println("1. Encontrar a minha viagem");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            opcao = Integer.parseInt(in.readLine());
            switch (opcao) {
                case 1:
                    menuEncontrarMinhaViagem();
                    break;
                case 0:
                    System.out.println("Fechou a aplicação");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;

            }
        } while (opcao != 0);
    }

    private static void menuEncontrarMinhaViagem() throws IOException {
        int opcao;
        do {
            System.out.println(div());
            System.out.println("\tENCONTRAR A MINHA VIAGEM");
            System.out.println("1. Encontrar viagem sem critérios");
            System.out.println("2. Encontrar viagem com critérios");
            System.out.println("0. Voltar...");
            System.out.print("Opção: ");

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            opcao = Integer.parseInt(in.readLine());
            switch (opcao) {
                case 1:
                    menuEncontrarMinhaViagemSemCriterios();
                    break;
                case 2:
                    menuEncontrarMinhaViagemComCriterios();
                    break;
                case 0:
                    System.out.println("Voltar...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }

    private static void menuEncontrarMinhaViagemSemCriterios() throws IOException {
    inserirCidadesDO();
    }

    private static void inserirCidadesDO() throws IOException {
        boolean cidadeO = true;
        boolean cidadeD = true;
        do {
            System.out.println(div());
            System.out.println("\tESCOLHA AS CIDADES");
            System.out.print("Cidade origem: ");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String cidadeOrigem = in.readLine();

            if (gestorViagem.networkCidades.getIndex(new Cidade(1, cidadeOrigem)) == -1) {
                System.out.println("Cidade não encontrada");
                cidadeO = false;
            }
            System.out.print("Cidade destino: ");
            String cidadeDestino = in.readLine();

            if (gestorViagem.networkCidades.getIndex(new Cidade(1, cidadeDestino)) == -1) {
                System.out.println("Cidade não encontrada");
                cidadeD = false;
            }
        } while (cidadeO && cidadeD);

    }

    private static void menuEncontrarMinhaViagemComCriterios() throws IOException {
        int opcao;
        Criterio[] criterio;
        do {
            System.out.println(div());
            System.out.println("\tESCOLHA AS CIDADES");
            System.out.println("1. Encontrar Viagem com os criterios adicionados");
            System.out.println("2. Adicionar Critério");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            opcao = Integer.parseInt(in.readLine());

            switch (opcao) {
                case 1:
                    gestorViagem.calcularMelhorTrajetoComCriterios(criterio, criterio, criterio);
                    break;
                case 2:
                    criterio = menuCriterios();
                    break;
                case 0:
                    System.out.println("Voltar...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);

    }

    public static Criterio[] menuCriterios() throws IOException {
        int opcao;
        Criterio[] criterios= new Criterio[5];
    
        do {
            System.out.println(div());
            System.out.println("1. Duração total máxima da viagem");
            System.out.println("2. Tempo de espera máximo em cada paragem");
            System.out.println("3. Tempo de espera total");
            System.out.println("4. Preço total máximo");
            System.out.println("5. Preço máximo por troço");

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            opcao = Integer.parseInt(in.readLine());

            switch (opcao) {
                case 1:
                    gestorViagem.introduzirDuracaoTotalMaximaViagem();
                    break;
                case 2:
                    gestorViagem.introduzirTempoEsperaMaximoEmCadaViagem();
                    break;
                case 3:
                    gestorViagem.introduzirTempoEsperaTotal();
                    break;
                case 4:
                    gestorViagem.introduzirPrecoTotalMaximo();
                    break;
                case 5:
                    gestorViagem.introduzirPrecoMaximoTroco();
                    break;
                case 0:
                    System.out.println("Voltar...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
        return criterios;
    }

    public static String div() {
        return "---------------------------------------------";

    }
}
