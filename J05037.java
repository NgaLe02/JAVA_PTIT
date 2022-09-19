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
public class J05037 {

    private String ma, ten, donVi;
    private int phi, thanhTien, giaBanLe;

    public J05037(int ma, String ten, String donVi, int nhap, int soLuong) {
        this.ma = "MH" + String.format("%02d", ma);
        this.ten = ten;
        this.donVi = donVi;

        this.phi = (int) Math.round(nhap * soLuong * 0.05);
        this.thanhTien = (int) Math.round(nhap * soLuong + phi);
        this.giaBanLe = (int) Math.ceil((thanhTien * 1.02 / soLuong) / 100.0) * 100;
    }

    public int getGiaBanLe() {
        return giaBanLe;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + donVi + " " + (phi + " ") + (thanhTien + " ") + (giaBanLe + "");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05037[] a = new J05037[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05037(i + 1, sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
        }

        Arrays.sort(a, new Comparator<J05037>() {
            @Override
            public int compare(J05037 t, J05037 t1) {
                return t1.getGiaBanLe() - t.giaBanLe;
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
