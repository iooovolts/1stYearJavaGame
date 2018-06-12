/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * @author Steve Odai-Stephens
 */
public class WriteFile {

    /**
     * path is a variable of type String which stores a string
     */
    private String path;

    /**
     *
     */
    private boolean append_to_file = false;

    /**
     * sets the path variable to the current instance
     * @param file_path the file
     */
    public WriteFile(String file_path) {
        path = file_path;

    }

    /**
     * This methods writes to the file
     * @param file_path the file
     * @param append_value boolean value
     */
    public WriteFile(String file_path, boolean append_value) {
        path = file_path;
        append_to_file = append_value;
    }

    /**
     *
     * @param textLine
     * @throws IOException runtime error occurred while trying to run file
     */
    public void writeToFile(String textLine) throws IOException {
        FileWriter write = new FileWriter(path, append_to_file);

        PrintWriter print_line = new PrintWriter(write);

        print_line.printf("%s" + "%n", textLine);
        print_line.close();
    }
}
