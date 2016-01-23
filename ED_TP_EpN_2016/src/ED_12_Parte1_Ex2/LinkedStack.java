/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_12_Parte1_Ex2;



/**
 *
 * @author Vitor
 */
public class LinkedStack<T> implements StackADT<T>{

    private LinearNode<T> top;

    public LinkedStack(LinearNode top) {
        this.top = top;
    }

    public LinkedStack() {
        this.top = null;
    }

   


    @Override
    public void push(T element) {
    
        if (top == null) {
            top = new LinearNode(element);
        } else {
          LinearNode<T> linearNode = new LinearNode(element);
          linearNode.setNext(top);
          top=linearNode;
                 
          
        }
    }

    @Override
    public T pop() throws EmptyCollectionException {
       T elementoReturn;
        if(isEmpty()) throw new EmptyCollectionException("Lista Vazia");
        elementoReturn = top.getElement();
        top=top.getNext();
        return elementoReturn;
    }

    @Override
    public T peek() throws EmptyCollectionException {
    if (isEmpty())
      throw new EmptyCollectionException("Stack");
    return top.getElement();
    
    }

    @Override
    public boolean isEmpty() {
    return top==null;
    }

    @Override
    public int size() {
    LinearNode<T> e;
    
        if (top == null) {
            System.out.println("Lista Vazia");
            return 0;
        } else {
            int cont = 1;
            e = top;
            while (e.getNext() != null) {
                e = e.getNext();

                cont++;
            }
            return cont;
        }
    }
}
