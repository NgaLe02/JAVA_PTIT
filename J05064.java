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
public class J05064 {

    private String maNgach, hoTen;
    private int bacLuong, phuCap, thuNhap, luongCoBan;

    static int demHT = 0;
    static int demHP = 0;
    static int dem = 0;

    public J05064(String maNgach, String hoTen, int luongCoBan) {
        this.maNgach = maNgach;
        this.hoTen = hoTen;
        this.luongCoBan = luongCoBan;
    }

    public void setBacLuong() {
        this.bacLuong = Integer.parseInt(maNgach.substring(2, 4));
    }

    public void setPhuCap() {
        if (maNgach.startsWith("HT")) {
            this.phuCap = 2000000;
        } else if (maNgach.startsWith("HP")) {
            this.phuCap = 900000;
        } else if (maNgach.startsWith("GV")) {
            this.phuCap = 500000;
        }
    }

    public void setThuNhap() {
        this.thuNhap = luongCoBan * bacLuong + phuCap;
    }

    @Override
    public String toString() {
        return maNgach + " " + hoTen + " " + bacLuong + " " + phuCap + " " + thuNhap + "";
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        J05064[] a = new J05064[n];
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String maNgach = sc.nextLine();
            String hoTen = sc.nextLine();
            int luongCoBan = sc.nextInt();
            if (maNgach.startsWith("HT")) {
                demHT++;
                if (demHT < 2) {
                    a[dem++] = new J05064(maNgach, hoTen, luongCoBan);
                }
            } else if (maNgach.startsWith("HP")) {
                demHP++;
                if (demHP < 3) {
                    a[dem++] = new J05064(maNgach, hoTen, luongCoBan);
                }
            } else {
                a[dem++] = new J05064(maNgach, hoTen, luongCoBan);
            }
        }

        for (int i = 0; i < dem; i++) {
            a[i].setBacLuong();
            a[i].setPhuCap();
            a[i].setThuNhap();
        }

        for (int i = 0; i < dem; i++) {
            System.out.println(a[i]);
        }
    }
}
