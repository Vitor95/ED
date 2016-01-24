/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ED_11_Parte1_Ex3;

/**
 *
 * @author Vitor
 */
public class DemoLinkedHeap {

    /**
     * @param args the command line arguments
     * @throws ED_11_Parte1_Ex3.EmptyCollectionException
     */
    public static void main(String[] args) throws EmptyCollectionException {
        LinkedHeap<Integer> list = new LinkedHeap<>();
        list.addElement(3);
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);
        System.out.println("Element min: " + list.findMin());
        list.removeMin();
        System.out.println("After remove min...");
        System.out.println("Element min: " + list.findMin());
    }

}
