package espirometria.fabricaapp.uninove.com.br.procalc.models;

/**
 * Created by internet on 03/09/2016.
 */
public class Pessoa {
    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getMassa() {
        return massa;
    }

    public void setMassa(double massa) {
        this.massa = massa;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    private double altura;
    private double massa;
    private int idade;
    private char sexo;
}
