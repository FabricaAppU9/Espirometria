package espirometria.fabricaapp.uninove.com.br.procalc.controllers;

import espirometria.fabricaapp.uninove.com.br.procalc.models.Pessoa;
import espirometria.fabricaapp.uninove.com.br.procalc.models.ResultadoValidacao;

/**
 * Created by internet on 03/09/2016.
 */
public class  Validacao {
    //Pegando Alturas por faixa de idade Masculinas 6 - 14 anos
    private static final double limiteMinAlturaMasc1 = 115;
    private static final double limiteMaxAlturaMasc1 = 160;

    //Pegando Alturas por faixa de idade Masculinas 15 - 24 anos
    private static final double limiteMinAlturaMasc2 = 155;
    private static final double limiteMaxAlturaMasc2 = 185;

    //Pegando Alturas por faixa de idade Masculinas 27 - 78 anos
    private static final double limiteMinAlturaMasc3 = 152;
    private static final double limiteMaxAlturaMasc3 = 182;

    //Pegando Alturas por faixa de idade Femininas 6 - 14 anos
    private static final double limiteMinAlturaFem1 = 116;
    private static final double limiteMaxAlturaFem1 = 167;

    //Pegando Alturas por faixa de idade Femininas 15 - 19 anos
    private static final double limiteMinAlturaFem2 = 144;
    private static final double limiteMaxAlturaFem2 = 174;

    //Pegando Alturas por faixa de idade Femininas 20 - 76 anos
    private static final double limiteMinAlturaFem3 = 136;
    private static final double limiteMaxAlturaFem3 = 170;



    private static ResultadoValidacao validarDeAcordoComLimite(Pessoa pessoa, double limiteMin, double limiteMax){
        ResultadoValidacao resultado = new ResultadoValidacao();
        if(pessoa.getAltura() >= limiteMin && pessoa.getAltura() <= limiteMax){
            resultado.setResultado(true);
        } else{
            resultado.setResultado(false);
            resultado.setMensagen("Altura fora dos padrões");
        }
        return resultado;
    }


    public ResultadoValidacao validar(Pessoa pessoa) {
        ResultadoValidacao res = new ResultadoValidacao();
        switch(pessoa.getSexo()){
            case 'M':
                res = validarDeAcordoComLimiteMasculino(pessoa);
                break;
            case 'F':
                res = validarDeAcordoComLimiteFeminino(pessoa);
                break;
        }
        return res;
    }

    private static ResultadoValidacao validarDeAcordoComLimiteFeminino(Pessoa pessoa) {
        ResultadoValidacao res;
        if(pessoa.getIdade() >= 6 && pessoa.getIdade() <= 14){
            res = validarDeAcordoComLimite(pessoa, limiteMinAlturaFem1, limiteMaxAlturaFem1);
        } else if(pessoa.getIdade() >= 15 && pessoa.getIdade() <= 24){
            res = validarDeAcordoComLimite(pessoa, limiteMinAlturaFem2, limiteMaxAlturaFem2);
        } else if(pessoa.getIdade() >= 25 && pessoa.getIdade() <= 78){
            res = validarDeAcordoComLimite(pessoa, limiteMinAlturaFem3, limiteMaxAlturaFem3);
        } else{
            res = new ResultadoValidacao();
            res.setResultado(false);
            res.setMensagen("Idade fora dos padrões");
        }
        return res;
    }

    private static ResultadoValidacao validarDeAcordoComLimiteMasculino(Pessoa pessoa) {
        ResultadoValidacao res;
        if(pessoa.getIdade() >= 6 && pessoa.getIdade() <= 14){
            res = validarDeAcordoComLimite(pessoa, limiteMinAlturaMasc1, limiteMaxAlturaMasc1);
        } else if(pessoa.getIdade() >= 15 && pessoa.getIdade() <= 24){
            res = validarDeAcordoComLimite(pessoa, limiteMinAlturaMasc2, limiteMaxAlturaMasc2);
        } else if(pessoa.getIdade() >= 25 && pessoa.getIdade() <= 78){
            res = validarDeAcordoComLimite(pessoa, limiteMinAlturaMasc3, limiteMaxAlturaMasc3);
        } else{
            //idade incorreta
            res = new ResultadoValidacao();
            res.setResultado(false);
            res.setMensagen("Idade fora dos padrões");
        }
        return res;
    }
}
