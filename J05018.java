/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang_Doi_Tuong;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.*;

/**
 *
 * @author Dell E7440
 */
public class J05018 {

    private String ma, ten, xepLoai;
    private Double gpa;

    public J05018(int ma, String ten, Double gpa) {
        this.ma = "HS" + String.format("%02d", ma);
        this.ten = ten;
        gpa = gpa / 12;
        this.gpa = Math.round(gpa * 10.0) / 10.0;
    }

    public void setXepLoai() {
        if (gpa >= 9) {
            this.xepLoai = "XUAT SAC";
        } else if (gpa >= 8) {
            this.xepLoai = "GIOI";
        } else if (gpa >= 7) {
            this.xepLoai = "KHA";
        } else if (gpa >= 5) {
            this.xepLoai = "TB";
        } else {
            this.xepLoai = "YEU";
        }
    }

    public Double getGpa() {
        return gpa;
    }

    public String getMa() {
        return ma;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + String.format("%.01f", gpa) + " " + xepLoai;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        J05018[] a = new J05018[n];
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String ten = sc.nextLine();
            double d1 = sc.nextDouble();
            double d2 = sc.nextDouble();
            double d3 = sc.nextDouble();
            double d4 = sc.nextDouble();
            double d5 = sc.nextDouble();
            double d6 = sc.nextDouble();
            double d7 = sc.nextDouble();
            double d8 = sc.nextDouble();
            double d9 = sc.nextDouble();
            double d10 = sc.nextDouble();
            a[i] = new J05018(i + 1, ten, d1 * 2 + d2 * 2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + d10);
            a[i].setXepLoai();
        }

        Arrays.sort(a, new Comparator<J05018>() {

            @Override
            public int compare(J05018 t, J05018 t1) {
                if (t.getGpa() != t1.getGpa()) {
                    return Double.compare(t1.getGpa(), t.getGpa());
                }
                return t.getMa().compareTo(t1.getMa());
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
