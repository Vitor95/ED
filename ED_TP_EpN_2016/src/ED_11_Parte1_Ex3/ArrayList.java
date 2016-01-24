/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_11_Parte1_Ex3;


import java.util.Iterator;


/**
 *
 * @author Vitor
 */
public class ArrayList<T> implements ListADT<T>,Iterable<T>{

     private final int DEFAULT_TAM=100;
    private int rear=0;
    private T[] list;

    public ArrayList() {
        
        this.list = (T[]) new Object[DEFAULT_TAM];
    }
    
    @Override
    public T removeFirst() throws EmptyCollectionException {
        if(isEmpty()){ throw new EmptyCollectionException ("Is Empty");}
        T elementoReturn = first();
        for (int i = 0; i< rear; i++) {
           list[i]=list[i+1];
        }
        list[--rear]=null;
        
        return elementoReturn;
        
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
   
    if(isEmpty()){ throw new EmptyCollectionException ("Is Empty");}
        T elementoReturn = last();
        
        list[--rear]=null;
        
        return elementoReturn;
    }

    @Override
    public T remove(T element) {
       if((find(element)!=-1)){ 
            T elementoReturn = list[find(element)];
            
              for (int i = find(element); i < rear; i++) {
           list[i]=list[i+1];
        }
              
        list[--rear]=null;
        
            return elementoReturn;
       }
       return null;
        
    }

    @Override
    public T first() throws EmptyCollectionException{
    if(isEmpty()){ throw new EmptyCollectionException ("Is Empty");}
    return list[0];
    }

    @Override
    public T last() throws EmptyCollectionException{
   if(isEmpty()){ throw new EmptyCollectionException ("Is Empty");}
    return list[rear-1];
    }

    @Override
    public boolean contains(T target) {
    return find(target)!=-1; 
    }

    @Override
    public boolean isEmpty() {
        if(rear==0){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
   return  rear;
    }

    private int find(T element) {
        
    for(int i=0;i<rear;i++){
        if(element.equals(list[i])){
            return i;
        }
    }
        return -1;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public T[] getT() {
        return list;
    }

    public void setT(T[] t) {
        this.list = t;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator(list, rear);
    }
   public class ArrayIterator<T> implements Iterator<T>{

    private T[] lista;
    private int current;
    private int count;

    public ArrayIterator(T[] t, int count) {
        this.lista = t;
        this.count = count;
        this.current=0;
        
    }
    
   

    @Override
    public boolean hasNext() {
    return current<count;
    }

    @Override
    public T next() {
       
                return lista[current++];
  
    }
    
    
}


    
}
