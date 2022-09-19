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
public class J05048 {

    private String maHang;
    private int soLuongNhap, soLuongXuat, donGia, tien, thue;

    public J05048(String maHang, int soLuongNhap) {
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

    @Override
    public String toString() {
        return maHang + " " + soLuongNhap + " " + soLuongXuat + " " + donGia + " " + tien + " " + thue + "" ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05048[] a = new J05048[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05048(sc.nextLine(), Integer.parseInt(sc.nextLine()));
            a[i].setSoLuongXuat();
            a[i].setDonGia();
            a[i].setTien();
            a[i].setThue();
        }
        
        for(int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
