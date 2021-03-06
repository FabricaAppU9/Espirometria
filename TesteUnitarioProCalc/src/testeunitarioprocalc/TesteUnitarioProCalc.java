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
import java.text.DecimalFormat;

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
        
        
        
        String nFile = "dados_m.csv";
        Double getCvf_Previsto, getCvf_Inferior, getCv_Previsto, getCv_Inferior, getVef_Previsto, getFef_Previsto,getVef_Inferior,getFef_Inferior;
        Double getVefcvf_Previsto, getVefcvf_Inferior, getFefcvf_Previsto, getFefcvf_Inferior;
        
        Integer a;
        Double b;
        String csvFile = "E:\\" + nFile;
        BufferedReader br = null;
        String status= "";
        String line = "";
        String cvsSplitBy = ";";
                      
        File file = new File("e:\\Resultado_"  + nFile );
        
        try {

            if (!file.exists()) {
		file.createNewFile();
            }
            
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
	    BufferedWriter bw = new BufferedWriter(fw);
            
            String content = "";

            Resultado resultado;
            ResultadoItem resultadoitem ;
            Calculo calculo = new Calculo();
            Pessoa pessoa = new Pessoa();
            
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                
                if (!line.equals("Sexo,Idade,Estatura,CVF previsto,CVF inferior,CV previsto,CV inferior,vef previsto,fef previsto,vefcvf previsto,vefcvf inferior,fefcvf previsto,vefcvf inferior,pfe")) {
                
                    content = "";

                    String[] Coluna = line.split(cvsSplitBy);


                    /*COMENTARIO BY JUNIOR AND LEO - ESSE SYSTEM É USADO0 PARA DEBUGAR O QUE A COLUNA ESTA LENDO, SUA REMOÇÃO NAO ALTERA A LOGICA DO PROGRAMA*/

                    System.out.println(
                            ",Idade= " + Coluna[0] 
                            + ",Estatura=" + Coluna[1] 
                            + ",CVF previsto=" + Coluna[2] 
                            + ",CVF inferior=" + Coluna[3] 
                            + ",CV previsto=" + Coluna[4] 
                            + ",CV inferior=" + Coluna[5] 
                            + ",vef previsto=" + Coluna[6] 
                            + ",vef inferior=" + Coluna[7]
                            + ",fef previsto=" + Coluna[8] 
                            + ",fef inferior=" + Coluna[9]
                            + ",vefcvf previsto=" + Coluna[10] 
                            + ",vefcvf inferior=" + Coluna[11] 
                            + ",fefcvf previsto=" + Coluna[12] 
                            + ",vefcvf inferior=" + Coluna[13] 
                            + ", pef" + Coluna[14]
                            + "]");

                    pessoa.setMassa(0);
                    pessoa.setSexo('m');
                    pessoa.setIdade(Integer.valueOf(Coluna[0]));
                    pessoa.setAltura(Integer.valueOf(Coluna[1]));

                    resultado = calculo.calcular(pessoa);

                    status = "Correto";
                    
                    getCvf_Previsto = 0.0;
                    getCvf_Inferior = 0.0;
                    getCv_Previsto = 0.0;
                    getCv_Inferior = 0.0;
                    getVef_Previsto = 0.0;
                    getVef_Inferior = 0.0;
                    getFef_Previsto = 0.0;
                    getFef_Inferior = 0.0;
                    getVefcvf_Previsto = 0.0;
                    getVefcvf_Inferior = 0.0;
                    getFefcvf_Previsto = 0.0;
                    getFefcvf_Inferior = 0.0;
                    
                    resultadoitem = resultado.getCvf();
                    
                    getCvf_Previsto = resultadoitem.getPrevisto();
                    getCvf_Inferior = resultadoitem.getInferior();
                    
                    if (Double.parseDouble(Coluna[2]) != resultadoitem.getPrevisto()){
                        status = "Incorreto";
                    } // CVF previsto
                    if (Double.parseDouble(Coluna[3]) != resultadoitem.getInferior()){
                        status = "Incorreto";
                    } //CVF inferior

                    
                    resultadoitem = resultado.getCv();
                    
                    getCv_Previsto = resultadoitem.getPrevisto();
                    getCv_Inferior = resultadoitem.getInferior();
                            
                    if (Double.parseDouble(Coluna[4]) != resultadoitem.getPrevisto()){
                        status = "Incorreto";
                    } //CV previsto
                    if (Double.parseDouble(Coluna[5]) != resultadoitem.getInferior()){
                        status = "Incorreto";
                    } //CV inferior

                    
                    resultadoitem = resultado.getVef();
                    
                    getVef_Previsto = resultadoitem.getPrevisto();
                    getVef_Inferior = resultadoitem.getInferior();
                            
                    if (Double.parseDouble(Coluna[6]) != resultadoitem.getPrevisto()){
                        status = "Incorreto";
                    } //vef previsto
                    if (Double.parseDouble(Coluna[7]) != resultadoitem.getInferior()){
                        status = "Incorreto";
                    } //vef inferior

                    
                    resultadoitem = resultado.getFef();
                    
                    getFef_Previsto = resultadoitem.getPrevisto();
                    getFef_Inferior = resultadoitem.getInferior();
                    
                    if (Double.parseDouble(Coluna[8]) != resultadoitem.getPrevisto()){
                        status = "Incorreto";
                    } //fef previsto
                    if (Double.parseDouble(Coluna[9]) != resultadoitem.getInferior()){
                        status = "Incorreto";
                    } //fef inferior

                    
                    resultadoitem = resultado.getVefcvf();
                    
                    getVefcvf_Previsto = resultadoitem.getPrevisto();
                    getVefcvf_Inferior = resultadoitem.getInferior();
                    
                    if (Double.parseDouble(Coluna[10]) !=  resultadoitem.getPrevisto()){
                        status = "Incorreto";
                    } //vefcvf previsto
                    if (Double.parseDouble(Coluna[11]) != resultadoitem.getInferior()){
                        status = "Incorreto";
                    } //vefcvf inferior

                    
                    resultadoitem = resultado.getFefcvf();
                    
                    getFefcvf_Previsto = resultadoitem.getPrevisto();
                    getFefcvf_Inferior = resultadoitem.getInferior();
                    
                    if (Double.parseDouble(Coluna[12]) != resultadoitem.getPrevisto()){
                        status = "Incorreto";
                    } //fefcvf previsto
                    if (Double.parseDouble(Coluna[13]) != resultadoitem.getInferior()){
                        status = "Incorreto";
                    } //vefcvf inferior

//                    resultadoitem = resultado.getPfe();
//                  if (Double.parseDouble(Coluna[14]) != resultadoitem.getPrevisto()){status = "Incorreto";} //pfe

    
                    System.out.printf("\n Status= " + status + ","
                                     + "\n Idade= " + Coluna[0] + ","
                                     + "\n Estatura= " + Coluna[1] + ","
                                     + "\n CVF previsto= " + Coluna[2] + " | " + getCvf_Previsto 
                                     + "\n CVF inferior= " + Coluna[3] + " | " + getCvf_Inferior
                                     + "\n CV previsto= " + Coluna[4] + " | " + getCv_Previsto
                                     + "\n CV inferior= " + Coluna[5] + " | " + getCv_Inferior
                                     + "\n vef previsto= " + Coluna[6] + " | " + getVef_Previsto
                                     + "\n vef inferior= " + Coluna[7] + " | " +getVef_Inferior
                                     + "\n fef previsto= " + Coluna[8] + " | " + getFef_Previsto
                                     + "\n fef inferior= " + Coluna[9] + " | " +  getFef_Inferior
                                     + "\n vefcvf previsto= " + Coluna[10] + " | " + Math.round(getVefcvf_Previsto) 
                                     + "\n vefcvf inferior= " + Coluna[11] + " | " + Math.round(getVefcvf_Inferior)
                                     + "\n fefcvf previsto= " + Coluna[12] + " | " + Math.round(getFefcvf_Previsto) 
                                     + "\n vefcvf inferior= " + Coluna[13] + " | " + Math.round(getFefcvf_Inferior) 
                                     + "\n pef= " + Coluna[14] + "");
                    //System.out.println("Status=" + status + ",Sexo=" + Coluna[0] + ",Idade= " + Coluna[1] + ",Estatura=" + Coluna[2] + ",CVF previsto=" + Coluna[3] + ",CVF inferior=" + Coluna[4] + ",CV previsto=" + Coluna[5] + ",CV inferior=" + Coluna[6] + ",vef previsto=" + Coluna[7] + ",fef previsto=" + Coluna[8] + ",vefcvf previsto=" + Coluna[9] + ",vefcvf inferior=" + Coluna[10] + ",fefcvf previsto=" + Coluna[11] + ",vefcvf inferior=" + Coluna[12] + ",pef=" + Coluna[13] + "");
                    
                    //content = status + "," + Coluna[0] + "," + Coluna[1] + "," + Coluna[2] + "," + Coluna[3] + "," + Coluna[4] + "," + Coluna[5] + "," + Coluna[6] + "," + Coluna[7] + "," + Coluna[8] + "," + Coluna[9] + "," + Coluna[10] + "," + Coluna[11] + "," + Coluna[12] + "," + Coluna[13] + "";
                    content = "Teste 01";
                    bw.write(content);
                    bw.newLine();

                    
                    if(!status.equals("Incorreto")){
                        
                        String dados =  "\n Status= " + status + ","
                                         + "\n Sexo= " + Coluna[0] + ","
                                         + "\n Idade= " + Coluna[1] + ","
                                         + "\n Estatura= " + Coluna[2] + ","
                                         + "\n CVF previsto= " + Coluna[3] + " | " + getCvf_Previsto + ","
                                         + "\n CVF inferior= " + Coluna[4] + " | " + getCvf_Inferior + ","
                                         + "\n CV previsto= " + Coluna[5] + " | " + getCv_Previsto + ","
                                         + "\n CV inferior= " + Coluna[6] + " | " + getCv_Inferior + ","
                                         + "\n vef previsto= " + Coluna[7] + " | " + getVef_Previsto + ","
                                         + "\n vef inferior= " + Coluna[8] + " | " + getVef_Inferior + ","
                                         + "\n fef previsto= " + Coluna[9] + " | " + getFef_Previsto + ","
                                         + "\n vefcvf previsto= " + Coluna[10] + " | " + getVefcvf_Previsto + ","
                                         + "\n vefcvf inferior= " + Coluna[11] + " | " + getVefcvf_Inferior + ","
                                         + "\n fefcvf previsto= " + Coluna[12] + " | " + getFefcvf_Previsto + ","
                                         + "\n vefcvf inferior= " + Coluna[13] + " | " + getFefcvf_Inferior + ","
                                         + "\n pef= " + Coluna[14] + "";
                        //System.out.println("Status=" + status + ",Sexo=" + Coluna[0] + ",Idade= " + Coluna[1] + ",Estatura=" + Coluna[2] + ",CVF previsto=" + Coluna[3] + ",CVF inferior=" + Coluna[4] + ",CV previsto=" + Coluna[5] + ",CV inferior=" + Coluna[6] + ",vef previsto=" + Coluna[7] + ",fef previsto=" + Coluna[8] + ",vefcvf previsto=" + Coluna[9] + ",vefcvf inferior=" + Coluna[10] + ",fefcvf previsto=" + Coluna[11] + ",vefcvf inferior=" + Coluna[12] + ",pef=" + Coluna[13] + "");

                        //content = status + "," + Coluna[0] + "," + Coluna[1] + "," + Coluna[2] + "," + Coluna[3] + "," + Coluna[4] + "," + Coluna[5] + "," + Coluna[6] + "," + Coluna[7] + "," + Coluna[8] + "," + Coluna[9] + "," + Coluna[10] + "," + Coluna[11] + "," + Coluna[12] + "," + Coluna[13] + "";
                        content = dados;
                        bw.write(content);
                        bw.newLine();
                    }

                
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
