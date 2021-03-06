 package br.com.uninove.fabricaapp.espirometria.controllers;

import br.com.uninove.fabricaapp.espirometria.models.*;
import java.text.DecimalFormat;

public class Calculo {
   static final double NEPER = 2.7183;

    static double numArredondamentoCVFPrevisto = 2.709;
    static double numSubtracaoCVFPrevisto = 12.6205;
    static double numArredondamentoCVFInferior = 0.79;

    static double numArredondamentoVefPrevisto = 2.5431;
    static double numSubtracaoVefPrevisto = 11.8832;
    static double numArredondamentoVefInferior = 0.8;

    static double numArredondamentoFefPrevisto = 1.8309;
    static double numSubtracaoFefPrevisto = 8.5219;
    static double numArredondamentoFefInferior = 0.78;

    static double vefcvfPrevisto = 93;
    static double vefcvInferior = 83;

    static double feefcvfPrevisto = 118;
    static double feefcvfInferior = 91;

    static double numArredondamentoCVFPrevisto241 = 1.31;
    static double numArredondamentoCVFPrevisto242 = 0.317;
    static double numArredondamentoCFVPrevisto24 = 0.3529;
    static double numSubtracaoCFVPrevisto24 = 7.6487;

    static double numArredondamentoCVFInferior241 = 0.81;

    static double numArredondamentoVEFPrevisto241 = 1.2158;
    static double numArredondamentoVEFPrevisto242 = 0.19;
    static double numArredondamentoVEFPrevisto243 = 0.3077;
    static double numSubtracaoVEFPrevisto241 = 6.683;

    static double numArredondamentoVEFInferior241 = 0.82;

    static double numArredondamentoFEFPrevisto241 = 0.7513;
    static double numArredondamentoFEFPrevisto242 = 0.3303;
    static double numSubtracaoFEFPrevisto241 = 3.653;

    static double numArredondamentoFEFInferior241 = 0.68;

    static double numVEFCVFPrevisto241 = 94;
    static double numVEFCVFInferior241 = 82;

    static double numArredondarCVFPrevistoMaior241 = 0.059;
    static double numArredondarCVFPrevistoMaior242 = 0.0229;
    static double numSubtracaoCVFPrevistoMaior241 = 4.569;

    static double numSubtracaoCVFInferiorMaior241 = 0.864;

    static double numArredondarVEFPrevistoMaior241 = 0.0473;
    static double numArredondarVEFPrevistoMaior242 = 0.0281;
    static double numSubtracaoVEFPrevistoMaior241 = 3.145;

    static double numSubtracaoVEFInferiorMaior241 = 0.79;

    static double numArredondarFEFPrevistoMaior241 = 2.002;
    static double numArredondarFEFPrevistoMaior242 = 0.697;
    static double numSubtracaoFEFPrevistoMaior241 = 6.3279;

    static double numArredondarFEFInferiorMaior241 = 0.6;

    static double numArredondarVEFCFVPrevistoMaior241 = 4.854;
    static double numArredondarVEFCFVPrevistoMaior242 = 0.1198;
    static double numArredondarVEFCFVInferiorMaior241 = 0.9;

    static double numArredondarFEFCVFPrevistoMaior241 = 6.1205;
    static double numArredondarFEFCVFPrevistoMaior242 = 0.4407;
    static double numArredondarFEFCVFInferiorMaior241 = 0.6;

    //variaveis de arredondamento e subtracao feminino
    static double numArredondarCVFFemininoPrevisto = 0.02417;
    static double numArredondarCVFFemininoPrevisto2 = 0.0561;
    static double numArredondarCVFFemininoPrevisto3 = 0.01;
    static double numArredondarCVFFemininoPrevisto4 = 2.2197;
    static double numSubtracaoCVFFemininoPrevisto = 0.477;

    static double numArredondamentoVEFFemininoPrevisto = 0.02336;
    static double numArredondamentoVEFFemininoPrevisto2 = 0.0499;
    static double numArredondamentoVEFFemininoPrevisto3 = 0.008;
    static double numArredondamentoVEFFemininoPrevisto4 = 2.124;
    static double numSubtracaoVEFFemininoPrevisto = 0.429;

    static double numArredondamentoFEFFemininoPrevisto = 2.0561;
    static double numArredondamentoFEFFemininoPrevisto2 = 0.2791;
    static double numSubtracaoFEFFemininoPrevisto = 9.9287;
    static double numArredondamentoFEFFemininoInferior = 0.74;

