/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Dell E7440
 */
public class J07005 {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        File file = new File("DATA.IN");
        FileInputStream fileInputStream = new FileInputStream(file);

        DataInputStream dataInputStream = new DataInputStream(fileInputStream);

        int[] a = new int[1000];

        for (int i = 0; i < 100000; i++) {
            a[dataInputStream.readInt()]++;
        }

        for (int i = 0; i < 1000; i++) {
            if (a[i] > 0) {
                System.out.println(i + " " + a[i]);
            }
        }
    }
}
