/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lop_va_doi_tuong;

import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J04012 {

    private String maNhanVien, hoTen, chucVu;
    private int luongCoBan, soNgayCong;

    public J04012() {

    }

    public J04012(String maNhanVien, String hoTen, String chucVu, int luongCoBan, int soNgayCong) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.chucVu = chucVu;
        this.luongCoBan = luongCoBan;
        this.soNgayCong = soNgayCong;
    }

    public int thuong(int soNgayCong, int luongCoBan) {
        int luong = soNgayCong * luongCoBan;
        if (soNgayCong < 22) {
            return 0;
        }
        if (soNgayCong >= 22 && soNgayCong < 25) {
            return luong / 10;
        }
        return luong / 5;
    }

    public int phuCap(String chucVu) {
        int phuCap = 0;
        if (chucVu.equals("GD")) {
            phuCap = 250000;
        }
        if (chucVu.equals("PGD")) {
            phuCap = 200000;
        }
        if (chucVu.equals("TP")) {
            phuCap = 180000;
        }
        if (chucVu.equals("NV")) {
            phuCap = 150000;
        }
        return phuCap;
    }

    
    @Override
    public String toString() {
        int luong = this.luongCoBan * soNgayCong;
        int thuong = thuong(this.soNgayCong, this.luongCoBan);
        int phuCap = phuCap(this.chucVu);
        int thuNhap = luong + thuong + phuCap;
        return this.maNhanVien + " " + this.hoTen + " " + (luong + "") + " " + (thuong + "")
                + " " + (phuCap + "") + " " + (thuNhap + "");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hoTen = sc.nextLine();
        int luongCoBan = sc.nextInt();
        int soNgayCong = sc.nextInt();
        sc.nextLine();
        String chucVu = sc.nextLine();
        J04012 nhanVien = new J04012("NV01", hoTen, chucVu, luongCoBan, soNgayCong);
        System.out.println(nhanVien.toString());
    }

    
}
