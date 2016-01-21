/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import ED_12_Parte1_Ex2.OrderedListADT;

/**
 *
 * @author Vitor
 */
public class DadosViagem<T> implements Comparable<T>{
    private int idDadosViagem;
    private Cidade cidadeOrigem;
    private double preco_Km;
    private OrderedListADT<Hora> listaHorariosSaida;
    private double distanciaKm;
    private Hora tempoMin;
    private Cidade cidadeDestino;

    public DadosViagem(int idDadosViagem, Cidade cidadeOrigem, double preco_Km, OrderedListADT<Hora> listaHorariosSaida, double distanciaKm, Hora tempoMin, Cidade cidadeDestino) {
        this.idDadosViagem = idDadosViagem;
        this.cidadeOrigem = cidadeOrigem;
        this.preco_Km = preco_Km;
        this.listaHorariosSaida = listaHorariosSaida;
        this.distanciaKm = distanciaKm;
        this.tempoMin = tempoMin;
        this.cidadeDestino = cidadeDestino;
    }
    
    public int getIdDadosViagem() {
        return idDadosViagem;
    }

    public void setIdDadosViagem(int idDadosViagem) {
        this.idDadosViagem = idDadosViagem;
    }

    public Cidade getCidadeOrigem() {
        return cidadeOrigem;
    }

    public void setCidadeOrigem(Cidade cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public double getPreco_Km() {
        return preco_Km;
    }

    public void setPreco_Km(double preco_Km) {
        this.preco_Km = preco_Km;
    }

    public OrderedListADT<Hora> getListaHorariosSaida() {
        return listaHorariosSaida;
    }

    public void setListaHorariosSaida(OrderedListADT<Hora> listaHorariosSaida) {
        this.listaHorariosSaida = listaHorariosSaida;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public Hora getTempoMin() {
        return tempoMin;
    }

    public void setTempoMin(Hora tempoMin) {
        this.tempoMin = tempoMin;
    }

    public Cidade getCidadeDestino() {
        return cidadeDestino;
    }

    public void setCidadeDestino(Cidade cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }

    @Override
    public int compareTo(T o) {
       DadosViagem dadosViagemCompare = (DadosViagem) o;
       if(dadosViagemCompare.idDadosViagem < idDadosViagem){
           return -1;
       }
       return 1;
              
    }
    
    
}
