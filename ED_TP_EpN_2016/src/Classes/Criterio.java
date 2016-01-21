/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Enum.TipoCriterio;

/**
 *
 * @author Vitor
 */
public class Criterio<T> {
    private TipoCriterio tipoCriterio;
    private T elemento;

    public Criterio(TipoCriterio tipoCriterio, T elemento) {
        this.tipoCriterio = tipoCriterio;
        this.elemento = elemento;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public TipoCriterio getTipoCriterio() {
        return tipoCriterio;
    }

    public void setTipoCriterio(TipoCriterio tipoCriterio) {
        this.tipoCriterio = tipoCriterio;
    }
    
}
