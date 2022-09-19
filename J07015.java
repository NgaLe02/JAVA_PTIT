/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author Dell E7440
 */
public class J07015 {

    public static boolean nt(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return n > 1;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("SONGUYEN.in"));
        ArrayList<Integer> list = (ArrayList<Integer>) in.readObject();
        int[] a = new int[10000];
        for (Integer x : list) {
            if (nt(x)) {
                a[x]++;
            }
        }

        for (int i = 2; i < 10000; i++) {
            if (a[i] > 0) {
                System.out.println(i + " " + a[i]);
            }
        }
    }
}
