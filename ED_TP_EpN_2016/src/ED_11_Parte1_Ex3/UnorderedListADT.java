/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_11_Parte1_Ex3;


/**
 *
 * @author Vitor
 * @param <T>
 */
public interface UnorderedListADT<T> extends ListADT<T>{
    
    public void addToFront(T o);
    public void addToRear(T o);
    public void addAfter(T element, T target);
    
}
