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
public class DoubleLinkedOrderedList<T> extends LinkedList<T> implements OrderedListADT<T> {

    @Override
    public void add(T element) {
        Comparable temp = (Comparable) element;

        DoubleNode e = new DoubleNode(element);
        DoubleNode tt;

        boolean found = false;
// se vazia
        if (isEmpty()) {
            super.setRear(e);
            super.setFront(e) ;

        } else {
            tt = super.getFront();

            while (tt != null && !found) {
                if (temp.compareTo(tt.getElement()) > 0) {
                    tt = tt.getNext();
                } else {
                    found = true;
                }
            }
// adicionar a cauda
            if (tt == null) {

                super.getRear().setNext(e);
                e.setPrevious(super.getRear());
                super.setRear(e);
//adicionar a front
            } else if (tt.equals(super.getFront())) {
                
               e.setNext(super.getFront());
               super.getFront().setPrevious(e);
               super.setFront(e);
               
            } else {
//adicionar ao meio
                e.setPrevious(tt.getPrevious());
                e.setNext(tt);
                tt.setPrevious(e);
                e.getPrevious().setNext(e);
            }

        }
        super.setCount(super.getCount()+1);
    }
    }
