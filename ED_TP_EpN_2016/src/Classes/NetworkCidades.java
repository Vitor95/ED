/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import ED_12_Parte1_Ex2.ArrayUnorderedList;
import ED_12_Parte1_Ex2.LinkedQueue;
import ED_12_Parte1_Ex2.Network;
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
    public Iterator shortestPathWeight(T vertex1, T vertex2) {
        int startVertex=(Integer) vertex1;
        int targetVertex= (Integer) vertex2;
        Integer x;									//vertice atual
        LinkedQueue<Integer> traversalQueue = new LinkedQueue<Integer>();		//para guardar os vertices adjacentes de x
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<T>();
        //para guardar o caminho mais curto
        if (!indexIsValid(startVertex)||!indexIsValid(targetVertex)) {
            System.out.println("Cidade origem invalida");//verifica se o startIndex e valido
            return resultList.iterator();						//retorna iterador vazio	
        }

        boolean[] visited = new boolean[numVertices];					//no inicio todos os vertices nao foram visitados
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        int verticeAnterior = startVertex;
        double comprimento = 0;
        traversalQueue.enqueue(new Integer(startVertex));				//adiciona o index inicial a queue
        visited[startVertex] = true;

        Iterator res = verificarLigacaoDireta(startVertex, targetVertex);
        if (res.hasNext()) {
            
            return res;
        }

        try {//coloca vertice visitado
            while (!traversalQueue.isEmpty() && traversalQueue.first().getElement() != targetVertex) {

                x = traversalQueue.dequeue().intValue();
                if (x == startVertex) {
                    resultList.addToRear(vertices[x.intValue()]);
                    //se houver uma viagem direta adicionar a cidade (se houver mais que uma viagem, adicionar a que tem distancia menor)
                } else {

                    
                    // ver qual a menor viagem de todos elementos de traversalQueue
                    int cidadeMaisProxima = x;
                    double distanciaViagemMenor = (double) ajdListWeight[verticeAnterior][x].findMin();

                    int size = traversalQueue.size();
                    for (int i = 0; i < size; i++) {
                        //encontrar a menor distancia entre verticeAnterior e x(atual)
                        x = traversalQueue.dequeue();
                        if ((Double) ajdListWeight[verticeAnterior][x].findMin() < distanciaViagemMenor) {
                            cidadeMaisProxima=x; 
                        }

                    }

                    comprimento += (Double)ajdListWeight[verticeAnterior][cidadeMaisProxima].findMin();
                    resultList.addToRear(vertices[cidadeMaisProxima]);
                    verticeAnterior = cidadeMaisProxima;

                }
 
                for (int i = 0; i < numVertices; i++) {
                    
                    if (ajdListWeight[verticeAnterior][i] != null && !visited[i] && ajdListWeight[verticeAnterior][i].size()>1) {
                        
                         Iterator res2 = verificarLigacaoDireta(verticeAnterior, targetVertex );
                    if (res2.hasNext()) {
                        res2.next();
                        resultList.addToRear((T) res2.next());
                        return resultList.iterator();
                    }
                        traversalQueue.enqueue(new Integer(i));
                        visited[i] = true;
                        
                        
                    }
                }

            }

            resultList.addToRear(vertices[targetVertex]);
            comprimento += (Double) ajdListWeight[verticeAnterior][targetVertex].findMin();
            System.out.println(comprimento);
        } catch (Exception ex) {
        }
        return resultList.iterator();
        //verificar se existe ligacao direta
    }


    public Iterator<T> verificarLigacaoDireta(int indexOrigem, int indexDestino) {
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<T>();

        try {
            double comprimento = 0;

            if (adjMatrix[indexOrigem][indexDestino] != false) {
               
                resultList.addToRear(vertices[indexOrigem]);
                comprimento = (double) ajdListWeight[indexOrigem][indexDestino].findMin();
                resultList.addToRear(vertices[indexDestino]);
                System.out.println("Distancia da Viagem: " + comprimento);
            }

            return resultList.iterator();
        } catch (Exception e) {
            return resultList.iterator();
        }

    }
    public T[] vertices(){
        return vertices; 
    }

}
