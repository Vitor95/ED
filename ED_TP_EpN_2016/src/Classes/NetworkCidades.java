/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import ED_12_Parte1_Ex2.ArrayUnorderedList;
import ED_12_Parte1_Ex2.LinkedQueue;
import ED_12_Parte1_Ex2.Network;
import ED_12_Parte1_Ex2.OrderedListADT;
import java.util.Iterator;

/**
 *
 * @author Vitor
 * @param <T>
 */
public class NetworkCidades<T> extends Network<T> {

    public NetworkCidades() {
        super();
    }

    @Override
    public Iterator iteratorShortestPath(int startVertex, int targetVertex) {
       int node = startVertex;
       double custo =0;
       LinkedQueue<Integer> traversalQueue = new LinkedQueue<Integer>();
       traversalQueue.enqueue(node);//adicionar o comeco
       ArrayUnorderedList<Integer> resultList = new ArrayUnorderedList();
       
       while(true){
           if(traversalQueue.isEmpty()){
               return null;
           }
           node = traversalQueue.dequeue();
           if(node == targetVertex){
               resultList.addToRear(node);
               return resultList.iterator();
           }
               resultList.addToRear(node);
               
               for (int i = 0; i < numVertices; i++) {
               if(!resultList.contains(i)){
                   if(traversalQueue.first().getElement()!=i){
                       traversalQueue.enqueue(i);
                   }else if(verificarMenorCusto(traversalQueue,node,i)){
                       node = i;
                   }
               }
           }
           }
           
       
      
       
       
    }
    //verificar se existe ligacao direta

    public Iterator<T> verificarLigacaoDireta(int indexOrigem, int indexDestino) {
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<T>();
        try {
            double comprimento = 0;
            OrderedListADT[][] adjListAux = adjList.clone(); // adjacency matrix
            if (adjListAux[indexOrigem][indexDestino] != null) {
                resultList.addToRear(vertices[indexOrigem]);
                DadosViagem dadosViagemMenor = null;
                //obter os dados do menor caminho
                dadosViagemMenor = (DadosViagem) adjListAux[indexOrigem][indexDestino].first();
                adjListAux[indexOrigem][indexDestino].removeFirst();

                int size = adjListAux[indexOrigem][indexDestino].size();
                //encontrar a menor distancia entre verticeAnterior e x(atual) 
                for (int j = 0; j < size; j++) {

                    DadosViagem dadosViagem = (DadosViagem) adjListAux[indexOrigem][indexDestino].first();
                    adjListAux[indexOrigem][indexDestino].removeFirst();
                    if (dadosViagem.getDistanciaKm() < dadosViagemMenor.getDistanciaKm()) {

                        dadosViagemMenor = dadosViagem;

                    }

                }
                comprimento = dadosViagemMenor.getDistanciaKm();
                resultList.addToRear(vertices[indexDestino]);
                System.out.println("Distancia da Viagem: " + comprimento);

            }
            return resultList.iterator();
        } catch (Exception e) {

        }

        return resultList.iterator();
    }

    private boolean verificarMenorCusto(LinkedQueue<Integer> traversalQueue, int node, int i) {
       try{
        OrderedListADT[][] adjListAux = adjList.clone(); // adjacency matrix
     
                //obter os dados do menor caminho
                 DadosViagem dadosViagemMenor = (DadosViagem) adjListAux[node][i].first();
                adjListAux[node][i].removeFirst();

                int size = adjListAux[node][i].size();
                //encontrar a menor distancia entre verticeAnterior e x(atual) 
                for (int j = 0; j < size; j++) {

                    DadosViagem dadosViagem = (DadosViagem) adjListAux[node][i].first();
                    adjListAux[node][i].removeFirst();
                    if (dadosViagem.getDistanciaKm() < dadosViagemMenor.getDistanciaKm()) {

                        dadosViagemMenor = dadosViagem;

                    }

                }
               if(dadosViagemMenor.getCidadeDestino().compareTo(i)==0){
                   return true;
               }
              
       }catch(Exception e){
           
       }
    return false;
    } 
}
