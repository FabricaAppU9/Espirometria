package espirometria.fabricaapp.uninove.com.br.procalc.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by internet on 03/09/2016.
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

    public ArrayList<ResultadoItem> toList(){
        ArrayList<ResultadoItem> list = new ArrayList<ResultadoItem>();
        list.add(this.cv);
        list.add(this.cvf);
        list.add(this.vef);
        list.add(this.fef);
        list.add(this.vefcvf);
        list.add(this.fefcvf);
        list.add(this.pfe);

        return list;
    }


    private ResultadoItem cv;
    private ResultadoItem cvf;
    private ResultadoItem vef;
    private ResultadoItem fef;
    private ResultadoItem vefcvf;
    private ResultadoItem fefcvf;
    private ResultadoItem pfe;
}
