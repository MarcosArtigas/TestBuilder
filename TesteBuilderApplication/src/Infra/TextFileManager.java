/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Infra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 *
 * @author Murilo
 */
public class TextFileManager {
    private File _file;
    public TextFileManager(String nomeArquivo) throws URISyntaxException, IOException
    {
        _file = new File(nomeArquivo + ".txt");
        
        if(!_file.exists())
            _file.createNewFile();
        
    }
    
    public ArrayList<String> LerArquivo() throws Exception {
        ArrayList<String> linhas = new ArrayList<String>();

        FileReader fileReader = new FileReader(_file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String linha = "";

        while ((linha = bufferedReader.readLine()) != null) {
            linhas.add(linha);
        }

        fileReader.close();
        bufferedReader.close();


        return linhas;
    }
    
    public void EscreverNoArquivo(String texto) throws IOException
    {
        FileWriter fw = new FileWriter(_file,false);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(texto);
        
        bw.close();
        fw.close();
                
                
    }
    
    public void AdicionarLinhasAoArquivo(String linha) throws IOException
    {
        FileWriter fw = new FileWriter(_file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("\n"+linha);
        
         bw.close();
        fw.close();
    }
}