    static double numArredondamentoveVEFCVFemininoPrevisto = 93;
    static double numArredondamentoveVEFCVFemininoInferior = 81;

    static double numArredondamentoFEFCVFFemininoPrevisto = 120;
    static double numArredondamentoFEFCVFFemininoInferior = 90;

    //numeros magicos de idade <= 19

    static double numArredondarCVFFemininoPrevisto19 = 1.7374;
    static double numArredondarCVFFemininoPrevisto192 = 0.2823;
    static double numArredondarCVFFemininoPrevisto193 = 0.1491;
    static double numSubtracaoCVFFemininoPrevisto19 = 9.0562;
    static double numArredondarCVFFemininoInferior19 = 0.87;

    static double numArredondamentoVEFFemininoPrevisto19 = 1.9293;
    static double numArredondamentoVEFFemininoPrevisto191 = 0.2255;
    static double numArredondamentoVEFFemininoPrevisto192 = 0.1105;
    static double numSubtracaoVEFFemininoPrevisto19 = 9.81;
    static double numArredondamentoVEFFemininoInferior19 = 0.87;

    static double numArredondamentoFEFFemininoPrevisto19 = 2.0561;
    static double numArredondamentoFEFFemininoPrevisto191 = 0.2791;
    static double numSubtracaoFEFFemininoPrevisto192 = 9.9287;
    static double numArredondamentoFEFInferior19 = 0.91;

    static double numVEFCVFFemininoPrevisto19 = 97;
    static double numVEFCVFFemininoInferior19 = 88;

    //numeros magicos para feminino idade maior que 19

    static double numArredondamentoCVFFemininoPrevistoMaior19 = 0.0433;
    static double numArredondamentoCVFFemininoPrevistoMaior191 = 0.0164;
    static double numSubtracaoCVFFemininoPrevistoMaior19 = 2.967;
    static double numSubtracaoCVFFemininoInferiorMaior19 = 0.556;

    static double numArredondamentoVEFFemininoPrevistoMaior19 = 0.0338;
    static double numArredondamentoVEFFemininoPrevistoMaior191 = 0.021;
    static double numSubtracaoVEFFemininoPrevistoMaior192 = 1.782;
    static double numSubtracaoVEFFemininoInferiorMaior19 = 0.433;

    static double numArredondamentoFEFFemininoPrevistoMaior19 = 1.2843;
    static double numArredondamentoFEFFemininoPrevistoMaior191 = 0.6546;
    static double numSubtracaoFEFFemininoPrevistoMaior192 = 3.0208;
    static double numArredondamentoFEFFemininoInferiorMaior19 = 0.6;

    static double numArredondamentoVEFCVFFemininoPrevistoMaior19 = 4.8707;
    static double numArredondamentoVEFCVFFemininoPrevistoMaior191 = 0.1212;
    static double numArredondamentoVEFCVFFemininoInferiorMaior19 = 0.9;

    static double numArredondamentoFEFCVFFemininoPrevistoMaior19 = 6.1032;
    static double numArredondamentoFEFCVFFemininoPrevistoMaior191 = 0.4237;
    static double numArredondamentoFEFCVFFemininoInferiorMaior19 = 0.6;

