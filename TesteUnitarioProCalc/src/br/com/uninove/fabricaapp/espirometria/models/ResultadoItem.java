/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uninove.fabricaapp.espirometria.models;

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

    public double getInferior() {
        return limite;
    }

    public void setInferior(double limite) {
        this.limite = limite;
    }
    private double previsto;
    private double limite;
   
}
