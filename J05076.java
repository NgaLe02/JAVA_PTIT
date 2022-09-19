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
public class J05076 {
    private String ma, ten, xepLoai;
    private int soLuongNhap, donGiaNhap, soLuongXuat;

    public J05076(String ma, String ten, String xepLoai) {
        this.ma = ma;
        this.ten = ten;
        this.xepLoai = xepLoai;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public void setDonGiaNhap(int donGiaNhap) {
        this.donGiaNhap = donGiaNhap;
    }

    public void setSoLuongXuat(int soLuongXuat) {
        this.soLuongXuat = soLuongXuat;
    }
    
    public int getTongGiaTriNhap() {
        return soLuongNhap * donGiaNhap;
    }
    
    public int getTongGiaTriXuat() {
        if(xepLoai.equals("A")) {
            return soLuongXuat * donGiaNhap * 108 / 100;
        }
        else if(xepLoai.equals("B")) {
            return soLuongXuat * donGiaNhap * 105 / 100;
        }
        else if (xepLoai.equals("C")) {
            return soLuongXuat * donGiaNhap * 102 / 100;
        }
        return 0;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + getTongGiaTriNhap() + " " + getTongGiaTriXuat();
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05076[] a = new J05076[n];
        for(int i = 0; i < n; i++) {
            a[i] = new J05076(sc.nextLine(), sc.nextLine(), sc.nextLine());
        }
        
        int m = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < m; i++) {
            String s = sc.nextLine();
            String[] words = s.split("\\s+");
            for(int j = 0; j < n; j++) {
                if(a[j].ma.equals(words[0])) {
                    a[j].setSoLuongNhap(Integer.parseInt(words[1]));
                    a[j].setDonGiaNhap(Integer.parseInt(words[2]));
                    a[j].setSoLuongXuat(Integer.parseInt(words[3]));
                    System.out.println(a[j]);
                    break;
                }
            }
        }
    }
}
