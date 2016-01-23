/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_12_Parte1_Ex2;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vitor
 */
public class LinkedList<T> implements ListADT<T> {

    private DoubleNode<T> front;
    private DoubleNode<T> rear;
    private int count;

    public LinkedList() {

        this.count = 0;
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Lista vazia");
        }
        DoubleNode<T> elementRemove = this.front;
        this.front = this.front.getNext();
        this.rear = null;
        count--;
        return elementRemove.getElement();

    }

    @Override
    public T removeLast() throws EmptyCollectionException {

        if (isEmpty()) {
            throw new EmptyCollectionException("Lista vazia");
        }

        DoubleNode<T> elementRemove = this.rear;
        this.rear = this.rear.getPrevious();
        this.rear.setNext(null);
        return elementRemove.getElement();

    }

    @Override
    public T remove(T element) {
        if (isEmpty()) {
            try {
                throw new EmptyCollectionException("Lista vazia");
            } catch (EmptyCollectionException ex) {
                Logger.getLogger(LinkedList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        boolean found = false;
        DoubleNode<T> previous = null;
        DoubleNode<T> current = this.front;
        while (current != null && !found) {

            if (element.equals(current.getElement())) {
                found = true;
            } else {
                previous = current;
                current = current.getNext();
            }
        }
        if (!found) {
            try {
                throw new ElementNotFoundException("Elemento nao encontrado");
            } catch (ElementNotFoundException ex) {
                Logger.getLogger(LinkedList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (size() == 1) {
            front = rear = null;
        } else if (current.equals(front)) {
            front = current.getNext();
            front.setPrevious(null);

        } else if (current.equals(rear)) {
            rear = previous;
            rear.setNext(null);
        } else {
            previous.setNext(current.getNext());
            current.getNext().setPrevious(previous);
        }
        count--;
        return current.getElement();
    }

    @Override
    public T first() throws EmptyCollectionException {
        return (T) this.front.getElement();
    }

    @Override
    public T last() throws EmptyCollectionException {
        return (T) this.rear.getElement();
    }

    @Override
    public boolean contains(T target) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator(front, count);
    }

    public DoubleNode<T> getFront() {
        return front;
    }

    public void setFront(DoubleNode<T> front) {
        this.front = front;
    }

    public DoubleNode<T> getRear() {
        return rear;
    }

    public void setRear(DoubleNode<T> rear) {
        this.rear = rear;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
