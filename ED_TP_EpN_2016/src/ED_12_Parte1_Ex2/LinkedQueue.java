/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_12_Parte1_Ex2;





/**
 *
 * @author Vitor
 * @param <T>
 */
public class LinkedQueue<T> implements QueueADT<T>{
   
    LinearNode<T> front;
    LinearNode<T> rear;
    private int count;

    public LinkedQueue(LinearNode<T> t) {
        this.front = t;
        this.rear = t;
        count++;
    }

    public LinkedQueue() {
   
    }

    @Override
    public void enqueue(T element) {
        LinearNode<T> linearNode = new LinearNode(element);
        if(count==0){
            this.front = linearNode;
            this.rear = linearNode;
            count++;
        }else{
            rear.setNext(linearNode);
            this.rear = linearNode; 
            count++;
        }
    }

    @Override
    public T dequeue() {
    
     
        
            T var = this.front.getElement();
            if(rear==front){
                rear=null;
            }
            this.front=front.getNext();
            count--;
            return var;
            
       
       
    }
    
    
   
    @Override
    public LinearNode<T> first() {
        if(isEmpty()){
            System.out.println("Vazio");
            return null;
        }
     return front;
    }

    @Override
    public boolean isEmpty() {
        return this.size()==0;
    }

    @Override
    public int size() {
    return count;
    }

    public void remove(T v) {
        LinearNode<T> cidade = front;
        
    while(cidade.getNext()!= null){
        if(cidade.getElement() == v){
            cidade.setNext(cidade.getNext().getNext());
        }
        cidade= cidade.getNext();
    }
    }



 
    
    
}
