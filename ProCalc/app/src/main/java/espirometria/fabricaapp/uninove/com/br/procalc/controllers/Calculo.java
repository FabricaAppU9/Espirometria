package  espirometria.fabricaapp.uninove.com.br.procalc.controllers;
import java.awt.font.NumericShaper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;



import espirometria.fabricaapp.uninove.com.br.procalc.R;
import espirometria.fabricaapp.uninove.com.br.procalc.models.*;

/**
 * Created by internet on 03/09/2016.
 */
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


    /**********************************
     *  Novas Constantes para novo calculo
     */
    static double mascNumArredondamentoCVFNum1 = 0.0517;
    static double mascNumArredondamentoCVFNum2 = -0.0207;
    static double mascNumArredondamentoCVFNum3 = -3.18;

    static double mascNumArredondamentoCVFInferiorNum1 = 0.90;

    static double mascNumArredondamentoVEFNum1 = 0.0338;
    static double mascNumArredondamentoVEFNum2 = -0.0252;
    static double mascNumArredondamentoVEFNum3 = -0.789;

    static double mascNumArredondamentoVEFinferiorNum1 = 0.76;

    static double mascNumArredondamentoVEF6Num1  = 0.0521;
    static double mascNumArredondamentoVEF6Num2  = -0.0229;
    static double mascNumArredondamentoVEF6Num3  = -3.179;

    static double mascNumArredondamentoVEF6InferiorNum1   = 0.87;

    static double mascNumArredondamentoFEF2575Num1 = 0.687;
    static double mascNumArredondamentoFEF2575Num2 = 3.93;

    static double mascNumArredondamentoFEF2575InferiorNum1  = 0.59;

    //static double mascNumArredondamentoVEF1CVFNum1  = -0.175;
    static double mascNumArredondamentoVEF1CVFNum1  = 0.175;
    static double mascNumArredondamentoVEF1CVFNum2  = -0.197;
    static double mascNumArredondamentoVEF1CVFNum3  = 120.3;

    static double mascNumArredondamentoVEF1CVFInferiorNum1 = 7.6;

    static double mascNumArredondamentoFEF2575CVFNum1  = -1.609;
    static double mascNumArredondamentoFEF2575CVFNum2  = -0.454;
    static double mascNumArredondamentoFEF2575CVFNum3  = 14.39;

    static double mascNumArredondamentoFEF2575CVFInferiorNum1 = 0.64;

    static double femNumArredondamentoCVFNum1 = 0.0441;
    static double femNumArredondamentoCVFNum2 = - 0.0189;
    static double femNumArredondamentoCVFNum3 = - 2.848;

    static double femNumArredondamentoCVFInferiorNum1 = 0.64;

    static double femNumArredondamentoVEFNum1 = 0.0314;
    static double femNumArredondamentoVEFNum2 = - 0.0203;
    static double femNumArredondamentoVEFNum3 = - 1.353;

    static double femNumArredondamentoVEFinferiorNum1 = 0.610;

    static double femNumArredondamentoVEF6Num1  = 0.0437;
    static double femNumArredondamentoVEF6Num2  = - 0.0196;
    static double femNumArredondamentoVEF6Num3  = - 2.769;

    static double femNumArredondamentoVEF6InferiorNum1   = 0.61;

    static double femNumArredondamentoFEF2575Num1 = 0.998;
    static double femNumArredondamentoFEF2575Num2 = 0.588;
    static double femNumArredondamentoFEF2575Num3 = -1.852;

    static double femNumArredondamentoFEF2575InferiorNum1  = 0.57;

    static double femNumArredondamentoVEF1CVFNum1  = - 0.140;
    static double femNumArredondamentoVEF1CVFNum2  = - 0.158;
    static double femNumArredondamentoVEF1CVFNum3  = 111.5;

    static double femNumArredondamentoVEF1CVFInferiorNum1 = 8.50;

    static double femNumArredondamentoFEF2575CVFNum1  = - 1.401;
    static double femNumArredondamentoFEF2575CVFNum2  = - 0.319;
    static double femNumArredondamentoFEF2575CVFNum3  = 12.73;

    static double femNumArredondamentoFEF2575CVFInferiorNum1 = 0.61;




    /**************************************************************************************]
     *
     * @param
     */
    ///Arredondamento para cima do valor // duas casas decimais

     /*
         Caso o valor da 2º for impar e a 3º casa for 5 :  aumentar
         Caso o valor da 2º for  par e a 3º casa for 5 :  manter*
         Caso o valor da 2º for  par e a 3º casa for > 5 :  aumenta

         26/11/2016 - Guilherme Golfetto
         Alterado calculo do VEF/FEF inferior - (idade maior que 14)
         Resolvido problema no calculo de CV, corrigido problema de digitação  por motivos desconhecidos
         Valores Validados em relação ao Pro Calc
         27/11/2016 - Guilherme Golfetto
         Incluido desiçao na contagem de casas decimais no arredondamento, por algum motivo arremessava uma execeção em alguns casos

        18/02/2017 - Guilherme Golfetto
        ponto anotacao 01 - Foi alterado o calculo em relação a tabela
        de:
            FEF25-75 = neper ^ ( (Log(idade) * -0.687)  + 3.93)
        para:
            FEF25-75 = neper * ( (Log(idade) * -0.687)  + 3.93)

     */


    public double arredondar(double num){
        try{
            DecimalFormat  valorString = new DecimalFormat("#.000");
            String numeroFormatado;
            int primeiraCasa, segundaCasa;
            double arredondamento = 0;

            primeiraCasa =  0;
            segundaCasa = 0;

            numeroFormatado = valorString.format(num);

            numeroFormatado = numeroFormatado.substring(3,4);

            primeiraCasa =  Integer.valueOf(numeroFormatado.charAt(0));

            if(numeroFormatado.length() > 1){
                segundaCasa =  Integer.valueOf(numeroFormatado.charAt(1));
            }

            if(primeiraCasa % 2 != 0 && segundaCasa == 5 ){
                arredondamento = 0.01;
                //somar 0.01
            }else if(primeiraCasa % 2 == 0 && segundaCasa == 5 ){
                arredondamento = 0;
                //manter
            }else if (primeiraCasa % 2 == 0 && segundaCasa > 5 ){
                arredondamento = 0.01;
                // /somar 0.01
            }
            return num +  arredondamento;
        }catch (Exception e){
            e.getMessage();
            return 0;
        }
    }


    /**descontinuado*/
    public Resultado calcular_old(Pessoa pessoa){
        Resultado res            = new Resultado();
        ResultadoItem  resPfe     = new ResultadoItem();
        ResultadoItem  resCv     = new ResultadoItem();
        ResultadoItem  resCvf    = new ResultadoItem();
        ResultadoItem  resVef    = new ResultadoItem();
        ResultadoItem  resFef    = new ResultadoItem();
        ResultadoItem  resVefCvf = new ResultadoItem();
        ResultadoItem  resFefCvf = new ResultadoItem();

        resCv.setTitulo("CV(L)");
        resCvf.setTitulo("CVF(L)");
        resVef.setTitulo("VEF (L)");
        resFef.setTitulo("FEF(L/s)");
        resVefCvf.setTitulo("VEF/CVF(%)");
        resFefCvf.setTitulo("FEF/CVF(%)");
        resPfe.setTitulo("PFE");

        DecimalFormat  formatValue = new DecimalFormat("#.00");
        switch(pessoa.getSexo()){
            case 'M':
                if(pessoa.getIdade() < 14){

                  /*ALTERAÇÃO:  LEO - ALTERAÇÃO NO CALCULO SEGUINDO O PADRÃO JÁ TESTADO DA TESTEPROCALC*/
                    //CVF Previsto
                    resCvf.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER, (Math.log(pessoa.getAltura()) * numArredondamentoCVFPrevisto) - numSubtracaoCVFPrevisto)).replace(",",".")));
                    //CVF Inferior
                    resCvf.setInferior(Double.parseDouble(formatValue.format(resCvf.getPrevisto() * numArredondamentoCVFInferior).replace(",",".")));

                    //CV Previsto
                    resCv.setPrevisto(Double.parseDouble(formatValue.format(resCvf.getPrevisto()).replace(",",".")));
                    //CV Inferior
                    resCv.setInferior(Double.parseDouble(formatValue.format(resCvf.getInferior()).replace(",",".")));

                    //vef Previsto
                    resVef.setPrevisto(Double.parseDouble(formatValue.format((Math.pow(NEPER, (Math.log(pessoa.getAltura()) * numArredondamentoVefPrevisto) - numSubtracaoVefPrevisto))).replace(",",".")));
                    //vef Inferior
                    resVef.setInferior(Double.parseDouble(formatValue.format(arredondar(resVef.getPrevisto() * numArredondamentoVefInferior)).replace(",",".")));

                    //fef Previsto
                    resFef.setPrevisto(Double.parseDouble(formatValue.format((Math.pow(NEPER, (Math.log(pessoa.getAltura()) * numArredondamentoFefPrevisto) - numSubtracaoFefPrevisto))).replace(",",".")));
                    //fef Inferior
                    resFef.setInferior(Double.parseDouble(formatValue.format(arredondar((resFef.getPrevisto() * numArredondamentoFefInferior))).replace(",",".")));

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
                    resCvf.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER,((Math.log(pessoa.getAltura()) * 1.31) + (Math.log(pessoa.getIdade()) * 0.317)+ (Math.log(pessoa.getMassa()) * 0.3529) -7.6487))).replace(",",".")));
                    //CVF Inferior
                    resCvf.setInferior(Double.parseDouble(formatValue.format(resCvf.getPrevisto() * numArredondamentoCVFInferior241).replace(",",".")));

                    //CV Previsto
                    resCv.setPrevisto(Double.parseDouble(formatValue.format(resCvf.getPrevisto()).replace(",",".")));
                    //CV Inferior
                    resCv.setInferior(Double.parseDouble(formatValue.format(resCvf.getInferior()).replace(",",".")));


                    //vef Previsto
                    resVef.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER, (Math.log(pessoa.getAltura()) * numArredondamentoVEFPrevisto241)+ (Math.log(pessoa.getIdade()) * numArredondamentoVEFPrevisto242) + (Math.log(pessoa.getMassa()) * numArredondamentoVEFPrevisto243) - numSubtracaoVEFPrevisto241)).replace(",",".")));
                    //vef Inferior
                    resVef.setInferior(Double.parseDouble(formatValue.format(arredondar(resVef.getPrevisto() * numArredondamentoVEFInferior241)).replace(",",".")));

                    //fef Previsto
                    resFef.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER, (Math.log(pessoa.getAltura()) * numArredondamentoFEFPrevisto241) + (Math.log(pessoa.getMassa()) * numArredondamentoFEFPrevisto242) - numSubtracaoFEFPrevisto241)).replace(",",".")));
                    //fef Inferior
                    resFef.setInferior(Double.parseDouble(formatValue.format(arredondar(resFef.getPrevisto() * numArredondamentoFEFInferior241)).replace(",",".")));

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
                    resCvf.setPrevisto(Double.parseDouble(formatValue.format((pessoa.getAltura() * numArredondarCVFPrevistoMaior241) - (pessoa.getIdade() * numArredondarCVFPrevistoMaior242) - numSubtracaoCVFPrevistoMaior241 ).replace(",",".")));
                    //cvf Inferior
                    resCvf.setInferior(Double.parseDouble(formatValue.format(resCvf.getPrevisto() - numSubtracaoCVFInferiorMaior241).replace(",",".")));

                    //cv Previsto
                    resCv.setPrevisto(Double.parseDouble(formatValue.format(resCvf.getPrevisto()).replace(",",".")));
                    //cv Inferior
                    resCv.setInferior(Double.parseDouble(formatValue.format(resCvf.getInferior()).replace(",",".")));


                    //vef Previsto
                    resVef.setPrevisto(Double.parseDouble(formatValue.format((pessoa.getAltura() * numArredondarVEFPrevistoMaior241) - (pessoa.getIdade() * 0.0281 )- numSubtracaoVEFPrevistoMaior241).replace(",",".")));
                    //vef Inferior
                    resVef.setInferior(Double.parseDouble(formatValue.format(arredondar(resVef.getPrevisto() - numSubtracaoVEFInferiorMaior241)).replace(",",".")));

                    //fef Previsto
                    resFef.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER, Math.log(pessoa.getAltura()) * numArredondarFEFPrevistoMaior241 - Math.log(pessoa.getIdade()) * numArredondarFEFPrevistoMaior242 - numSubtracaoFEFPrevistoMaior241)).replace(",",".")));
                    //fef Inferior
                    resFef.setInferior(Double.parseDouble(formatValue.format(arredondar(resFef.getPrevisto() * numArredondarFEFInferiorMaior241)).replace(",",".")));

                    //vefcvf Previsto
                    resVefCvf.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER, numArredondarVEFCFVPrevistoMaior241 - Math.log(pessoa.getIdade()) * numArredondarVEFCFVPrevistoMaior242)).replace(",",".")));
                    //vefcvf Inferior
                    resVefCvf.setInferior(Double.parseDouble(formatValue.format(resVefCvf.getPrevisto() * numArredondarVEFCFVInferiorMaior241).replace(",",".")));

                    //fefcvf Previsto
                    resFefCvf.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER,numArredondarFEFCVFPrevistoMaior241 - Math.log(pessoa.getIdade()) * numArredondarFEFCVFPrevistoMaior242)).replace(",",".")));
                    //fefcvf Inferior
                    resFefCvf.setInferior(Double.parseDouble(formatValue.format(resFefCvf.getPrevisto() * numArredondarFEFCVFInferiorMaior241).replace(",",".")));
                }

                break;

            case 'F':

                if(pessoa.getIdade() < 14){

                    //cvf previsto
                    resCvf.setPrevisto(Double.parseDouble(formatValue.format(pessoa.getAltura() * numArredondarCVFFemininoPrevisto + pessoa.getIdade() * numArredondarCVFFemininoPrevisto2 + pessoa.getMassa() * numArredondarCVFFemininoPrevisto3 - numArredondarCVFFemininoPrevisto4).replace(",",".")));
                    //cvf inferior
                    resCvf.setInferior(Double.parseDouble(formatValue.format(resCvf.getPrevisto() - numSubtracaoCVFFemininoPrevisto).replace(",",".")));

                    //cv previsto
                    resCv.setPrevisto(Double.parseDouble(formatValue.format(resCvf.getPrevisto()).replace(",",".")));
                    //cv inferior
                    resCv.setInferior(Double.parseDouble(formatValue.format(resCvf.getInferior()).replace(",",".")));

                    //vef previsto
                    resVef.setPrevisto(Double.parseDouble(formatValue.format(pessoa.getAltura() * numArredondamentoVEFFemininoPrevisto + pessoa.getIdade() * numArredondamentoVEFFemininoPrevisto2 +pessoa.getMassa() * numArredondamentoVEFFemininoPrevisto3 - numArredondamentoVEFFemininoPrevisto4).replace(",",".")));
                    //vef inferior
                    resVef.setInferior(Double.parseDouble(formatValue.format(arredondar(resVef.getPrevisto() - numSubtracaoVEFFemininoPrevisto)).replace(",",".")));

                    //fef previsto
                    resFef.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER,Math.log(pessoa.getAltura()) * numArredondamentoFEFFemininoPrevisto +Math.log(pessoa.getIdade()) * numArredondamentoFEFFemininoPrevisto2 - numSubtracaoFEFFemininoPrevisto)).replace(",",".")));
                    //fef inferior
                    resFef.setInferior(Double.parseDouble(formatValue.format(arredondar(resFef.getPrevisto() * numArredondamentoFEFFemininoInferior)).replace(",",".")));

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
                    resCvf.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER, Math.log(pessoa.getAltura()) * numArredondarCVFFemininoPrevisto19 + Math.log(pessoa.getIdade()) * numArredondarCVFFemininoPrevisto192 +Math.log(pessoa.getMassa()) * numArredondarCVFFemininoPrevisto193 - numSubtracaoCVFFemininoPrevisto19)).replace(",",".")));
                    //cvf inferior
                    resCvf.setInferior(Double.parseDouble(formatValue.format(resCvf.getPrevisto() * numArredondarCVFFemininoInferior19).replace(",",".")));

                    //cv previsto
                    resCv.setPrevisto(Double.parseDouble(formatValue.format(resCvf.getPrevisto()).replace(",",".")));
                    //cv inferior
                    resCv.setInferior(Double.parseDouble(formatValue.format(resCvf.getInferior()).replace(",",".")));

                    //vef previsto
                    resVef.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER, Math.log(pessoa.getAltura()) * numArredondamentoVEFFemininoPrevisto19 +Math.log(pessoa.getIdade()) * numArredondamentoVEFFemininoPrevisto191 + Math.log(pessoa.getMassa()) * numArredondamentoVEFFemininoPrevisto192 - numSubtracaoVEFFemininoPrevisto19)).replace(",",".")));
                    //vef inferior
                    resVef.setInferior(Double.parseDouble(formatValue.format(arredondar(resVef.getPrevisto() * numArredondamentoVEFFemininoInferior19)).replace(",",".")));

                    //fef previsto
                    resFef.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER,Math.log(pessoa.getAltura()) * numArredondamentoFEFFemininoPrevisto19 + Math.log(pessoa.getIdade()) * numArredondamentoFEFFemininoPrevisto191 - numSubtracaoFEFFemininoPrevisto192)).replace(",",".")));
                    //fef inferior
                    resFef.setInferior(Double.parseDouble(formatValue.format(arredondar((resFef.getPrevisto() * numArredondamentoFEFInferior19))).replace(",",".")));

                    //vefcvf previsto
                    resVefCvf.setPrevisto(numVEFCVFFemininoPrevisto19);
                    //vefcvf inferior
                    resVefCvf.setInferior(numVEFCVFFemininoInferior19);


                }else if(pessoa.getIdade() > 19){


                    //cvf previsto
                    resCvf.setPrevisto(Double.parseDouble(formatValue.format(pessoa.getAltura() * numArredondamentoCVFFemininoPrevistoMaior19 - pessoa.getIdade() * numArredondamentoCVFFemininoPrevistoMaior191 - numSubtracaoCVFFemininoPrevistoMaior19).replace(",",".")));
                    //cvf inferior
                    resCvf.setInferior(Double.parseDouble(formatValue.format(resCvf.getPrevisto() - numSubtracaoCVFFemininoInferiorMaior19).replace(",",".")));

                    //cv previsto
                    resCv.setPrevisto(Double.parseDouble(formatValue.format(resCvf.getPrevisto()).replace(",",".")));
                    //cv inferior
                    resCv.setInferior(Double.parseDouble(formatValue.format(resCvf.getInferior()).replace(",",".")));

                    //vef previsto
                    resVef.setPrevisto(Double.parseDouble(formatValue.format(pessoa.getAltura() * numArredondamentoVEFFemininoPrevistoMaior19 - pessoa.getIdade() * numArredondamentoVEFFemininoPrevistoMaior191 - numSubtracaoVEFFemininoPrevistoMaior192).replace(",",".")));
                    //vef inferior
                    resVef.setInferior(Double.parseDouble(formatValue.format(arredondar(resVef.getPrevisto() - numSubtracaoVEFFemininoInferiorMaior19)).replace(",",".")));

                    //fef previsto
                    resFef.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER, Math.log(pessoa.getAltura()) * numArredondamentoFEFFemininoPrevistoMaior19 - Math.log(pessoa.getIdade()) * numArredondamentoFEFFemininoPrevistoMaior191 - numSubtracaoFEFFemininoPrevistoMaior192)).replace(",",".")));
                    //fef inferior
                    resFef.setInferior(Double.parseDouble(formatValue.format(arredondar(resFef.getPrevisto() * numArredondamentoFEFFemininoInferiorMaior19)).replace(",",".")));

                    //vefcvf previsto
                    resVefCvf.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER, numArredondamentoVEFCVFFemininoPrevistoMaior19 - Math.log(pessoa.getIdade()) * numArredondamentoVEFCVFFemininoPrevistoMaior191)).replace(",",".")));
                    //vefcvf inferior
                    resVefCvf.setInferior(Double.parseDouble(formatValue.format(resVefCvf.getPrevisto() * numArredondamentoVEFCVFFemininoInferiorMaior19).replace(",",".")));

                    //fefcvf previsto
                    resFefCvf.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER, numArredondamentoFEFCVFFemininoPrevistoMaior19 - Math.log(pessoa.getIdade()) * numArredondamentoFEFCVFFemininoPrevistoMaior191)).replace(",",".")));
                    //fefcvf inferior
                    resFefCvf.setInferior(Double.parseDouble(formatValue.format(resFefCvf.getPrevisto() * numArredondamentoFEFCVFFemininoInferiorMaior19).replace(",",".")));

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



    public Resultado calcular(Pessoa pessoa){

        Resultado res            = new Resultado();
        ResultadoItem  resPfe    = new ResultadoItem();
        ResultadoItem  resCv     = new ResultadoItem();
        ResultadoItem  resCvf    = new ResultadoItem();
        ResultadoItem  resVef    = new ResultadoItem();
        ResultadoItem  resVef6   = new ResultadoItem();
        ResultadoItem  resFef    = new ResultadoItem();
        ResultadoItem  resVefCvf = new ResultadoItem();
        ResultadoItem  resFefCvf = new ResultadoItem();

        resCv.setTitulo("CV(L)");
        resCvf.setTitulo("CVF(L)");
        resVef.setTitulo("VEF (L)");
        resVef6.setTitulo("VEF (6)");
        resFef.setTitulo("FEF(L/s)");
        resVefCvf.setTitulo("VEF/CVF(%)");
        resFefCvf.setTitulo("FEF/CVF(%)");
        resPfe.setTitulo("PFE");

        DecimalFormat  formatValue = new DecimalFormat("#.00");
        switch(pessoa.getSexo()){
            case 'M':
                if(pessoa.getIdade() < 14){

                  /*ALTERAÇÃO:  LEO - ALTERAÇÃO NO CALCULO SEGUINDO O PADRÃO JÁ TESTADO DA TESTEPROCALC*/
                    //CVF Previsto
                    resCvf.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER, (Math.log(pessoa.getAltura()) * numArredondamentoCVFPrevisto) - numSubtracaoCVFPrevisto)).replace(",",".")));
                    //CVF Inferior
                    resCvf.setInferior(Double.parseDouble(formatValue.format(resCvf.getPrevisto() * numArredondamentoCVFInferior).replace(",",".")));

                    //CV Previsto
                    resCv.setPrevisto(Double.parseDouble(formatValue.format(resCvf.getPrevisto()).replace(",",".")));
                    //CV Inferior
                    resCv.setInferior(Double.parseDouble(formatValue.format(resCvf.getInferior()).replace(",",".")));

                    //vef Previsto
                    resVef.setPrevisto(Double.parseDouble(formatValue.format((Math.pow(NEPER, (Math.log(pessoa.getAltura()) * numArredondamentoVefPrevisto) - numSubtracaoVefPrevisto))).replace(",",".")));
                    //vef Inferior
                    resVef.setInferior(Double.parseDouble(formatValue.format(arredondar(resVef.getPrevisto() * numArredondamentoVefInferior)).replace(",",".")));

                    //fef Previsto
                    resFef.setPrevisto(Double.parseDouble(formatValue.format((Math.pow(NEPER, (Math.log(pessoa.getAltura()) * numArredondamentoFefPrevisto) - numSubtracaoFefPrevisto))).replace(",",".")));
                    //fef Inferior
                    resFef.setInferior(Double.parseDouble(formatValue.format(arredondar((resFef.getPrevisto() * numArredondamentoFefInferior))).replace(",",".")));

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
                    resCvf.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER,((Math.log(pessoa.getAltura()) * 1.31) + (Math.log(pessoa.getIdade()) * 0.317)+ (Math.log(pessoa.getMassa()) * 0.3529) -7.6487))).replace(",",".")));
                    //CVF Inferior
                    resCvf.setInferior(Double.parseDouble(formatValue.format(resCvf.getPrevisto() * numArredondamentoCVFInferior241).replace(",",".")));

                    //CV Previsto
                    resCv.setPrevisto(Double.parseDouble(formatValue.format(resCvf.getPrevisto()).replace(",",".")));
                    //CV Inferior
                    resCv.setInferior(Double.parseDouble(formatValue.format(resCvf.getInferior()).replace(",",".")));


                    //vef Previsto
                    resVef.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER, (Math.log(pessoa.getAltura()) * numArredondamentoVEFPrevisto241)+ (Math.log(pessoa.getIdade()) * numArredondamentoVEFPrevisto242) + (Math.log(pessoa.getMassa()) * numArredondamentoVEFPrevisto243) - numSubtracaoVEFPrevisto241)).replace(",",".")));
                    //vef Inferior
                    resVef.setInferior(Double.parseDouble(formatValue.format(arredondar(resVef.getPrevisto() * numArredondamentoVEFInferior241)).replace(",",".")));

                    //fef Previsto
                    resFef.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER, (Math.log(pessoa.getAltura()) * numArredondamentoFEFPrevisto241) + (Math.log(pessoa.getMassa()) * numArredondamentoFEFPrevisto242) - numSubtracaoFEFPrevisto241)).replace(",",".")));
                    //fef Inferior
                    resFef.setInferior(Double.parseDouble(formatValue.format(arredondar(resFef.getPrevisto() * numArredondamentoFEFInferior241)).replace(",",".")));

                    //vefcvf Previsto
                    resVefCvf.setPrevisto(numVEFCVFPrevisto241);
                    //vefcvf Inferior
                    resVefCvf.setInferior(numVEFCVFInferior241);

                    //fefcvf Previsto
                    resFefCvf.setPrevisto(numVEFCVFPrevisto241);
                    //fefcvf Inferior
                    resFefCvf.setInferior(numVEFCVFInferior241);

                }else if(pessoa.getIdade() > 24 ){
                    //acerto de calculo 11/02
                    resCvf.setPrevisto(Double.parseDouble(formatValue.format((pessoa.getAltura() * mascNumArredondamentoCVFNum1) + (pessoa.getIdade() * mascNumArredondamentoCVFNum2) + (mascNumArredondamentoCVFNum3)).replace(",", ".")));
                    resCvf.setInferior(Double.parseDouble(formatValue.format( resCvf.getPrevisto() - mascNumArredondamentoCVFInferiorNum1).replace(",",".")));

                    resCv.setPrevisto(Double.parseDouble(formatValue.format(resCvf.getPrevisto()).replace(",",".")));
                    resCv.setInferior(Double.parseDouble(formatValue.format(resCvf.getInferior()).replace(",",".")));

                    resVef.setPrevisto(Double.parseDouble(formatValue.format((pessoa.getAltura() * mascNumArredondamentoVEFNum1) + (pessoa.getIdade() * mascNumArredondamentoVEFNum2) + (mascNumArredondamentoVEFNum3)).replace(",",".")));
                    resVef.setInferior(Double.parseDouble(formatValue.format( resVef.getPrevisto() - mascNumArredondamentoVEFinferiorNum1).replace(",",".")));

                    resVef6.setPrevisto(Double.parseDouble(formatValue.format((pessoa.getAltura() * mascNumArredondamentoVEF6Num1) + (pessoa.getIdade() * mascNumArredondamentoVEF6Num2) + (mascNumArredondamentoVEF6Num3)).replace(",",".")));
                    resVef6.setInferior(Double.parseDouble(formatValue.format(resVef6.getPrevisto() - mascNumArredondamentoVEF6InferiorNum1).replace(",",".")));

                    //resFef.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER, (Math.log(pessoa.getIdade()) * mascNumArredondamentoFEF2575Num1) + mascNumArredondamentoFEF2575Num2 )).replace(",","."))); <-- ponto anotacao 01

                    resFef.setPrevisto(Double.parseDouble(formatValue.format(
                            Math.pow(Math.E,(-Math.log(pessoa.getIdade()) * mascNumArredondamentoFEF2575Num1 + mascNumArredondamentoFEF2575Num2))
                        ).replace(",",".")));
                    resFef.setInferior( Double.parseDouble(formatValue.format( resFef.getPrevisto() * mascNumArredondamentoFEF2575InferiorNum1).replace(",",".")));





                    // ALTERADO A CONSTANTE mascNumArredondamentoVEF1CVFNum1 ELA ESTAVA NEGATIVA.
                    resVefCvf.setPrevisto( Double.parseDouble(formatValue.format((pessoa.getAltura() * mascNumArredondamentoVEF1CVFNum1) + (pessoa.getIdade() * mascNumArredondamentoVEF1CVFNum2) + (mascNumArredondamentoVEF1CVFNum3)).replace(",",".")));
                    resVefCvf.setInferior( Double.parseDouble(formatValue.format(resVefCvf.getPrevisto() - mascNumArredondamentoVEF1CVFInferiorNum1).replace(",",".")));





                    //resFefCvf.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER, (Math.log(pessoa.getAltura()) * mascNumArredondamentoFEF2575CVFNum1) + (Math.log(pessoa.getIdade()) * mascNumArredondamentoFEF2575CVFNum2 ) + mascNumArredondamentoFEF2575CVFNum3 )).replace(",",".")));


                   //  double cvf =  (pessoa.getAltura() * mascNumArredondamentoCVFNum1) + (pessoa.getIdade() * mascNumArredondamentoCVFNum2) + (mascNumArredondamentoCVFNum3);

                    // UTILIZEI O RESULTADOFEF PARA O CALCULO DO FEFCVF
                    //double fefcvf = resultadoFEF/cvf;

                    // ANTIGO
                    //resFefCvf.setPrevisto(Double.parseDouble(formatValue.format(NEPER * (Math.log(pessoa.getAltura()) * mascNumArredondamentoFEF2575CVFNum1) + (Math.log(pessoa.getIdade()) * mascNumArredondamentoFEF2575CVFNum2 ) + mascNumArredondamentoFEF2575CVFNum3 ).replace(",",".")));
                    double result =  0.68 * 0.64;
                    resFefCvf.setPrevisto(Double.parseDouble(formatValue.format(
                            ( Math.pow(Math.E,(-Math.log(pessoa.getIdade()) * mascNumArredondamentoFEF2575Num1 + mascNumArredondamentoFEF2575Num2)))/((pessoa.getAltura() * mascNumArredondamentoCVFNum1) + (pessoa.getIdade() * mascNumArredondamentoCVFNum2) + (mascNumArredondamentoCVFNum3))
                    ).replace(",",".")));
                    resFefCvf.setInferior(Double.parseDouble(formatValue.format(resFefCvf.getPrevisto() * mascNumArredondamentoFEF2575CVFInferiorNum1).replace(",",".")));

                }
                break;

            case 'F':


                if(pessoa.getIdade() < 14){

                    //cvf previsto
                    resCvf.setPrevisto(Double.parseDouble(formatValue.format(pessoa.getAltura() * numArredondarCVFFemininoPrevisto + pessoa.getIdade() * numArredondarCVFFemininoPrevisto2 + pessoa.getMassa() * numArredondarCVFFemininoPrevisto3 - numArredondarCVFFemininoPrevisto4).replace(",",".")));
                    //cvf inferior
                    resCvf.setInferior(Double.parseDouble(formatValue.format(resCvf.getPrevisto() - numSubtracaoCVFFemininoPrevisto).replace(",",".")));

                    //cv previsto
                    resCv.setPrevisto(Double.parseDouble(formatValue.format(resCvf.getPrevisto()).replace(",",".")));
                    //cv inferior
                    resCv.setInferior(Double.parseDouble(formatValue.format(resCvf.getInferior()).replace(",",".")));

                    //vef previsto
                    resVef.setPrevisto(Double.parseDouble(formatValue.format(pessoa.getAltura() * numArredondamentoVEFFemininoPrevisto + pessoa.getIdade() * numArredondamentoVEFFemininoPrevisto2 +pessoa.getMassa() * numArredondamentoVEFFemininoPrevisto3 - numArredondamentoVEFFemininoPrevisto4).replace(",",".")));
                    //vef inferior
                    resVef.setInferior(Double.parseDouble(formatValue.format(arredondar(resVef.getPrevisto() - numSubtracaoVEFFemininoPrevisto)).replace(",",".")));

                    //fef previsto
                    resFef.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER,Math.log(pessoa.getAltura()) * numArredondamentoFEFFemininoPrevisto +Math.log(pessoa.getIdade()) * numArredondamentoFEFFemininoPrevisto2 - numSubtracaoFEFFemininoPrevisto)).replace(",",".")));
                    //fef inferior
                    resFef.setInferior(Double.parseDouble(formatValue.format(arredondar(resFef.getPrevisto() * numArredondamentoFEFFemininoInferior)).replace(",",".")));

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
                    resCvf.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER, Math.log(pessoa.getAltura()) * numArredondarCVFFemininoPrevisto19 + Math.log(pessoa.getIdade()) * numArredondarCVFFemininoPrevisto192 +Math.log(pessoa.getMassa()) * numArredondarCVFFemininoPrevisto193 - numSubtracaoCVFFemininoPrevisto19)).replace(",",".")));
                    //cvf inferior
                    resCvf.setInferior(Double.parseDouble(formatValue.format(resCvf.getPrevisto() * numArredondarCVFFemininoInferior19).replace(",",".")));

                    //cv previsto
                    resCv.setPrevisto(Double.parseDouble(formatValue.format(resCvf.getPrevisto()).replace(",",".")));
                    //cv inferior
                    resCv.setInferior(Double.parseDouble(formatValue.format(resCvf.getInferior()).replace(",",".")));

                    //vef previsto
                    resVef.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER, Math.log(pessoa.getAltura()) * numArredondamentoVEFFemininoPrevisto19 +Math.log(pessoa.getIdade()) * numArredondamentoVEFFemininoPrevisto191 + Math.log(pessoa.getMassa()) * numArredondamentoVEFFemininoPrevisto192 - numSubtracaoVEFFemininoPrevisto19)).replace(",",".")));
                    //vef inferior
                    resVef.setInferior(Double.parseDouble(formatValue.format(arredondar(resVef.getPrevisto() * numArredondamentoVEFFemininoInferior19)).replace(",",".")));

                    //fef previsto
                    resFef.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER,Math.log(pessoa.getAltura()) * numArredondamentoFEFFemininoPrevisto19 + Math.log(pessoa.getIdade()) * numArredondamentoFEFFemininoPrevisto191 - numSubtracaoFEFFemininoPrevisto192)).replace(",",".")));
                    //fef inferior
                    resFef.setInferior(Double.parseDouble(formatValue.format(arredondar((resFef.getPrevisto() * numArredondamentoFEFInferior19))).replace(",",".")));

                    //vefcvf previsto
                    resVefCvf.setPrevisto(numVEFCVFFemininoPrevisto19);
                    //vefcvf inferior
                    resVefCvf.setInferior(numVEFCVFFemininoInferior19);


                }else if(pessoa.getIdade() > 19) {

                    resCvf.setPrevisto(Double.parseDouble(formatValue.format((pessoa.getAltura() * femNumArredondamentoCVFNum1) + (pessoa.getIdade() * femNumArredondamentoCVFNum2) + (femNumArredondamentoCVFNum3)).replace(",",".")));
                    resCvf.setInferior( Double.parseDouble(formatValue.format( resCvf.getPrevisto() - femNumArredondamentoCVFInferiorNum1).replace(",",".")));

                    resCv.setPrevisto( Double.parseDouble(formatValue.format(resCvf.getPrevisto()).replace(",",".")));
                    resCv.setInferior( Double.parseDouble(formatValue.format(resCvf.getInferior()).replace(",",".")));


                    resVef.setPrevisto( Double.parseDouble(formatValue.format((pessoa.getAltura() * femNumArredondamentoVEFNum1) + (pessoa.getIdade() * femNumArredondamentoVEFNum2) + (femNumArredondamentoVEFNum3)).replace(",",".")));
                    resVef.setInferior(Double.parseDouble(formatValue.format( resVef.getPrevisto() - femNumArredondamentoVEFinferiorNum1).replace(",",".")));

                    resVef6.setPrevisto( Double.parseDouble(formatValue.format((pessoa.getAltura() * femNumArredondamentoVEF6Num1) + (pessoa.getIdade() * femNumArredondamentoVEF6Num2) + (femNumArredondamentoVEF6Num3)).replace(",",".")));
                    resVef6.setInferior(Double.parseDouble(formatValue.format( resCvf.getPrevisto() - femNumArredondamentoVEF6InferiorNum1).replace(",",".")));

                    //resFef.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER, ( Math.log(pessoa.getAltura()) * femNumArredondamentoFEF2575Num1) + (Math.log(pessoa.getIdade()) * femNumArredondamentoFEF2575Num2 ) - femNumArredondamentoFEF2575Num3)).replace(",",".")));
                    resFef.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(Math.E, (Math.log(pessoa.getAltura()) * femNumArredondamentoFEF2575Num1) - (Math.log(pessoa.getIdade()) * femNumArredondamentoFEF2575Num2) + femNumArredondamentoFEF2575Num3)).replace(",",".")));
                    resFef.setInferior(Double.parseDouble(formatValue.format(resFef.getPrevisto() * femNumArredondamentoFEF2575InferiorNum1).replace(",",".")));

                    resVefCvf.setPrevisto(Double.parseDouble(formatValue.format((pessoa.getAltura() * femNumArredondamentoVEF1CVFNum1) + (pessoa.getIdade() * femNumArredondamentoVEF1CVFNum2) + (femNumArredondamentoVEF1CVFNum3)).replace(",",".")));
                    resVefCvf.setInferior(Double.parseDouble(formatValue.format(resVefCvf.getPrevisto() - femNumArredondamentoVEF1CVFInferiorNum1).replace(",",".")));

                    //resFefCvf.setPrevisto(Double.parseDouble(formatValue.format(Math.pow(NEPER, (Math.log(pessoa.getAltura()) * femNumArredondamentoFEF2575CVFNum1) + (Math.log(pessoa.getIdade()) * femNumArredondamentoFEF2575CVFNum2 ) + femNumArredondamentoFEF2575CVFNum3 )).replace(",",".")));

                    double  vefcvf = Math.pow(Math.E, (Math.log(pessoa.getAltura()) * femNumArredondamentoFEF2575Num1) - (Math.log(pessoa.getIdade()) * femNumArredondamentoFEF2575Num2) + femNumArredondamentoFEF2575Num3);
                    double cvf =   ((pessoa.getAltura() * femNumArredondamentoCVFNum1) + (pessoa.getIdade() * femNumArredondamentoCVFNum2) + (femNumArredondamentoCVFNum3));
                    resFefCvf.setPrevisto(Double.parseDouble(formatValue.format( vefcvf/cvf).replace(",",".")));
                    resFefCvf.setInferior(Double.parseDouble(formatValue.format( resFefCvf.getPrevisto() * femNumArredondamentoFEF2575CVFInferiorNum1).replace(",",".")));

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
