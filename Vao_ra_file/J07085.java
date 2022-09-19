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
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author Dell E7440
 */
public class J07085 {

    public static String solve(String s) {
        String t = "";
        int tong = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                t += s.charAt(i);
                tong += (s.charAt(i) - '0');
            }
        }
        t = new BigInteger(t) + "";
        return (t + " " + tong);
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//        ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATA.in"));
//        ArrayList<String> a = (ArrayList<String>) in.readObject();
        ArrayList<String> a = new ArrayList<>();
        a.add("Jhsf00dklT12uhf780LPPZH");
        a.add("AAAAddd0000000000000000001T");
        a.add("00sgsgs000s0sdgs000sg");
        for (String x : a) {
            if (!solve(x).equals("0 0")) {
                System.out.println(solve(x));
            }
        }
    }
}
