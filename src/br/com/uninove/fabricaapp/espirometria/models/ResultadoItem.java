/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author internet
 */
public class ResultadoItem {

    public double getPrevisto() {
        return previsto;
    }

    public void setPrevisto(double previsto) {
        this.previsto = previsto;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    private double previsto;
    private double limite;
   
}
