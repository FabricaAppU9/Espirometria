package br.com.uninovefabricaapp.espirometria.controllers;

import br.com.uninove.fabricaapp.espirometria.models.*;

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
    
            
    static double[][] variaveis = new double[7][2];
    
    ///Arredondamento para cima do valor // duas casas decimais
    public double arredondar(double num,int casasDecimais){
        double result = Math.ceil(num);
        return result;
    }
    
    public Resultado calcular(Pessoa pessoa){
        Resultado res = new Resultado();
        switch(pessoa.getSexo()){
            case 'm':
                if(pessoa.getIdade() < 14){
                    //CVF Previsto
                    variaveis[1][0] = arredondar(Math.pow(NEPER, Math.log(pessoa.getAltura()) * numArredondamentoCVFPrevisto - numSubtracaoCVFPrevisto),2);
                    //CVF Inferior
                    variaveis[1][1] = arredondar(variaveis[1][0] * numArredondamentoCVFInferior , 2);
                    
                    //CV Previsto
                    variaveis[0][0] = variaveis[1][0];
                    //CV Inferior
                    variaveis[0][1] = variaveis[1][1];
                    
                    //vef Previsto
                    variaveis[2][0] = arredondar(Math.pow(NEPER, Math.log(pessoa.getAltura()) * numArredondamentoVefPrevisto - numSubtracaoVefPrevisto),2);
                    //vef Inferior
                    variaveis[2][1] = arredondar(variaveis[2][0] * numArredondamentoVefInferior,2);
                    
                    //fef Previsto 
                    variaveis[3][0] = arredondar(Math.pow(NEPER, Math.log(pessoa.getAltura()) * numArredondamentoFefPrevisto - numSubtracaoFefPrevisto),2);
                    //fef Inferior
                    variaveis[3][1] = arredondar(variaveis[3][0] * numArredondamentoFefInferior,2);
                    
                    //vefcvf Previsto
                    variaveis[4][0] = vefcvfPrevisto;
                    //vefcvf Inferior
                    variaveis[4][1] = vefcvInferior;
                    
                    //feefcvf Previsto
                    variaveis[5][0] = feefcvfPrevisto;
                    //feefcvf Inferior
                    variaveis[5][1] = feefcvfInferior;
                    
                
                    
                }else if(pessoa.getIdade()<24){
                    
                    //CVF Previsto
                    variaveis[1][0] = arredondar(Math.pow(NEPER, Math.log(pessoa.getAltura()) * 1.31 + Math.log(pessoa.getIdade()) * 0.317 + Math.log(pessoa.getMassa()) * 0.3529 -76487),2);
                    //CVF Inferior
                    variaveis[1][1] = arredondar(variaveis[1][0] * numArredondamentoCVFInferior241,2);
                    
                    //CV Previsto
                    variaveis[0][0] = variaveis[1][0];
                    //CV Inferior
                    variaveis[0][1] = variaveis[1][1];
                    
                    //vef Previsto
                    variaveis[2][0] = arredondar(Math.pow(NEPER, Math.log(pessoa.getAltura()) * numArredondamentoVEFPrevisto241 + Math.log(pessoa.getIdade()) * numArredondamentoVEFPrevisto242 + Math.log(pessoa.getMassa()) * numArredondamentoVEFPrevisto243 - numSubtracaoVEFPrevisto241),2);
                    //vef Inferior
                    variaveis[2][1] = arredondar(variaveis[2][0] * numArredondamentoVEFInferior241,2);
                    
                    //fef Previsto
                    variaveis[3][0] = arredondar(arredondar(Math.pow(NEPER, Math.log(pessoa.getAltura()) * numArredondamentoFEFPrevisto241 + Math.log(pessoa.getMassa()) * numArredondamentoFEFPrevisto242 - numSubtracaoFEFPrevisto241),2), 2);
                    //fef Inferior
                    variaveis[3][1]  = arredondar(variaveis[3][0] * numArredondamentoFEFInferior241, 2);
                    
                    //vefcvf Previsto
                    variaveis[4][0] = numVEFCVFPrevisto241;
                    //vefcvf Inferior
                    variaveis[4][1] = numVEFCVFInferior241;
                    
                    //fefcvf Previsto
                    variaveis[5][0] = numVEFCVFPrevisto241;
                    //fefcvf Inferior
                    variaveis[5][1] = numVEFCVFInferior241;
                    
                   
                    
                    
                }else if(pessoa.getIdade() > 24){
                    
                    //cvf Previsto
                    variaveis[1][0] = arredondar(pessoa.getAltura() * numArredondarCVFInferiorMaior241 - pessoa.getIdade() * numArredondarCVFPrevistoMaior242 , 2);
                    //cvf Inferior
                    variaveis[1][1] = arredondar(variaveis[1][0] - numSubtracaoCVFInferiorMaior241, 2);
                    
                    //cv Previsto
                    variaveis[0][0] = variaveis[1][0];
                    //cv Inferior
                    variaveis[0][1] = variaveis[1][1];
                    
                    //vef Previsto
                    variaveis[2][0] = arredondar(pessoa.getAltura() * numArredondarVEFPrevistoMaior241 - pessoa.getIdade() * numArredondarCVFPrevistoMaior242 - numSubtracaoVEFPrevistoMaior241, 2);
                    //vef Inferior
                    variaveis[2][1] = arredondar(variaveis[2][0] - numSubtracaoVEFInferiorMaior241, 2);
                    
                    //fef Previsto
                    variaveis[3][0] = arredondar(Math.pow(NEPER, Math.log(pessoa.getAltura()) * numArredondarFEFPrevistoMaior241 - Math.log(pessoa.getIdade()) * numArredondarFEFPrevistoMaior242 - numSubtracaoFEFPrevistoMaior241),2);
                    //fef Inferior
                    variaveis[3][1] = arredondar(variaveis[3][0] * numArredondarFEFInferiorMaior241,2);
                    
                    //vefcvf Previsto
                    variaveis[4][0] = arredondar(Math.pow(NEPER, numArredondarVEFCFVPrevistoMaior241 - Math.log(pessoa.getIdade()) * numArredondarVEFCFVPrevistoMaior242), 0);
                    //vefcvf Inferior
                    variaveis[4][1] = arredondar(variaveis[4][0] * numArredondarVEFCFVInferiorMaior241, 0);
                    
                    //fefcvf Previsto
                    variaveis[5][0] = arredondar(Math.pow(NEPER,numArredondarFEFCVFPrevistoMaior241 - Math.log(pessoa.getIdade()) * numArredondarFEFCVFPrevistoMaior242), 0);
                    //fefcvf Inferior
                    variaveis[5][1] = arredondar(variaveis[5][0] * numArredondarFEFCVFInferiorMaior241, 0);
                }
                
                break;
                
            case 'f':
                if(pessoa.getIdade() < 14){
                    
                }
                break;
        }
        return res;
    }
    
}
