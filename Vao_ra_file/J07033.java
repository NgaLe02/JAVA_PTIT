/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J07033 implements Comparable<J07033> {

    private String msv, ten, lop, email;

    public J07033(String msv, String ten, String lop, String email) {
        this.msv = msv;
        this.ten = ten;
        this.lop = lop;
        this.email = email;
    }

    @Override
    public String toString() {
        return msv + " " + ten + " " + lop + " " + email;
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
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<J07033> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(new J07033(sc.nextLine(), chuanHoa(sc.nextLine()), sc.nextLine(), sc.nextLine()));
        }

        Collections.sort(a);
        for (J07033 x : a) {
            System.out.println(x);
        }
    }

    @Override
    public int compareTo(J07033 t) {
        return msv.compareTo(t.msv);
    }
}
