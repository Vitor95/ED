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

    protected final int DEFAULT_CAPACITY = 30;
    protected int numVertices; // number of vertices in the graph
    protected boolean[][] adjMatrix; // adjacency matrix
    protected T[] vertices; // values of vertices

    /**
     * Creates an empty graph.
     */
    public Graph() {
        numVertices = 0;
        this.adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
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
            adjMatrix[index1][index2] = true;
            adjMatrix[index2][index1] = true;
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
            adjMatrix[numVertices][i] = false;
            adjMatrix[i][numVertices] = false;
        }
        numVertices++;
        }
    }

    @Override
    public void removeVertex(T vertex) {
        if (getIndex(vertex) != -1) {

            //criar uma nova matriz sem este vertice
            boolean[][] matriz_aux = new boolean[numVertices - 1][numVertices - 1];
            //copiar os valores da matriz original
            int linha = 0, coluna = 0;
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (i != getIndex(vertex) && j != getIndex(vertex)) {
                        matriz_aux[linha][coluna] = adjMatrix[i][j];
                        coluna++;
                    }

                }
                if(coluna!=0){
                    
               
                linha++;
                }
                coluna = 0;
            }

            adjMatrix = matriz_aux;

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
            adjMatrix[getIndex(vertex1)][getIndex(vertex2)] = false;
        }
    }

    @Override
    public Iterator iteratorBFS(int startIndex
    ) {

        Integer x;
        ED_12_Parte1_Ex1.LinkedQueue<Integer> traversalQueue = new ED_12_Parte1_Ex1.LinkedQueue<Integer>();
        ED_12_Parte1_Ex1.ArrayUnorderedList<T> resultList = new ED_12_Parte1_Ex1.ArrayUnorderedList<T>();
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
                if (adjMatrix[x.intValue()][i] && !visited[i]) {
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
                if (adjMatrix[x.intValue()][i] && !visited[i]) {
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
    public Iterator iteratorShortestPath(int startVertex, int targetVertex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                if (adjMatrix[i][j] == false) {
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
        boolean[][] largerAdjMatrix
                = new boolean[vertices.length * 2][vertices.length * 2];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                largerAdjMatrix[i][j] = adjMatrix[i][j];
            }
            largerVertices[i] = vertices[i];
        }
        vertices = largerVertices;
        adjMatrix = largerAdjMatrix;

    }

    public int getIndex(T vertex) {

        for (int i = 0; i < vertices.length; i++) {
            if (vertex.equals(vertices[i])) {
                return i;
            }
        }
        return -1;

    }

    public boolean indexIsValid(int index1) {
        return index1 < 0 || index1 < numVertices;
    }

  

}