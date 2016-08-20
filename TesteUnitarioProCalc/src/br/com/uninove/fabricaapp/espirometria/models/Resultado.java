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
public class Resultado {

    public ResultadoItem getCv() {
        return cv;
    }

    public void setCv(ResultadoItem cv) {
        this.cv = cv;
    }

    public ResultadoItem getCvf() {
        return cvf;
    }

    public void setCvf(ResultadoItem cvf) {
        this.cvf = cvf;
    }

    public ResultadoItem getVef() {
        return vef;
    }

    public void setVef(ResultadoItem vef) {
        this.vef = vef;
    }

    public ResultadoItem getFef() {
        return fef;
    }

    public void setFef(ResultadoItem fef) {
        this.fef = fef;
    }

    public ResultadoItem getVefcvf() {
        return vefcvf;
    }

    public void setVefcvf(ResultadoItem vefcvf) {
        this.vefcvf = vefcvf;
    }

    public ResultadoItem getFefcvf() {
        return fefcvf;
    }

    public void setFefcvf(ResultadoItem fefcvf) {
        this.fefcvf = fefcvf;
    }

    public ResultadoItem getPfe() {
        return pfe;
    }

    public void setPfe(ResultadoItem pfe) {
        this.pfe = pfe;
    }
    private ResultadoItem cv;
    private ResultadoItem cvf;
    private ResultadoItem vef;
    private ResultadoItem fef;
    private ResultadoItem vefcvf;
    private ResultadoItem fefcvf;
    private ResultadoItem pfe;
}
