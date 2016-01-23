/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_12_Parte1_Ex2;

import java.util.Iterator;

/**
 * Graph represents an adjacency matrix implementation of a graph.
 * 
*/
public class Graph<T> implements GraphADT<T> {

    protected final int DEFAULT_CAPACITY = 10;
    protected int numVertices; // number of vertices in the graph
    protected OrderedListADT[][] adjList; // adjacency matrix
    protected T[] vertices; // values of vertices

    /**
     * Creates an empty graph.
     */
    public Graph() {
        numVertices = 0;
        this.adjList = new OrderedListADT[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    /**
     * Inserts an edge between two vertices of the graph.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     */
    @Override
    public void addEdge(T vertex1, T vertex2) {
        addEdge(getIndex(vertex1), getIndex(vertex2));
    }

    /**
     * Inserts an edge between two vertices of the graph.
     *
     * @param index1 the first index
     * @param index2 the second index
     */
    public void addEdge(int index1, int index2) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjList[index1][index2] = new DoubleLinkedOrderedList();
            adjList[index2][index1] = new DoubleLinkedOrderedList();
        }
    }

    /**
     * Adds a vertex to the graph, expanding the capacity of the graph if
     * necessary. It also associates an object with the vertex.
     *     
* @param vertex the vertex to add to the graph
     */
    @Override
    public void addVertex(T vertex) {
        if(getIndex(vertex)==-1){
        if (numVertices == vertices.length) {
            expandCapacity();
        }
        vertices[numVertices] = vertex;
        for (int i = 0; i <= numVertices; i++) {
            adjList[numVertices][i] = null;
            adjList[i][numVertices] = null;
        }
        numVertices++;
        }
    }

    @Override
    public void removeVertex(T vertex) {
        if (getIndex(vertex) != -1) {

            //criar uma nova matriz sem este vertice
            OrderedListADT[][] matriz_aux = new DoubleLinkedOrderedList[numVertices - 1][numVertices - 1];
            //copiar os valores da matriz original
            int linha = 0, coluna = 0;
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (i != getIndex(vertex) && j != getIndex(vertex)) {
                        matriz_aux[linha][coluna] = adjList[i][j];
                        coluna++;
                    }

                }
                if(coluna!=0){
                    
               
                linha++;
                }
                coluna = 0;
            }

            adjList = matriz_aux;

            //Vertices
            for (int i = getIndex(vertex); i < vertices.length - 1; i++) {
                vertices[i] = vertices[i + 1];
            }
            numVertices--;

        }
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) {
        // ver se ambos vertices sao validos 
        if (getIndex(vertex1) != -1 && getIndex(vertex2) != -1) {
            adjList[getIndex(vertex1)][getIndex(vertex2)] = null;
        }
    }

    @Override
    public Iterator iteratorBFS(int startIndex
    ) {

        Integer x;
        LinkedQueue<Integer> traversalQueue = new LinkedQueue<Integer>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<T>();
        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }
        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }
        traversalQueue.enqueue(new Integer(startIndex));
        visited[startIndex] = true;
        while (!traversalQueue.isEmpty()) {
            x = traversalQueue.dequeue();
            resultList.addToRear(vertices[x.intValue()]);
            /**
             * Find all vertices adjacent to x that have not been visited and
             * queue them up
             */
            for (int i = 0; i < numVertices; i++) {
                if (adjList[x.intValue()][i]!=null && !visited[i]) {
                    traversalQueue.enqueue(new Integer(i));
                    visited[i] = true;
                }
            }
        }
        return resultList.iterator();
    }

    @Override
    public Iterator iteratorDFS(int startIndex
    ) throws EmptyCollectionException {
        Integer x;
        boolean found;
        LinkedStack<Integer> traversalStack = new LinkedStack<Integer>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<T>();
        boolean[] visited = new boolean[numVertices];
        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }
        traversalStack.push(new Integer(startIndex));
        resultList.addToRear(vertices[startIndex]);
        visited[startIndex] = true;
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
    }

    @Override
    public Iterator iteratorShortestPath(int startVertex, int targetVertex
    ) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return numVertices == 0;
    }

    @Override
    public boolean isConnected() {

        //verificar se ha algum vertice sem ligações 
        for (int i = 0; i < numVertices; i++) {
            int contadorLigacoes = 0;
            for (int j = 0; j < numVertices; j++) {
                if (adjList[i][j] == null) {
                    contadorLigacoes++;
                }
            }
            //Se o contador nao tiver ligacoes, o contador sera igual ao numVertices
            if (contadorLigacoes == numVertices) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return numVertices;
    }

    /**
     * Creates new arrays to store the contents of the graph with twice the
     * capacity.
     */
    protected void expandCapacity() {
        T[] largerVertices = (T[]) (new Object[vertices.length * 2]);
        OrderedListADT[][] largerAdjMatrix
                = new OrderedListADT[vertices.length * 2][vertices.length * 2];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                largerAdjMatrix[i][j] = adjList[i][j];
            }
            largerVertices[i] = vertices[i];
        }
        vertices = largerVertices;
        adjList = largerAdjMatrix;

    }

    public int getIndex(T vertex) {

      Comparable c = (Comparable) vertex;
          for (int i = 0; i < numVertices; i++) {
            if (c.compareTo(vertices[i])==0) {
                return i;
            }
        }
        return -1;

    }

    protected boolean indexIsValid(int index1) {
        return index1 < 0 || index1 < numVertices;
    }
    
}
