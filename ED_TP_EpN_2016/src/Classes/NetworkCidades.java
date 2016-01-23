/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import ED_12_Parte1_Ex2.ArrayUnorderedList;
import ED_12_Parte1_Ex2.DoubleLinkedOrderedList;
import ED_12_Parte1_Ex2.LinkedQueue;
import ED_12_Parte1_Ex2.LinkedStack;
import ED_12_Parte1_Ex2.Network;
import ED_12_Parte1_Ex2.OrderedListADT;
import java.util.Iterator;
import java.util.List;

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
        try{
        Integer x;
        boolean found;
        LinkedStack<Integer> traversalStack = new LinkedStack<Integer>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<T>();
        boolean[] visited = new boolean[numVertices];
        if (!indexIsValid(startVertex)) {
            return resultList.iterator();
        }
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }
        traversalStack.push(new Integer(startVertex));
        resultList.addToRear(vertices[startVertex]);
        visited[startVertex] = true;
        while (!traversalStack.isEmpty()) {
            x = traversalStack.peek();
            found = false;
            /**
             * Find a vertex adjacent to x that has not been visited and push it
             * on the stack
             */
            for (int i = 0; (i < numVertices) && !found; i++) {
                if (adjList[x.intValue()][i]!=null && !visited[i]) {
                    traversalStack.push(i);
                    resultList.addToRear(vertices[i]);
                    visited[i] = true;
                    found = true;
                }
            }
            if (!found && !traversalStack.isEmpty()) {
                traversalStack.pop();
            }
        }
         return resultList.iterator();
        }catch(Exception e){
            return null;
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

    public DadosViagem[] getAdjFromCityIndex(int i) {
         OrderedListADT[][] adjListAux = adjList.clone(); // adjacency matrix
         DadosViagem[]  tempList = new DadosViagem[numVertices];
         try{
      
        for (int j = 0; j < numVertices; j++) {
            if(adjListAux[i][j]!=null){
                for (int k = 0; k < adjListAux[i][j].size(); k++) {
                  tempList[k]= (DadosViagem) adjListAux[i][j].first();
                  adjListAux[i][j].removeFirst();
                  }
            }
          
        }
        }catch(Exception e){}
        return tempList;
    }
    
}
