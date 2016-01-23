/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_12_Parte1_Ex2;

import java.util.Iterator;

/**
 *
 * @author Vitor
 */
public class Network<T> extends Graph<T> implements NetworkADT<T>{

    public Network() {
        super();
    }

    @Override
    public void addEdge(T vertex1, T vertex2, T weight) {
      
       int indexVertex1 = getIndex(vertex1);
       int indexVertex2 = getIndex(vertex2);
       if(adjList[indexVertex1][indexVertex2]==null){
           adjList[indexVertex1][indexVertex2]=new DoubleLinkedOrderedList();
       }
       
       adjList[indexVertex1][indexVertex2].add(weight);
    }

    @Override
    public Iterator shortestPathWeight(T vertex1, T vertex2) {
      
        return null;
        
    }
    
    
}
