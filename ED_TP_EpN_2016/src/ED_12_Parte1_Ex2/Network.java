/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_12_Parte1_Ex2;

import ED_11_Parte1_Ex3.LinkedHeap;
import java.util.Iterator;

/**
 *
 * @author Vitor
 */
public class Network<T> extends Graph<T> implements NetworkADT<T>{
    
    public LinkedHeap[][] ajdListWeight;
    
    
    public Network() {
        super();
        ajdListWeight = new LinkedHeap[122][122];
    }

    @Override
    public void addEdge(T vertex1, T vertex2, double weight) {
      
       int indexVertex1 = getIndex(vertex1);
       int indexVertex2 = getIndex(vertex2);
       if(ajdListWeight[indexVertex1][indexVertex2]==null){
           adjMatrix[indexVertex1][indexVertex2]=true;
           ajdListWeight[indexVertex1][indexVertex2] = new LinkedHeap();
           ajdListWeight[indexVertex1][indexVertex2].addElement(weight);
       }else{
            ajdListWeight[indexVertex1][indexVertex2].addElement(weight);
       }
       
    }
    

    

    @Override
    public Iterator shortestPathWeight(T vertex1, T vertex2) {
      
        return null;
        
    }
    
    
}
