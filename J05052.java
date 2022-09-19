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
public class J05052 {
    private String tenHang, maDonHang, soThuTuDonHang;
    private int giamGia, thanhTien;
    
    public J05052(String tenHang, String maDonHang) {
        this.tenHang = tenHang;
        this.maDonHang = maDonHang;
    }

    public void setSoThuTuDonHang( ) {
        this.soThuTuDonHang = maDonHang.substring(1, 4);
    }

    public void setGiamGia(int donGia, int soLuong) { 
        if(maDonHang.endsWith("1")) {
            this.giamGia = (int) donGia * soLuong  / 2;
        }
        else if(maDonHang.endsWith("2")) {
            this.giamGia = (int) donGia * soLuong * 3 / 10;
        }
    }

    public void setThanhTien(int donGia, int soLuong){
        this.thanhTien = donGia * soLuong - giamGia;
    }

    @Override
    public String toString() {
        return tenHang + " " + maDonHang + " " + soThuTuDonHang + " " + giamGia + " " + thanhTien;
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        J05052[] a = new J05052[n];
        for(int i = 0; i < n; i++) {
            sc.nextLine();
            String tenHang = sc.nextLine();
            String maDonHang = sc.nextLine();
            int donGia = sc.nextInt();
            int soLuong = sc.nextInt();
            a[i] = new J05052(tenHang, maDonHang);
            a[i].setSoThuTuDonHang();
            a[i].setGiamGia(donGia, soLuong);
            a[i].setThanhTien(donGia, soLuong);
        }
        
        for(int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}

