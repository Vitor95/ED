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
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T>{

 

    public ArrayUnorderedList() {
          super();
    }
    
    @Override
    public void addToFront(T o) {
        
      if(super.getRear()<99){
      
            for (int i = super.getRear(); i > 0; i--) {
           super.getT()[i]=super.getT()[i-1];
        
        }
            super.setRear(super.getRear()+1);
            super.getT()[0]=o;
            
      }
        
        
        
    }

    @Override
    public void addToRear(T o) {
        super.getT()[super.getRear()]=o;
        super.setRear(super.getRear()+1);
    
    }

    @Override
    public void addAfter(T element, T target) {
        int pos=-1;
        for (int i = 0; i < super.getRear(); i++) {
            if(super.getT()[i].equals(target)){
                pos=i;
            }
        }
        if(pos!=-1){
        for(int i=super.getRear(); i>pos;i--){
             super.getT()[i]=super.getT()[i-1];
        }
            super.setRear(super.getRear()+1);
            super.getT()[pos+1]=element;
        
        }
    
    }


    
}
