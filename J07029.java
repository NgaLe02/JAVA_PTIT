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

/**
 *
 * @author Dell E7440
 */
public class J07029 {

    public static boolean nt(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<Integer> a = (ArrayList<Integer>) in.readObject();
        int[] b = new int[1000001];
        for (Integer x : a) {
            if (nt(x)) {
                b[x]++;
            }
        }
        int cnt = 0;
        for (int i = 1000000; i >= 0; i--) {
            if (b[i] > 0) {
                System.out.println(i + " " + b[i]);
                cnt++;
            }
            if (cnt == 10) {
                break;
            }
        }
    }
}
