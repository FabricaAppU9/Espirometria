/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeunitarioprocalc;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.IOException;

import br.com.uninove.fabricaapp.espirometria.models.Pessoa;
import br.com.uninove.fabricaapp.espirometria.models.Resultado;
import br.com.uninove.fabricaapp.espirometria.models.ResultadoItem;
import br.com.uninove.fabricaapp.espirometria.controllers.Calculo;

import java.util.HashSet;
        

/**
 *
 * @author internet
 */
public class TesteUnitarioProCalc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        String nFile = "arquivo_f.csv";
        
        Integer a;
        String csvFile = "E:\\" + nFile;
        BufferedReader br = null;
        String status= "";
        String line = "";
        String cvsSplitBy = ",";
                      
        File file = new File("e:\\Resultado_"  + nFile );
        
        try {

            if (!file.exists()) {
		file.createNewFile();
            }
            
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
	    BufferedWriter bw = new BufferedWriter(fw);
            
            String content = "";

            Resultado resultado = new Resultado();
            ResultadoItem resultadoitem = new ResultadoItem();
            Calculo calculo = new Calculo();
            Pessoa pessoa = new Pessoa();
            
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                
                if (line != "Sexo,Idade,Estatura,CVF previsto,CVF inferior,CV previsto,CV inferior,vef previsto,fef previsto,vefcvf previsto,vefcvf inferior,fefcvf previsto,vefcvf inferior,pfe") 
                {
                
                    content = "";

                    String[] Coluna = line.split(cvsSplitBy);

                    //System.out.println("Coluna [Sexo=" + Coluna[0] + ",Idade= " + Coluna[1] + ",Estatura=" + Coluna[2] + ",CVF previsto=" + Coluna[3] + ",CVF inferior=" + Coluna[4] + ",CV previsto=" + Coluna[5] + ",CV inferior=" + Coluna[6] + ",vef previsto=" + Coluna[7] + ",fef previsto=" + Coluna[8] + ",vefcvf previsto=" + Coluna[9] + ",vefcvf inferior=" + Coluna[10] + ",fefcvf previsto=" + Coluna[11] + ",vefcvf inferior=" + Coluna[12] + "]");


                    a = Integer.parseInt(Coluna[1]);

                    pessoa.setMassa(0);
                    pessoa.setSexo(Coluna[0].charAt(0));
                    pessoa.setIdade(Integer.valueOf(Coluna[1]));
                    pessoa.setAltura(Double.valueOf(Coluna[2]));

                    resultado = calculo.calcular(pessoa);

                    status = "Correto";

                    resultadoitem = resultado.getCvf();
                    if (Double.parseDouble(Coluna[3]) != resultadoitem.getPrevisto()){status = "Incorreto";} // CVF previsto
                    if (Double.parseDouble(Coluna[4]) != resultadoitem.getInferior()){status = "Incorreto";} //CVF inferior

                    resultadoitem = resultado.getCv();
                    if (Double.parseDouble(Coluna[5]) != resultadoitem.getPrevisto()){status = "Incorreto";} //CV previsto
                    if (Double.parseDouble(Coluna[6]) != resultadoitem.getInferior()){status = "Incorreto";} //CV inferior

                    resultadoitem = resultado.getVef();
                    if (Double.parseDouble(Coluna[7]) != resultadoitem.getPrevisto()){status = "Incorreto";} //vef previsto

                    resultadoitem = resultado.getFef();
                    if (Double.parseDouble(Coluna[8]) != resultadoitem.getPrevisto()){status = "Incorreto";} //fef previsto

                    resultadoitem = resultado.getVefcvf();
                    if (Double.parseDouble(Coluna[9]) != resultadoitem.getPrevisto()){status = "Incorreto";} //vefcvf previsto
                    if (Double.parseDouble(Coluna[10]) != resultadoitem.getInferior()){status = "Incorreto";} //vefcvf inferior

                    resultadoitem = resultado.getFefcvf();
                    if (Double.parseDouble(Coluna[11]) != resultadoitem.getPrevisto()){status = "Incorreto";} //fefcvf previsto
                    if (Double.parseDouble(Coluna[12]) != resultadoitem.getInferior()){status = "Incorreto";} //vefcvf inferior

                    resultadoitem = resultado.getPfe();
                    if (Double.parseDouble(Coluna[13]) != resultadoitem.getPrevisto()){status = "Incorreto";} //pfe

                    System.out.println("Status=" + status + "Sexo=" + Coluna[0] + ",Idade= " + Coluna[1] + ",Estatura=" + Coluna[2] + ",CVF previsto=" + Coluna[3] + ",CVF inferior=" + Coluna[4] + ",CV previsto=" + Coluna[5] + ",CV inferior=" + Coluna[6] + ",vef previsto=" + Coluna[7] + ",fef previsto=" + Coluna[8] + ",vefcvf previsto=" + Coluna[9] + ",vefcvf inferior=" + Coluna[10] + ",fefcvf previsto=" + Coluna[11] + ",vefcvf inferior=" + Coluna[12] + ",pef=" + Coluna[13] + "");
                    //content = status + "," + Coluna[0] + "," + Coluna[1] + "," + Coluna[2] + "," + Coluna[3] + "," + Coluna[4] + "," + Coluna[5] + "," + Coluna[6] + "," + Coluna[7] + "," + Coluna[8] + "," + Coluna[9] + "," + Coluna[10] + "," + Coluna[11] + "," + Coluna[12] + "," + Coluna[13] + "";
                    content = "Teste 01";
                    bw.write(content);
                    bw.newLine();
                
                }
                
            }
            
            bw.close();
            }
        
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        
    }
    
}
