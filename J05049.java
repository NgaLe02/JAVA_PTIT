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
public class J05049 {

    private String maHang;
    private int soLuongNhap, soLuongXuat, donGia, tien, thue;

    public J05049(String maHang, int soLuongNhap) {
        this.maHang = maHang;
        this.soLuongNhap = soLuongNhap;
    }

    public void setSoLuongXuat() {
        if (maHang.startsWith("A")) {
            this.soLuongXuat = (int) Math.round(soLuongNhap * 0.6);
        } else if (maHang.startsWith("B")) {
            this.soLuongXuat = (int) Math.round(soLuongNhap * 0.7);
        }
    }

    public void setDonGia() {
        if (maHang.endsWith("Y")) {
            this.donGia = 110000;
        } else if (maHang.endsWith("N")) {
            this.donGia = 135000;
        }
    }

    public void setTien() {
        this.tien = soLuongXuat * donGia;
    }

    public void setThue() {
        if (maHang.startsWith("A") && maHang.endsWith("Y")) {
            this.thue = (int) Math.round(tien * 0.08);
        } else if (maHang.startsWith("A") && maHang.endsWith("N")) {
            this.thue = (int) Math.round(tien * 0.11);
        } else if (maHang.startsWith("B") && maHang.endsWith("Y")) {
            this.thue = (int) Math.round(tien * 0.17);
        } else if (maHang.startsWith("B") && maHang.endsWith("N")) {
            this.thue = (int) Math.round(tien * 0.22);
        }
    }

    public int getThue() {
        return thue;
    }

    public String getMaHang() {
        return maHang;
    }

    @Override
    public String toString() {
        return maHang + " " + soLuongNhap + " " + soLuongXuat + " " + donGia + " " + tien + " " + thue + "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05049[] a = new J05049[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05049(sc.nextLine(), Integer.parseInt(sc.nextLine()));
            a[i].setSoLuongXuat();
            a[i].setDonGia();
            a[i].setTien();
            a[i].setThue();
        }
        Arrays.sort(a, new Comparator<J05049>() {
            @Override
            public int compare(J05049 t, J05049 t1) {
                return t1.getThue() - t.getThue();
            }
        });

        String s = sc.nextLine();

        for (int i = 0; i < n; i++) {
            if (a[i].getMaHang().startsWith(s)) {
                System.out.println(a[i]);
            }
        }
    }
}
