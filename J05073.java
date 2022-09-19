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
public class J05073 {

    private String ma;
    private int donGia, soLuong;

    public J05073() {
    }

    public J05073(String ma, int donGia, int soLuong) {
        this.ma = ma;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public double giaBanMatHang() {
        double thue = 0;
        double phiVanChuyen = 0;
        if (ma.startsWith("T")) {
            thue = 29;
            phiVanChuyen = 4;
        } else if (ma.startsWith("C")) {
            thue = 10;
            phiVanChuyen = 3;
        } else if (ma.startsWith("D")) {
            thue = 8;
            phiVanChuyen = 2.5;
        } else if (ma.startsWith("M")) {
            thue = 2;
            phiVanChuyen = 0.5;
        }

        thue = donGia * soLuong * thue / 100;
        if (ma.endsWith("C")) {
            thue = thue * 0.95;
        }
        double x = (double) thue + soLuong * donGia * (phiVanChuyen + 100) / 100;
        return (double) Math.round(x * 1.2) / soLuong;
    }

    @Override
    public String toString() {
        return ma + " " + String.format("%.2f", giaBanMatHang());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05073[] a = new J05073[n];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] t = s.split("\\s+");
            a[i] = new J05073(t[0], Integer.parseInt(t[1]), Integer.parseInt(t[2]));
        }

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
