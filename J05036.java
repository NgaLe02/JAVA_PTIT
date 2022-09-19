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
public class J05036 {

    private String ma, ten, donVi;
    private int phi, thanhTien, giaBan;

    public J05036(int ma, String ten, String donVi, int nhap, int soLuong) {
        this.ma = "MH" + String.format("%02d", ma);
        this.ten = ten;
        this.donVi = donVi;

        this.phi = (int) Math.round(nhap * soLuong * 0.05);
        this.thanhTien = (int) Math.round(nhap * soLuong + phi);
        this.giaBan = (int) Math.round(thanhTien * 1.02);
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + donVi + " " + (phi + " ") + (thanhTien + " ") + (giaBan + "");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05036[] a = new J05036[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05036(i + 1, sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
        }

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}