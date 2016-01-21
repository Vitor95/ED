/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Classes.Criterio;
import Classes.Hora;
import Enum.TipoCriterio;
import java.io.IOException;

/**
 *
 * @author Vitor
 */
public interface GestorViagemADT<T> {
    /**
     * Pede ao utilizador que introduza a duracao maxima da viagem
     * @return o tempo que o utilizador introduziu
     */
    public Hora introduzirDuracaoTotalMaximaViagem() throws IOException;
    /**
     * Pede ao utilizador que introduza a o tempo de espera maximo em cada viagem
     * @return o tempo de espera maximo em cada viagem
     */
    public Hora introduzirTempoEsperaMaximoEmCadaViagem() throws IOException;
    /**
     * Pede ao utilizador que introduza a o tempo o tempo de espera total
     * @return o tempo o tempo de espera total
     */
    public Hora introduzirTempoEsperaTotal() throws IOException;
    /**
     * Pede ao utilizador que introduza o preco total maximo
     * @return o preco total maximo
     */
    public double introduzirPrecoTotalMaximo() throws IOException;
    /**
     * Pede ao utilizador que introduza o preco maximo por troco
     * @return o preco maximo por troco
     */
    public double introduzirPrecoMaximoTroco() throws IOException;
    /**
     * calcular o trajeto que se adequada aos criterios pedidos
     *  @param cidadeOrigem  primeira cidade da viagem
     *  @param cidadeDestino  ultima cidade da viagem
     */
    public void calcularMelhorTrajeto(T cidadeOrigem, T cidadeDestino);
    /**
     * recalcular trajeto considerando criterios diferentes
    *  @param cidadeOrigem  primeira cidade da viagem
     *  @param cidadeDestino  ultima cidade da viagem
     */
    public void calcularAlternativas(T cidadeOrigem, T cidadeDestino);
     /**
     * calcular o trajeto que se adequada aos criterios pedidos
     *  @param cidadeOrigem  primeira cidade da viagem
     *  @param cidadeDestino  ultima cidade da viagem
     */
    public void calcularMelhorTrajetoComCriterios(T cidadeOrigem, T cidadeDestino,Criterio[] criterios);
    /**
     * recalcular trajeto considerando criterios diferentes
    *  @param cidadeOrigem  primeira cidade da viagem
     *  @param cidadeDestino  ultima cidade da viagem
     */
    public void calcularAlternativasComCriterios(T cidadeOrigem, T cidadeDestino,Criterio[] criterios);    
    
}
