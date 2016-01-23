/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_12_Parte1_Ex2;


/**
 * DoubleNode represents a node in a doubly linked list.
 * 
 */
public class DoubleNode<E>
{
    private DoubleNode<E> next;
    private E element;
    private DoubleNode<E> previous;
    /**
     * Creates an empty node.
     */
    public DoubleNode()
    {
       next = null;
       element = null;
       previous = null;
    }

    /**
     * Creates a node storing the specified element.
     * 
     * @param elem  the element to be stored into the new node
     */
    public DoubleNode (E elem)
    {
       next = null;
       element = elem;
       previous = null;
    }
/**
     * Returns the node that follows this one.
     *
     * @return  the node that follows the current one
     */
    public DoubleNode<E> getNext()
    {
       return next;
    }
        /**
     * Sets the node that precedes this one.
     * @param dnode  the node to be set as the one to precede 
     * the current one */
    public void setPrevious (DoubleNode<E> dnode) {
       previous = dnode;
    }
    /**
     * Returns the element stored in this node.
     * @return  the element stored in this node */
    public E getElement() {
       return element;
    }
    /**
     * Sets the element stored in this node.
     * @param elem  the element to be stored in this node */
    public void setElement (E elem){
       element = elem;
    }

    public DoubleNode<E> getPrevious() {
        return previous;
    }

    public void setNext(DoubleNode<E> next) {
        this.next = next;
    }
    
}