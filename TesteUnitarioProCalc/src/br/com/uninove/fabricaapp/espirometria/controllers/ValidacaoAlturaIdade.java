package br.com.uninove.fabricaapp.espirometria.controllers;

import br.com.uninove.fabricaapp.espirometria.models.*;
import models.ResultadoValidacao;



/**
 *
 * @author Guilherme & Junior
 */
public class ValidacaoAlturaIdade implements ItemValidacao {    
    
    //Pegando Alturas por faixa de idade Masculinas 6 - 14 anos
    private final double limiteMinAlturaMasc1 = 1.15;
    private final double limiteMaxAlturaMasc1 = 1.60;
    
    //Pegando Alturas por faixa de idade Masculinas 15 - 24 anos
    private final double limiteMinAlturaMasc2 = 1.55;
    private final double limiteMaxAlturaMasc2 = 1.85;
    
    //Pegando Alturas por faixa de idade Masculinas 27 - 78 anos
    private final double limiteMinAlturaMasc3 = 1.52;
    private final double limiteMaxAlturaMasc3 = 1.82;
    
    
    //Pegando Alturas por faixa de idade Femininas 6 - 14 anos
    private final double limiteMinAlturaFem1 = 1.16;
    private final double limiteMaxAlturaFem1 = 1.67;
    
    //Pegando Alturas por faixa de idade Femininas 15 - 19 anos
    private final double limiteMinAlturaFem2 = 1.44;
    private final double limiteMaxAlturaFem2 = 1.74;
    
    //Pegando Alturas por faixa de idade Femininas 20 - 76 anos
    private final double limiteMinAlturaFem3 = 1.36;
    private final double limiteMaxAlturaFem3 = 1.70;
    
    
    private ResultadoValidacao validarDeAcordoComLimite(Pessoa pessoa, double limiteMin, double limiteMax){
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
            case 'm':
                res = validarDeAcordoComLimiteMasculino(pessoa);
                break;            
            case 'f':
                res = validarDeAcordoComLimiteFeminino(pessoa);
                break;
        }
        return res;
    }

    private ResultadoValidacao validarDeAcordoComLimiteFeminino(Pessoa pessoa) {
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

    private ResultadoValidacao validarDeAcordoComLimiteMasculino(Pessoa pessoa) {
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
