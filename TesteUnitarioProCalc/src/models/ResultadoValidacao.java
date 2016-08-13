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
public class ResultadoValidacao {

    public boolean isResultado() {
        return resultado;
    }

    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }

    public String getMensagen() {
        return mensagen;
    }

    public void setMensagen(String mensagen) {
        this.mensagen = mensagen;
    }
    private boolean resultado;
    private String mensagen ;    
}
