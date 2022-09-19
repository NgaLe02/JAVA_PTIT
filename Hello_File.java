/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LapTrinhJavaCoBan;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell E7440
 */
public class Hello_File {
    public static void main(String[] args) {

        try {
            FileReader reader = new FileReader("Hello.txt");
            int data = reader.read();
            while(data != -1) {
                   System.out.print((char)data);
                   data = reader.read();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
