/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VaoRaFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class TongChuSo {
    public static String solve(String x){
        String t = "";
        int tong = 0;
        for(int i = 0; i < x.length(); i++){
            if(Character.isDigit(x.charAt(i))){
                t += String.valueOf(x.charAt(i));
                tong += x.charAt(i) - '0';
            }
        }
        BigInteger s = new BigInteger(t);
        return s + " " + tong;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> a = (ArrayList<String>) in.readObject();
        for(String x : a){
            System.out.println(solve(x));
        }
    }
}
