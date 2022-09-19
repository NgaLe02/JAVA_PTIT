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
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

/**
 *
 * @author Dell E7440
 */
public class J07079 {

    public static String tach(String s) {
        String t = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' || s.charAt(i) == '1') {
                t += s.charAt(i);
            }
        }
        return t;
    }

    public static long caculate(String s) {
        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ans += (long) Math.pow(2, s.length() - i - 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> a = (ArrayList<String>) in.readObject();
        for (String x : a) {
            if (!tach(x).equals("")) {
                System.out.println(tach(x) + " " + caculate(tach(x)));
            }
        }
    }
}
