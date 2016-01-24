/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;



import ED_12_Parte1_Ex2.Network;
import Exeptions.HoraInvalida;
import Exeptions.PrecoInvalido;
import Ficheiros.EscreverErrosFicheiro;
import Interfaces.GestorViagemADT;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

/**
 *
 * @author Vitor
 */
public class GestorViagem<T> implements GestorViagemADT<T> {

    NetworkCidades<T> networkCidades;

    @Override
    public Hora introduzirDuracaoTotalMaximaViagem() throws IOException {

        System.out.println("Introduza duração maxima da viagem");
        System.out.print("Horas: ");
        try {
            int horas = Integer.parseInt(getDadosInput());
            System.out.print("Minutos: ");
            int minutos = Integer.parseInt(getDadosInput());
            return new Hora(horas, minutos);
        } catch (Exception e) {

            EscreverErrosFicheiro eef = new EscreverErrosFicheiro();
            eef.escreverEmficheiro(e, "GestorViagem");
            throw new HoraInvalida();
        }

    }

    @Override
    public Hora introduzirTempoEsperaMaximoEmCadaViagem() throws IOException {

        System.out.println("Introduza tempo espera maximo em cada viagem");
        System.out.print("Horas: ");
        try {
            int horas = Integer.parseInt(getDadosInput());
            System.out.print("Minutos: ");
            int minutos = Integer.parseInt(getDadosInput());
            return new Hora(horas, minutos);
        } catch (Exception e) {

            EscreverErrosFicheiro eef = new EscreverErrosFicheiro();
            eef.escreverEmficheiro(e, "GestorViagem");
            throw new HoraInvalida();
        }
    }

    @Override
    public Hora introduzirTempoEsperaTotal() throws IOException {
        System.out.println("Introduza tempo espera total");
        System.out.print("Horas: ");
        try {
            int horas = Integer.parseInt(getDadosInput());
            System.out.print("Minutos: ");
            int minutos = Integer.parseInt(getDadosInput());
            return new Hora(horas, minutos);
        } catch (Exception e) {

            EscreverErrosFicheiro eef = new EscreverErrosFicheiro();
            eef.escreverEmficheiro(e, "GestorViagem");
            throw new HoraInvalida();
        }

    }

    @Override
    public double introduzirPrecoTotalMaximo() throws IOException {

        System.out.println("Introduza preço total maximo");
        System.out.print("Preço: ");
        try {
            double preco = Double.parseDouble(getDadosInput());
            return preco;

        } catch (Exception e) {

            EscreverErrosFicheiro eef = new EscreverErrosFicheiro();
            eef.escreverEmficheiro(e, "GestorViagem");
            throw new PrecoInvalido();
        }

    }

    @Override
    public double introduzirPrecoMaximoTroco() throws IOException {
        System.out.println("Introduza preço maximo por troco");
        System.out.print("Preço: ");
        try {
            double preco = Double.parseDouble(getDadosInput());
            return preco;

        } catch (Exception e) {

            EscreverErrosFicheiro eef = new EscreverErrosFicheiro();
            eef.escreverEmficheiro(e, "GestorViagem");
            throw new PrecoInvalido();
        }
    }

    @Override
    public void calcularMelhorTrajeto(T cidadeOrigem, T cidadeDestino,T[] dadosViagem) {
        Iterator iterator = networkCidades.shortestPathWeight(cidadeOrigem, cidadeDestino);
        System.out.println("\tID\tNOME CIDADE");
        while(iterator.hasNext()){
            Cidade c = ((Cidade)iterator.next());
            System.out.println("\t"+c.getId()+"\t"+c.getNome());
        }
        //calcular custo
        
    }

    @Override
    public void calcularAlternativas(T cidadeOrigem, T cidadeDestino) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void calcularMelhorTrajetoComCriterios(T cidadeOrigem, T cidadeDestino, Criterio[] criterios) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void calcularAlternativasComCriterios(T cidadeOrigem, T cidadeDestino, Criterio[] criterios) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDadosInput() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        return in.readLine();
    }

    @Override
    public void obterCustoViagem(T cidadeOrigem, T cidadeDestino, Iterator iterator, T[] dadosViagem) {
  
    DadosViagem[] dados = (DadosViagem[]) dadosViagem;
    double custo =0;     
    
    
        for (int i = 0; i < dados.length; i++) {
            
            if(dados[i]!=null && dados[i].getCidadeOrigem().compareTo(networkCidades.vertices()[(Integer)cidadeOrigem])==0 &&
                    dados[i].getCidadeDestino().compareTo(networkCidades.vertices()[(Integer) cidadeDestino])==0 &&
                    dados[i].getDistanciaKm()==(Double) networkCidades.ajdListWeight[(Integer)cidadeOrigem][(Integer)cidadeDestino].findMin()){
                    custo += dados[i].getDistanciaKm() * dados[i].getPreco_Km();
                
            }
        
        
        }
        System.out.println("Custo: " + custo);
    
    }
    
    
    
}
