/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang_Doi_Tuong;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J05005 {

    private String msv, name, lop, date;
    private double gpa;

    public J05005(int stt, String name, String lop, String date, Double gpa) {
        this.msv = "B20DCCN" + String.format("%03d", stt);
        this.name = name;
        this.lop = lop;
        this.date = date;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        String diem = String.format("%.02f", gpa);
        return msv + " " + name + " " + lop + " " + date + " " + diem;
    }

    public static String chuanHoaName(String s) {
        s = s.toLowerCase().trim();
        String[] words = s.split("\\s+");
        s = "";
        for (String x : words) {
            s += String.valueOf((x.charAt(0))).toUpperCase() + x.substring(1);
            s += " ";
        }
        return s.toString().trim();
    }

    public static String chuanHoaDate(String s) {
        StringBuilder sb = new StringBuilder(s);
        if (sb.charAt(1) == '/') {
            sb.insert(0, "0");
        }
        if (sb.charAt(4) == '/') {
            sb.insert(3, "0");
        }
        return sb.toString();
    }

    public Double getGpa() {
        return gpa;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05005[] a = new J05005[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05005(i + 1, chuanHoaName(sc.nextLine()), sc.nextLine(), chuanHoaDate(sc.nextLine()), Double.parseDouble(sc.nextLine()));
        }

        Arrays.sort(a, new Comparator<J05005>() {
            @Override
            public int compare(J05005 t, J05005 t1) {
                return Double.compare(t1.getGpa(), t.getGpa());
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
