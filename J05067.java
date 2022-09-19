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
public class J05067 {

    private String maDonHang, hangSanXuat;
    private long donGia, thue, thanhTien, soLuong;

    public J05067(String maDonHang, long soLuong) {
        this.maDonHang = maDonHang;
        this.soLuong = soLuong;
    }

    public void setHangSanXuat() {
        if (maDonHang.endsWith("BP")) {
            this.hangSanXuat = "British Petro";
        } else if (maDonHang.endsWith("ES")) {
            this.hangSanXuat = "Esso";
        } else if (maDonHang.endsWith("SH")) {
            this.hangSanXuat = "Shell";
        } else if (maDonHang.endsWith("CA")) {
            this.hangSanXuat = "Castrol";
        } else if (maDonHang.endsWith("MO")) {
            this.hangSanXuat = "Mobil";
        } else if (maDonHang.endsWith("TN")) {
            this.hangSanXuat = "Trong Nuoc";
        }
    }

    public void setDonGia() {
        if (maDonHang.startsWith("X")) {
            this.donGia = 128000;
        } else if (maDonHang.startsWith("D")) {
            this.donGia = 11200;
        } else if (maDonHang.startsWith("N")) {
            this.donGia = 9700;
        }
    }

    public void setThue() {
        if (maDonHang.endsWith("TN")) {
            this.thue = 0;
        } else {
            long x = soLuong * donGia;
            if (maDonHang.startsWith("X")) {
                this.thue = (int) Math.round(x * 0.03);
            } else if (maDonHang.startsWith("D")) {
                this.thue = (int) Math.round(x * 0.035);
            } else if (maDonHang.startsWith("N")) {
                this.thue = (int) Math.round(x * 0.02);
            }
        }
    }

    public void setThanhTien() {
        this.thanhTien = soLuong * donGia + thue;
    }

    @Override
    public String toString() {
        return maDonHang + " " + hangSanXuat + " " + donGia + " " + thue + " " + thanhTien;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05067[] a = new J05067[n];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] words = s.split("\\s+");
            a[i] = new J05067(words[0], Long.parseLong(words[1]));
            a[i].setDonGia();
            a[i].setHangSanXuat();
            a[i].setThue();
            a[i].setThanhTien();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
