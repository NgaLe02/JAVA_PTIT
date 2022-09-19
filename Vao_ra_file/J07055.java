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
public class J07055 implements Comparable<J07055> {

    private String ma, ten;
    private double diem;
    private int xepHang;

    public J07055(int ma, String ten, double diem1, double diem2, double diem3) {
        this.ma = String.format("SV%02d", ma);
        this.ten = ten;
        this.diem = diem1 * 0.25 + diem2 * 0.35 + diem3 * 0.4;
    }

    @Override
    public int compareTo(J07055 t) {
        return Double.compare(t.diem, diem);
    }

    public String getXepHang() {
        if (diem >= 8) {
            return "GIOI";
        } else if (diem >= 6.5) {
            return "KHA";
        } else if (diem >= 5) {
            return "TRUNG BINH";
        } else {
            return "KEM";
        }
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + String.format("%.2f", diem) + " " + getXepHang();
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
        ArrayList<J07055> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(new J07055(i + 1, chuanHoa(sc.nextLine()), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine())));
        }

        Collections.sort(a);

        for (J07055 x : a) {
            System.out.println(x);
        }
    }
}
