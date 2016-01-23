/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_12_Parte1_Ex1;

import java.util.Iterator;

/**
 *
 * @author Vitor
 */
public class Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EmptyCollectionException {
   
    Graph graph = new Graph();
    graph.addVertex("A");
    graph.addVertex("B");
    graph.addVertex("C");
    graph.addVertex("D");
    
    graph.addEdge("A", "B");
    graph.addEdge("B", "C");
    graph.addEdge("C", "D");
    
    System.out.println("Grafo conexo: "+graph.isConnected());
    
    graph.removeVertex("D");
    
    System.out.println("Grafo conexo: "+graph.isConnected());
    
       Iterator iterator = graph.iteratorBFS(0);
    
        System.out.print("BFS START: " + iterator.next());
        while (iterator.hasNext()) {            
            System.out.print(" -> "+iterator.next());
        }
        System.out.println();
        
        
        Iterator iteratorDFS = graph.iteratorDFS(0);
    
        System.out.print("DFS START: " + iterator.next());
        while (iterator.hasNext()) {            
            System.out.print(" -> "+iterator.next());
        }
        System.out.println();     
    }
    
}
