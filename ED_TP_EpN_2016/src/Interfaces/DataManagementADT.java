/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import ED_12_Parte1_Ex2.NetworkADT;
import java.io.IOException;

/**
 *
 * @author Vitor
 */
public interface DataManagementADT<T> {
    /**
     * Metodo responsavel pela leitura do ficheiro com os dados das viagens entre as cidades
     * @param ficheiro nome do ficheiro
     * @return uma rede de cidades do norte com as ligacoes e os dados de viagem entre as mesmas
     */
   public NetworkADT<T> obterNetwork(String ficheiro)throws IOException;
    
}
