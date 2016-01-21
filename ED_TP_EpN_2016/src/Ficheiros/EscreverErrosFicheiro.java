
package Ficheiros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;


public class EscreverErrosFicheiro {
    /**
     * Metodo responsavel por escrever os erros no ficheiro
     * @param e
     * @throws IOException 
     */
    public void escreverEmficheiro(Exception e,String classe) throws IOException{
       
        
        File ficheiro = new File("./erros.txt");
        
            BufferedWriter bw = new BufferedWriter(new FileWriter(ficheiro, true));
            if (ficheiro.canWrite()) {
                FileReader fr = new FileReader(ficheiro);
                BufferedReader br = new BufferedReader(fr);
            
                
                //calcular data e hora;
                Calendar c = Calendar.getInstance();
              
                bw.write(c.getTime()+" Erro: " + e +"  Classe: "+ classe);
                bw.newLine();
               
            }
            bw.flush();
            bw.close();
            
         
     
        
    }
}
