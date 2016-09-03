package espirometria.fabricaapp.uninove.com.br.procalc.models;

/**
 * Created by internet on 03/09/2016.
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