    static double[][] variaveis = new double[7][2];

    
     /**************************************************************************************]
     * Os valores das variaveis estão sendo representadas como:
     * 
     * variaveis [0][0], variaveis[0][1] equivalem a CV Previsto e  CV Inferior
     * 
     * variaveis [1][0], variaveis[1][1] equivalem a CVF Previsto e CVF Inferior
     * 
     * variaveis [2][0], variaveis[2][1] equivalem a VEF Previsto e VEF Inferior
     * 
     * variaveis [3][0], variaveis[3][1] equivalem a FEF Previsto e FEF Inferior
     * 
     * variaveis [4][0], variaveis[4][1] equivalem a VEFCVF Previsto e VEFCVF Inferior
     * 
     * variaveis [5][0], variaveis[5][1] equivalem a FEFCVF Previsto e FEFCVF Inferior
     *
     * @param num
     */
    ///Arredondamento para cima do valor // duas casas decimais
    public double arredondar(double num,int casasDecimais){
        return Math.ceil(num);
    }
    
    
    public Resultado calcular(Pessoa pessoa){
        Resultado res            = new Resultado();
        ResultadoItem  resPfe     = new ResultadoItem();
        ResultadoItem  resCv     = new ResultadoItem();
        ResultadoItem  resCvf    = new ResultadoItem();
        ResultadoItem  resVef    = new ResultadoItem();
        ResultadoItem  resFef    = new ResultadoItem();
        ResultadoItem  resVefCvf = new ResultadoItem();
        ResultadoItem  resFefCvf = new ResultadoItem();


      
        switch(pessoa.getSexo()){
            case 'm':
                if(pessoa.getIdade() < 14){

                  /*ALTERAÇÃO:  LEO - ALTERAÇÃO NO CALCULO SEGUINDO O PADRÃO JÁ TESTADO DA TESTEPROCALC*/
                    //CVF Previsto
                    resCvf.setPrevisto(Math.pow(NEPER, (Math.log(pessoa.getAltura()) * numArredondamentoCVFPrevisto) - numSubtracaoCVFPrevisto));
                    //CVF Inferior
                    resCvf.setInferior(resCvf.getPrevisto() * numArredondamentoCVFInferior);

                    //CV Previsto
                    resCv.setPrevisto(resCvf.getPrevisto());
                    //CV Inferior
                    resCv.setInferior((resCvf.getInferior()));

                    //vef Previsto
                    resVef.setPrevisto(((Math.pow(NEPER, (Math.log(pessoa.getAltura()) * numArredondamentoVefPrevisto) - numSubtracaoVefPrevisto))));
                    //vef Inferior
                    resVef.setInferior((resVef.getPrevisto() * numArredondamentoVefInferior));

                    //fef Previsto
                    resFef.setPrevisto(((Math.pow(NEPER, (Math.log(pessoa.getAltura()) * numArredondamentoFefPrevisto) - numSubtracaoFefPrevisto))));
                    //fef Inferior
                    resFef.setInferior(((resFef.getPrevisto() * numArredondamentoFefInferior)));

                    //vefcvf Previsto
                    resVefCvf.setPrevisto(vefcvfPrevisto);
                    //vefcvf Inferior
                    resVefCvf.setInferior(vefcvInferior);

                    //feefcvf Previsto
                    resFefCvf.setPrevisto(feefcvfPrevisto);
                    //feefcvf Inferior
                    resFefCvf.setInferior(feefcvfInferior);


                }else if(pessoa.getIdade() > 14 && pessoa.getIdade() <= 24){

                    //CVF Previsto
                    resCvf.setPrevisto((Math.pow(NEPER,((Math.log(pessoa.getAltura()) * 1.31) + (Math.log(pessoa.getIdade()) * 0.317)+ (Math.log(pessoa.getMassa()) * 0.3529) -7.6487))));
                    //CVF Inferior
                    resCvf.setInferior((resCvf.getPrevisto() * numArredondamentoCVFInferior241));

                    //CV Previsto
                    resCv.setPrevisto((resCvf.getPrevisto()));
                    //CV Inferior
                    resCv.setInferior((resCvf.getInferior()));


                    //vef Previsto
                    resVef.setPrevisto((Math.pow(NEPER, (Math.log(pessoa.getAltura()) * numArredondamentoVEFPrevisto241)+ (Math.log(pessoa.getIdade()) * numArredondamentoVEFPrevisto242) + (Math.log(pessoa.getMassa()) * numArredondamentoVEFPrevisto243) - numSubtracaoVEFPrevisto241)));
                    //vef Inferior
                    resVef.setInferior((resVef.getInferior() * numArredondamentoVEFInferior241));

                    //fef Previsto
                    resFef.setPrevisto((Math.pow(NEPER, (Math.log(pessoa.getAltura()) * numArredondamentoFEFPrevisto241) + (Math.log(pessoa.getMassa()) * numArredondamentoFEFPrevisto242) - numSubtracaoFEFPrevisto241)));
                    //fef Inferior
                    resFef.setInferior((resFef.getInferior() * numArredondamentoFEFInferior241));

                    //vefcvf Previsto
                    resVefCvf.setPrevisto(numVEFCVFPrevisto241);
                    //vefcvf Inferior
                    resVefCvf.setInferior(numVEFCVFInferior241);

                    //fefcvf Previsto
                    resFefCvf.setPrevisto(numVEFCVFPrevisto241);
                    //fefcvf Inferior
                    resFefCvf.setInferior(numVEFCVFInferior241);

                }else if(pessoa.getIdade() > 24){

                    //cvf Previsto
                    resCvf.setPrevisto(((pessoa.getAltura() * numArredondarCVFPrevistoMaior241) - (pessoa.getIdade() * numArredondarCVFPrevistoMaior242) - numSubtracaoCVFPrevistoMaior241 ));
                    //cvf Inferior
                    resCvf.setInferior((resCvf.getPrevisto() - numSubtracaoCVFInferiorMaior241));

                    //cv Previsto
                    resCv.setPrevisto((resCvf.getPrevisto()));
                    //cv Inferior
                    resCv.setInferior((resCvf.getInferior()));


                    //vef Previsto
                    resVef.setPrevisto(((pessoa.getAltura() * numArredondarVEFPrevistoMaior241) - (pessoa.getIdade() * 0.0281 )- numSubtracaoVEFPrevistoMaior241));
                    //vef Inferior
                    resVef.setInferior((resVef.getPrevisto() - numSubtracaoVEFInferiorMaior241));

                    //fef Previsto
                    resFef.setPrevisto((Math.pow(NEPER, Math.log(pessoa.getAltura()) * numArredondarFEFPrevistoMaior241 - Math.log(pessoa.getIdade()) * numArredondarFEFPrevistoMaior242 - numSubtracaoFEFPrevistoMaior241)));
                    //fef Inferior
                    resFef.setInferior((resFef.getPrevisto() * numArredondarFEFInferiorMaior241));

                    //vefcvf Previsto
                    resVefCvf.setPrevisto((Math.pow(NEPER, numArredondarVEFCFVPrevistoMaior241 - Math.log(pessoa.getIdade()) * numArredondarVEFCFVPrevistoMaior242)));
                    //vefcvf Inferior
                    resVefCvf.setInferior((resVefCvf.getPrevisto() * numArredondarVEFCFVInferiorMaior241));

                    //fefcvf Previsto
                    resFefCvf.setPrevisto((Math.pow(NEPER,numArredondarFEFCVFPrevistoMaior241 - Math.log(pessoa.getIdade()) * numArredondarFEFCVFPrevistoMaior242)));
                    //fefcvf Inferior
                    resFefCvf.setInferior((resFefCvf.getPrevisto() * numArredondarFEFCVFInferiorMaior241));
                }

                break;

            case 'f':

                if(pessoa.getIdade() < 14){

                    //cvf previsto
                    resCvf.setPrevisto((pessoa.getAltura() * numArredondarCVFFemininoPrevisto + pessoa.getIdade() * numArredondarCVFFemininoPrevisto2 + pessoa.getMassa() * numArredondarCVFFemininoPrevisto3 - numArredondarCVFFemininoPrevisto4));
                    //cvf inferior
                    resCvf.setInferior((resCvf.getPrevisto() - numSubtracaoCVFFemininoPrevisto));

                    //cv previsto
                    resCv.setPrevisto((resCvf.getPrevisto()));
                    //cv inferior
                    resCv.setInferior((resCvf.getInferior()));

                    //vef previsto
                    resVef.setPrevisto((pessoa.getAltura() * numArredondamentoVEFFemininoPrevisto + pessoa.getIdade() * numArredondamentoVEFFemininoPrevisto2 +pessoa.getMassa() * numArredondamentoVEFFemininoPrevisto3 - numArredondamentoVEFFemininoPrevisto4));
                    //vef inferior
                    resVef.setInferior((resVef.getPrevisto() - numSubtracaoVEFFemininoPrevisto));

                    //fef previsto
                    resFef.setPrevisto((Math.pow(NEPER,Math.log(pessoa.getAltura()) * numArredondamentoFEFFemininoPrevisto +Math.log(pessoa.getIdade()) * numArredondamentoFEFFemininoPrevisto2 - numSubtracaoFEFFemininoPrevisto)));
                    //fef inferior
                    resFef.setInferior((resFef.getPrevisto() * numArredondamentoFEFFemininoInferior));

                    //vefcvf previsto
                    resVefCvf.setPrevisto(numArredondamentoveVEFCVFemininoPrevisto);
                    //vefcvf inferior
                    resVefCvf.setInferior(numArredondamentoveVEFCVFemininoInferior);

                    //fefcvf previsto
                    resFefCvf.setPrevisto(numArredondamentoFEFCVFFemininoPrevisto);
                    //fefcvf inferior
                    resFefCvf.setInferior(numArredondamentoFEFCVFFemininoInferior);

                }else if(pessoa.getIdade() > 14 && pessoa.getIdade() <= 19){

                    //cvf previsto
                    resCvf.setPrevisto((Math.pow(NEPER, Math.log(pessoa.getAltura()) * numArredondarCVFFemininoPrevisto19 + Math.log(pessoa.getIdade()) * numArredondarCVFFemininoPrevisto192 +Math.log(pessoa.getMassa()) * numArredondarCVFFemininoPrevisto193 - numSubtracaoCVFFemininoPrevisto19)));
                    //cvf inferior
                    resCvf.setInferior((resCvf.getPrevisto() * numArredondarCVFFemininoInferior19));

                    //cv previsto
                    resCv.setPrevisto((resCvf.getPrevisto()));
                    //cv inferior
                    resCvf.setInferior((resCvf.getInferior()));

                    //vef previsto
                    resVef.setPrevisto((Math.pow(NEPER, Math.log(pessoa.getAltura()) * numArredondamentoVEFFemininoPrevisto19 +Math.log(pessoa.getIdade()) * numArredondamentoVEFFemininoPrevisto191 + Math.log(pessoa.getMassa()) * numArredondamentoVEFFemininoPrevisto192 - numSubtracaoVEFFemininoPrevisto19)));
                    //vef inferior
                    resVef.setInferior((resVef.getPrevisto() * numArredondamentoVEFFemininoInferior19));

                    //fef previsto
                    resFef.setPrevisto((Math.pow(NEPER,Math.log(pessoa.getAltura()) * numArredondamentoFEFFemininoPrevisto19 + Math.log(pessoa.getIdade()) * numArredondamentoFEFFemininoPrevisto191 - numSubtracaoFEFFemininoPrevisto192)));
                    //fef inferior
                    resFef.setInferior((resFef.getPrevisto() * numArredondamentoFEFInferior19));

                    //vefcvf previsto
                    resVefCvf.setPrevisto(numVEFCVFFemininoPrevisto19);
                    //vefcvf inferior
                    resVefCvf.setInferior(numVEFCVFFemininoInferior19);


                }else if(pessoa.getIdade() > 19){


                    //cvf previsto
                    resCvf.setPrevisto((pessoa.getAltura() * numArredondamentoCVFFemininoPrevistoMaior19 - pessoa.getIdade() * numArredondamentoCVFFemininoPrevistoMaior191 - numSubtracaoCVFFemininoPrevistoMaior19));
                    //cvf inferior
                    resCvf.setInferior((resCvf.getPrevisto() - numSubtracaoCVFFemininoInferiorMaior19));

                    //cv previsto
                    resCv.setPrevisto((resCvf.getPrevisto()));
                    //cv inferior
                    resCv.setInferior((resCvf.getInferior()));

                    //vef previsto
                    resVef.setPrevisto((pessoa.getAltura() * numArredondamentoVEFFemininoPrevistoMaior19 - pessoa.getIdade() * numArredondamentoVEFFemininoPrevistoMaior191 - numSubtracaoVEFFemininoPrevistoMaior192));
                    //vef inferior
                    resVef.setInferior((resVef.getPrevisto() - numSubtracaoVEFFemininoInferiorMaior19));

                    //fef previsto
                    resFef.setPrevisto((Math.pow(NEPER, Math.log(pessoa.getAltura()) * numArredondamentoFEFFemininoPrevistoMaior19 - Math.log(pessoa.getIdade()) * numArredondamentoFEFFemininoPrevistoMaior191 - numSubtracaoFEFFemininoPrevistoMaior192)));
                    //fef inferior
                    resFef.setInferior((resFef.getPrevisto() * numArredondamentoFEFFemininoInferiorMaior19));

                    //vefcvf previsto
                    resVefCvf.setPrevisto((Math.pow(NEPER, numArredondamentoVEFCVFFemininoPrevistoMaior19 - Math.log(pessoa.getIdade()) * numArredondamentoVEFCVFFemininoPrevistoMaior191)));
                    //vefcvf inferior
                    resVefCvf.setInferior((resVefCvf.getPrevisto() * numArredondamentoVEFCVFFemininoInferiorMaior19));

                    //fefcvf previsto
                    resFefCvf.setPrevisto((Math.pow(NEPER, numArredondamentoFEFCVFFemininoPrevistoMaior19 - Math.log(pessoa.getIdade()) * numArredondamentoFEFCVFFemininoPrevistoMaior191)));
                    //fefcvf inferior
                    resFefCvf.setInferior((resFefCvf.getPrevisto() * numArredondamentoFEFCVFFemininoInferiorMaior19));

                }
                break;
            default:
                System.exit(0);
        }
        
        res.setPfe(resPfe);
        res.setCv(resCv);
        res.setCvf(resCvf);
        res.setVef(resVef);
        res.setFef(resFef);
        res.setVefcvf(resVefCvf);
        res.setFefcvf(resFefCvf);

        return res;
    }
    
}
