/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.IOException;

/**
 *
 * @author Steve Odai-Stephens
 */
public class FileData {

    /**
     *
     * @param args unused
     * @throws IOException runtime error occurred while trying to run file
     */
    public static void main(String[] args) throws IOException {

        String file_name = "sample.txt";

        try {
            ReadFile file = new ReadFile(file_name);
            String[] aryLines = file.OpenFile();
            
            int i;
            for (i=0; i < aryLines.length; i++){
                System.out.println(aryLines[i]);
            }
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
