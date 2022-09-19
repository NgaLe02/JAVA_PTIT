/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J07006 {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<Integer> a = (ArrayList<Integer>) in.readObject();

        int[] b = new int[1001];
        for (Integer x : a) {
            b[x]++;
        }

        for(int i = 0; i < 1001; i++){
            if(b[i] > 0){
                System.out.println(i + " " + b[i]);
            }
        }
    }
}
