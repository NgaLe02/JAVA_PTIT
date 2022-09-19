/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 *
 * @author Dell E7440
 */
public class J07030 {

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
        ObjectInput in = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ArrayList<Integer> a = (ArrayList<Integer>) in.readObject();

        TreeSet<Integer> se1 = new TreeSet<>();
        for (Integer x : a) {
            if (x < 500000 && nt(x)) {
                se1.add(x);
            }
        }

        in = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> b = (ArrayList<Integer>) in.readObject();
        for (Integer x : se1) {
            if (b.contains(1000000 - x) && nt(1000000 - x)) {
                System.out.println(x + " " + (1000000 - x));
            }
        }
    }
}
