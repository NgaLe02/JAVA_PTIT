/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J07072 implements Comparable<J07072>{
    private String ten, ho, tenDem, hoTen;

    public J07072(String s) {
        this.hoTen = s;
        String[] t = s.split("\\s+");
        this.ten = t[t.length - 1];
        this.ho = t[0];
        String tmp = "";
        for(int i = 1; i < t.length - 1; i++) {
            tmp = tmp + t[i] + " ";
        }
        this.tenDem = tmp.trim();
    }

    @Override
    public int compareTo(J07072 t) {
        if(t.ten.compareTo(ten) != 0){
            return ten.compareTo(t.ten);
        }
        if(t.ho.compareTo(ho) != 0) {
            return ho.compareTo(t.ho);
        }
        return tenDem.compareTo(t.tenDem);
    }

    @Override
    public String toString() {
        return hoTen;
    }
    
    
    
    public static String chuanHoa(String s) {
        s = s.trim().toLowerCase();
        String[] words = s.split("\\s+");
        s = "";
        for (String x : words) {
            s += String.valueOf(x.charAt(0)).toUpperCase() + x.substring(1);
            s += " ";
        }
        return s.trim();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        ArrayList<J07072> a = new ArrayList<J07072>();
        while (sc.hasNextLine()) {
            a.add(new J07072(chuanHoa(sc.nextLine())));
        }
        
        Collections.sort(a);
        for(J07072 x : a) {
            System.out.println(x);
        }
    }
}
