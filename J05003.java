/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang_Doi_Tuong;

import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J05003 {

    private String msv, name, lop, date;
    private Double gpa;

    public J05003(int stt, String name, String lop, String date, Double gpa) {
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

    public static String chuanHoaDate(String s) {
        StringBuilder sb = new StringBuilder(s);
        if (sb.charAt(1) == '/') {
            sb.insert(0, '0');
        }
        if (sb.charAt(4) == '/') {
            sb.insert(3, '0');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05003[] a = new J05003[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05003(i + 1, sc.nextLine(), sc.nextLine(), chuanHoaDate(sc.nextLine()), Double.parseDouble(sc.nextLine()));
        }
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}