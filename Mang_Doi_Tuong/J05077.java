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
public class J05077 {

    public static class phongBan {

        private String maPhong, tenPhong;

        public phongBan(String maPhong, String tenPhong) {
            this.maPhong = maPhong;
            this.tenPhong = tenPhong;
        }
    }

    public static class nhanVien {

        private String ma, ten;
        private int luongCoBan, soNgayCong, luongThang;

        public nhanVien(String ma, String ten, int luongCoBan, int soNgayCong) {
            this.ma = ma;
            this.ten = ten;
            this.luongCoBan = luongCoBan;
            this.soNgayCong = soNgayCong;
        }
        
        public void setLuongThang() {
            int soNamCongTac = Integer.parseInt(ma.substring(1, 3));
            int heSo = 2;
            if (ma.startsWith("A")) {
                if (soNamCongTac >= 1 && soNamCongTac <= 3) {
                    heSo = 10;
                } else if (soNamCongTac >= 4 && soNamCongTac <= 8) {
                    heSo = 12;
                } else if (soNamCongTac >= 9 && soNamCongTac <= 15) {
                    heSo = 14;
                } else if (soNamCongTac >= 16) {
                    heSo = 20;
                }
            } else if (ma.startsWith("B")) {
                if (soNamCongTac >= 1 && soNamCongTac <= 3) {
                    heSo = 10;
                } else if (soNamCongTac >= 4 && soNamCongTac <= 8) {
                    heSo = 11;
                } else if (soNamCongTac >= 9 && soNamCongTac <= 15) {
                    heSo = 13;
                } else if (soNamCongTac >= 16) {
                    heSo = 16;
                }
            } else if (ma.startsWith("C")) {
                if (soNamCongTac >= 1 && soNamCongTac <= 3) {
                    heSo = 9;
                } else if (soNamCongTac >= 4 && soNamCongTac <= 8) {
                    heSo = 10;
                } else if (soNamCongTac >= 9 && soNamCongTac <= 15) {
                    heSo = 12;
                } else if (soNamCongTac >= 16) {
                    heSo = 14;
                }
            } else if (ma.startsWith("D")) {
                if (soNamCongTac >= 1 && soNamCongTac <= 3) {
                    heSo = 8;
                } else if (soNamCongTac >= 4 && soNamCongTac <= 8) {
                    heSo = 9;
                } else if (soNamCongTac >= 9 && soNamCongTac <= 15) {
                    heSo = 11;
                } else if (soNamCongTac >= 16) {
                    heSo = 13;
                }
            }
            this.luongThang = heSo * luongCoBan * soNgayCong * 1000;
        }

        @Override
        public String toString() {
            return ma + " " + ten + " " + luongThang;
        }
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        phongBan[] a = new phongBan[n];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            a[i] = new phongBan(s.substring(0, 2), s.substring(3));
        }

        int m = Integer.parseInt(sc.nextLine());
        nhanVien[] b = new nhanVien[m];
        for (int i = 0; i < m; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            int luongCoBan = Integer.parseInt(sc.nextLine());
            int soNgayCong = Integer.parseInt(sc.nextLine());
            b[i] = new nhanVien(ma, ten, luongCoBan, soNgayCong);
            b[i].setLuongThang();
        }
        
       for(int i = 0; i < m; i++) {
           System.out.print(b[i].ma + " " + b[i].ten + " ");
           for(int j = 0; j < n; j++) {
               if(a[j].maPhong.equals(b[i].ma.substring(3, 5))) {
                   System.out.print(a[j].tenPhong + " ");
                   break;
               }
           }
           System.out.println(b[i].luongThang);
       }
    }
}
