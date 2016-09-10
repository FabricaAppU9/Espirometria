package espirometria.fabricaapp.uninove.com.br.procalc.models;

/**
 * Created by internet on 03/09/2016.
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    private String titulo;
    private double previsto;
    private double limite;


}
