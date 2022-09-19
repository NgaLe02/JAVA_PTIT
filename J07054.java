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
public class J07054 implements Comparable<J07054> {

    private String ma, ten;
    private double diem;
    private int xepHang;

    public J07054(int ma, String ten, double diem1, double diem2, double diem3) {
        this.ma = String.format("SV%02d", ma);
        this.ten = ten;
        this.diem = (diem1 * 3 + diem2 * 3 + diem3 * 2) / 8;
    }

    @Override
    public int compareTo(J07054 t) {
        if (t.diem != diem) {
            return Double.compare(t.diem, diem);
        }
        return ma.compareTo(t.ma);
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + String.format("%.2f", diem) + " " + xepHang;
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
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<J07054> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(new J07054(i + 1, chuanHoa(sc.nextLine()), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine())));
        }

        Collections.sort(a);
        a.get(0).xepHang = 1;
        for (int i = 1; i < n; i++) {
            if (a.get(i).diem == a.get(i - 1).diem) {
                a.get(i).xepHang = a.get(i - 1).xepHang;
            } else {
                a.get(i).xepHang = i + 1;
            }
        }

        for (J07054 x : a) {
            System.out.println(x);
        }
    }
}
