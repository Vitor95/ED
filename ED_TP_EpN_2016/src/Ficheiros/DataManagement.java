/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ficheiros;

import Classes.Cidade;
import Classes.DadosViagem;
import Classes.NetworkCidades;
import Classes.Hora;
import ED_12_Parte1_Ex2.DoubleLinkedOrderedList;
import ED_12_Parte1_Ex2.NetworkADT;
import ED_12_Parte1_Ex2.OrderedListADT;
import Exeptions.FicheiroNaoEnc;
import Interfaces.DataManagementADT;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.nio.charset.StandardCharsets.ISO_8859_1;

/**
 *
 * @author Vitor
 */
public class DataManagement implements DataManagementADT {

    @Override
    public NetworkADT obterNetwork(String ficheiro)throws IOException{
        try {
            //Instanciar FileReader's
            FileReader data = new FileReader(ficheiro);
            //Instanciar BufferedReader's
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(ficheiro), ISO_8859_1));

            //ler primeira linha de informacao do ficheiro
            br.readLine();
            //instanciar variaveis necessarias
            NetworkADT networkADT = new NetworkCidades();

            //instanciar string para armazenar a linha completa
            String linhaCompleta;
            String[] dadosArray;
            String linhaCompletaCont;
            String[] dadosArrayCont;
            int idDadosViagem = 0;
            int idCidade = 0;
            while ((linhaCompleta = br.readLine()) != null) {
                // linhaCompletaEco dividida por ;
                String linhaCompletaReplace = linhaCompleta.replace(',', '.');
                dadosArray = linhaCompletaReplace.split(";");
                
                Cidade cidadeOrigem = new Cidade(idCidade++,dadosArray[0]);
                Cidade cidadeDestino = new Cidade(idCidade++,dadosArray[11]);
                // Origem para Destino
               
                double preco_Km_OD = Double.parseDouble(dadosArray[1]);
                OrderedListADT<Hora> listaHorariosSaida_OD = new DoubleLinkedOrderedList<>();
                String[] hora1 = dadosArray[2].split(":");
                if(dadosArray[2].compareTo("")!=0) listaHorariosSaida_OD.add(new Hora( Integer.parseInt(hora1[0]),
                        Integer.parseInt(hora1[1])));
                 String[] hora2 = dadosArray[3].split(":");
                if(dadosArray[3].compareTo("")!=0) listaHorariosSaida_OD.add(new Hora( Integer.parseInt(hora2[0]),
                        Integer.parseInt(hora2[1])));
                String[] hora3 = dadosArray[4].split(":");
                if(dadosArray[4].compareTo("")!=0) listaHorariosSaida_OD.add(new Hora( Integer.parseInt(hora3[0]),
                        Integer.parseInt(hora3[1])));
                double distanciaKm_OD = Double.parseDouble(dadosArray[5]);
                Hora tempoMin_OD = parseToHour(dadosArray[6]);
            
                //Destino para Origem
                 double preco_Km_DO = Double.parseDouble(dadosArray[7]);
                OrderedListADT<Hora> listaHorariosSaida_DO = new DoubleLinkedOrderedList<>();
                String[] hora4 = dadosArray[8].split(":");
                if(dadosArray[8].compareTo("")!=0) listaHorariosSaida_DO.add(new Hora( Integer.parseInt(hora4[0]),
                        Integer.parseInt(hora4[1])));
                 String[] hora5 = dadosArray[9].split(":");
                if(dadosArray[9].compareTo("")!=0)listaHorariosSaida_DO.add(new Hora( Integer.parseInt(hora5[0]),
                        Integer.parseInt(hora5[1])));
                 String[] hora6 = dadosArray[10].split(":");
                if(dadosArray[10].compareTo("")!=0)listaHorariosSaida_DO.add(new Hora( Integer.parseInt(hora6[0]),
                        Integer.parseInt(hora6[1])));
                double distanciaKm_DO = Double.parseDouble(dadosArray[5]);
                Hora tempoMin_DO = parseToHour(dadosArray[6]);
                
                
                //intanciar DadosViagem DO
                DadosViagem dadosViagem_DO = new DadosViagem(idDadosViagem++,cidadeOrigem, preco_Km_DO, listaHorariosSaida_DO,
                        distanciaKm_DO, tempoMin_DO, cidadeDestino);
                
                //intanciar DadosViagem OD
                DadosViagem dadosViagem_OD = new DadosViagem(idDadosViagem++,cidadeDestino, preco_Km_OD, listaHorariosSaida_OD,
                        distanciaKm_OD, tempoMin_OD, cidadeOrigem);
                
                
                //adicionar cidades
                networkADT.addVertex(cidadeOrigem);
                networkADT.addVertex(cidadeDestino);
                
                //atribuir dados à rede de cidades do norte
                networkADT.addEdge(cidadeOrigem, cidadeDestino, dadosViagem_OD);
                  networkADT.addEdge(cidadeDestino, cidadeOrigem, dadosViagem_DO);
                
            }
            return networkADT;
        } catch (Exception e) {
            EscreverErrosFicheiro eef = new EscreverErrosFicheiro();
            
                eef.escreverEmficheiro(e, "DataManager");
           
            new FicheiroNaoEnc(e+"");

        }
        return null;

    }

    private Hora parseToHour(String min) {
      
        int minutosInt = Integer.parseInt(min);
        if(minutosInt%60<1){
            return new Hora(0,minutosInt);
        }else{
            return new Hora(minutosInt/60, minutosInt%60);
        }
    
    }

}
