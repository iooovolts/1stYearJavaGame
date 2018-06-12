/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Steve Odai-Stephens
 */
public class ReadFile {

    /**
     * path is a variable of type String which stores a string
     */
    private String path;

    /**
     * This method reads the file
     * @param file_path the file
     */
    public ReadFile(String file_path) {
        path = file_path;
    }
    
    /**
     * This methods opens the file to be read
     * @return the string textdata
     * @throws IOException runtime error occurred while trying to run file
     */
    public String[] OpenFile() throws IOException {
        
        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader (fr);
        
        int numberOfLines = readLines();
        String[] textData = new String[numberOfLines];
        
        int i;
        for(i=0; i < numberOfLines; i++){
            textData[i] = textReader.readLine();
        }
        textReader.close();
        return textData;
    }
    
    /**
     * This method reads the lines of the text file
     * @return the numberoflines 
     * @throws IOException runtime error occurred while trying to run file
     */
    int readLines() throws IOException{
        FileReader file_to_read = new FileReader(path);
        BufferedReader bf = new BufferedReader(file_to_read);
        
        String aLine;
        int numberOfLines = 0;
        
        while ((aLine = bf.readLine()) != null) {
            numberOfLines++;
        }
        bf.close();
        
        return numberOfLines;
    }
}
