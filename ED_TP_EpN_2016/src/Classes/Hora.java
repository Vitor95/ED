/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Vitor
 */
public class Hora implements Comparable{
    private int hora;
    private int minuto;

    public Hora(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    @Override
    public int compareTo(Object o) {
        Hora horaCompare = (Hora) o;
        if(horaCompare.hora<hora){
            return -1;
        }else if(horaCompare.hora>hora){
            return 1;
        }else if(horaCompare.minuto<minuto){
            return -1;
        }else{
        return 1;
        }
    }
    
    
}
