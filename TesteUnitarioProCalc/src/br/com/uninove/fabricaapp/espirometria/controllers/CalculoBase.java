
package br.com.uninove.fabricaapp.espirometria.controllers;

import br.com.uninove.fabricaapp.espirometria.models.*;
import br.com.uninove.fabricaapp.espirometria.models.*;

/**
*
*@author Bianca Guilherme
*
**/
public class CalculoBase {
    static double[][] variaveis = new double[7][2];
    
    static final double NEPER = 2.7183;

	public static double arredondar (double valor, int casas){

        return (int)(Math.pow(valor*10, casas+0.5))/Math.pow(10, casas);
    }

    public Resultado calcular(Pessoa pessoa){
    	Resultado res = new Resultado();
    	switch(pessoa.getSexo()){
    		case 'm':

    			if(pessoa.getIdade()< 14){
    				// CVF previsto
    				variaveis[1][0] = arredondar(Math.pow(NEPER, Math.log(pessoa.getAltura()) * 2.709 - 12.6205), 2);
    				// CVF inferior
    				variaveis[1][1] = arredondar(variaveis[1][0] * 0.79, 2);


    				//CV previsto
    				variaveis[0][0] = variaveis[1][0];
    				//CV inferior
    				variaveis[0][1] = variaveis[1][1];

    				//vef previsto
    				variaveis[2][0] = arredondar(Math.pow(NEPER, Math.log(pessoa.getAltura()) * 2.5431 - 11.8832),2);
    				//vef inferior
    				variaveis[2][1] = arredondar(variaveis[2][0] * 0.8, 2);


    				//fef previsto
    				variaveis[3][0] = arredondar(Math.pow(NEPER, Math.log(pessoa.getAltura()) * 1.8309 - 8.5219), 2);
    				//fef inferior
    				variaveis[3][1] = arredondar(variaveis[3][0] * 0.78, 2);

    				//vefcvf previsto
    				variaveis[4][0] = 93;
    				//vefcvf inferior
    				variaveis[4][1] = 83;

    				//fefcvf previsto
    				variaveis[5][0] = 118;
    				//vefcvf inferior
    				variaveis[5][1] = 91;



    			} else if(pessoa.getIdade() < 24){

    				// CVF previsto
    				variaveis[1][0] = arredondar(Math.pow(NEPER, Math.log(pessoa.getAltura()) * 1.31 + Math.log(pessoa.getIdade()) * 0.317 + Math.log(pessoa.getMassa()) * 0.3529 - 7.6487), 2);
    				// CVF inferior
    				variaveis[1][1] = arredondar(variaveis[1][0] * 0.81, 2);


    				//CV previsto
    				variaveis[0][0] = variaveis[1][0];
    				//CV inferior
    				variaveis[0][1] = variaveis[1][1];

    				//vef previsto
    				variaveis[2][0] = arredondar(Math.pow(NEPER, Math.log(pessoa.getAltura()) * 1.2158 + Math.log(pessoa.getIdade()) * 0.19 + Math.log(pessoa.getMassa()) * 0.3077 - 6.683),2);
    				//vef inferior
    				variaveis[2][1] = arredondar(variaveis[2][0] * 0.82, 2);


    				//fef previsto
    				variaveis[3][0] = arredondar(arredondar(Math.pow(NEPER, Math.log(pessoa.getAltura()) * 0.7513 + Math.log(pessoa.getMassa()) * 0.3303 - 3.653), 2), 2);
    				//fef inferior
    				variaveis[3][1] = arredondar(variaveis[3][0] * 0.68, 2);

    				//vefcvf previsto
    				variaveis[4][0] = 94;
    				//vefcvf inferior
    				variaveis[4][1] = 82;

    				//fefcvf previsto
    				variaveis[5][0] = 94;
    				//vefcvf inferior
    				variaveis[5][1] = 82;

    			} else if(pessoa.getIdade() >= 24){
    				// CVF previsto
    				variaveis[1][0] = arredondar(pessoa.getAltura() * 0.059 - pessoa.getIdade() * 0.0229 - 4.569, 2);
    				// CVF inferior
    				variaveis[1][1] = arredondar(variaveis[1][0] * 0.864, 2);


    				//CV previsto
    				variaveis[0][0] = variaveis[1][0];
    				//CV inferior
    				variaveis[0][1] = variaveis[1][1];

    				//vef previsto
    				variaveis[2][0] = arredondar(pessoa.getAltura() * 0.0473 - pessoa.getIdade() * 0.0281 - 3.145,2);
    				//vef inferior
    				variaveis[2][1] = arredondar(variaveis[2][0] * 0.79, 2);


    				//fef previsto
    				variaveis[3][0] = arredondar(Math.pow(NEPER, Math.log(pessoa.getAltura()) * 2.002 - Math.log(pessoa.getIdade()) * 0.6977 - 6.3279), 2);
    				//fef inferior
    				variaveis[3][1] = arredondar(variaveis[3][0] * 0.6, 2);

    				//vefcvf previsto
    				variaveis[4][0] = arredondar(Math.pow(NEPER, 4.854 - Math.log(pessoa.getIdade()) * 0.1198), 0);
    				//vefcvf inferior
    				variaveis[4][1] = arredondar(variaveis[4][0] * 0.9, 0);

    				//fefcvf previsto
    				variaveis[5][0] = arredondar(Math.pow(NEPER, 6.1205 - Math.log(pessoa.getIdade()) * 0.4407), 0);
    				//vefcvf inferior
    				variaveis[5][1] = arredondar(variaveis[5][0] * 0.6, 0);
    			}
    		break;

    		case 'f':

    			if(pessoa.getIdade() < 14){
					//CVF previsto
					variaveis[1][0] = arredondar(pessoa.getAltura() * 0.02417 + pessoa.getIdade() * 0.0561 + pessoa.getMassa() * 0.01 - 2.2197, 2);
					//CVF inferior
					variaveis[1][1] = arredondar(variaveis[1][0] * 0.477, 2);

					//CV previsto
					variaveis[0][0] = variaveis[1][0];
					//CV inferior
					variaveis[0][1] = variaveis[1][1];

					//vef previsto
					variaveis[2][0] = arredondar(pessoa.getAltura() * 0.02336 + pessoa.getIdade() * 0.0499 + pessoa.getMassa() * 0.008 - 2.124, 2);
					//vef inferior
					variaveis[2][1] = arredondar(variaveis[2][0] * 0.429, 2);

					//fef previsto
					variaveis[3][0] = arredondar(Math.pow(NEPER, Math.log(pessoa.getAltura()) * 2.0561 + Math.log(pessoa.getIdade()) * 0.2791 - 9.9287), 2);
					//fef inferior
					variaveis[3][1] = arredondar(variaveis[3][0] * 0.74, 2);

					//vefcvf previsto
					variaveis[4][0] = 93;
					//vefcvf inferior
					variaveis[4][1] = 81;

					//fefcvf previsto
					variaveis[5][0] = 120;
					//vefcvf inferior
					variaveis[5][1] = 90;


    			} else if(pessoa.getIdade() <= 19){
					//CVF previsto
					variaveis[1][0] = arredondar(Math.pow(NEPER, Math.log(pessoa.getAltura()) * 1.7374 + Math.log(pessoa.getIdade()) * 0.2823 + Math.log(pessoa.getMassa()) * 0.1491 - 9.0562), 2);
					//CVF inferior
					variaveis[1][1] = arredondar(variaveis[1][0] * 0.87, 2);

					//CV previsto
					variaveis[0][0] = variaveis[1][0];
					//CV inferior
					variaveis[0][1] = variaveis[1][1];

					//vef previsto
					variaveis[2][0] = arredondar(Math.pow(NEPER, Math.log(pessoa.getAltura()) * 1.9293 + Math.log(pessoa.getIdade()) * 0.2255 + Math.log(pessoa.getMassa()) * 0.1105 - 9.81), 2);
					//vef inferior
					variaveis[2][1] = arredondar(variaveis[2][0] * 0.87, 2);

					//fef previsto
					variaveis[3][0] = arredondar(Math.pow(NEPER, Math.log(pessoa.getAltura()) * 2.0561 + Math.log(pessoa.getIdade()) * 0.2791 - 9.9287), 2);
					//fef inferior
					variaveis[3][1] = arredondar(variaveis[3][0] * 0.91, 2);

					//vefcvf previsto
					variaveis[4][0] = 97;
					//vefcvf inferior
					variaveis[4][1] = 88;

					//fefcvf previsto
					variaveis[5][0] = 124;
					//vefcvf inferior
					variaveis[5][1] = 100;


    			} else if(pessoa.getIdade() > 19){
					//CVF previsto
					variaveis[1][0] = arredondar(pessoa.getAltura() * 0.0433 - pessoa.getIdade() * 0.0164 - 2.967, 2);
					//CVF inferior
					variaveis[1][1] = arredondar(variaveis[1][0] * 0.556, 2);

					//CV previsto
					variaveis[0][0] = variaveis[1][0];
					//CV inferior
					variaveis[0][1] = variaveis[1][1];

					//vef previsto
					variaveis[2][0] = arredondar(pessoa.getAltura() * 0.0338 + pessoa.getIdade() * 0.021 - 1.782, 2);
					//vef inferior
					variaveis[2][1] = arredondar(variaveis[2][0] * 0.433, 2);

					//fef previsto
					variaveis[3][0] = arredondar(Math.pow(NEPER, Math.log(pessoa.getAltura()) * 1.2843 + Math.log(pessoa.getIdade()) * 0.6546 - 3.0208), 2);
					//fef inferior
					variaveis[3][1] = arredondar(variaveis[3][0] * 0.6, 2);

					//vefcvf previsto
					variaveis[4][0] = arredondar(Math.pow(NEPER, 4.8707 - Math.log(pessoa.getIdade()) * 0.1212),0);
					//vefcvf inferior
					variaveis[4][1] = arredondar(variaveis[4][0] * 0.9,0);

					//fefcvf previsto
					variaveis[5][0] = arredondar(Math.pow(NEPER, 4.8707 - Math.log(pessoa.getIdade()) * 0.4237),0);
					//vefcvf inferior
					variaveis[5][1] = arredondar(variaveis[5][0] * 0.6,0);
    			}
    		break;
    		default:
    			//sexo não reconhecido.
        }
        return res;
     }
 
    
}
