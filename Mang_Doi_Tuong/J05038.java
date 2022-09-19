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
public class J05038 {

    private String ma, ten;
    private int luongThang, thuong, phuCap, thucLinh;

    public J05038(int ma, String ten) {
        this.ma = "NV" + String.format("%02d", ma);
        this.ten = ten;
    }

    public void setLuongThang(int luongNgay, int soNgayCong) {
        this.luongThang = luongNgay * soNgayCong;
    }

    public void setThuong(int soNgayCong) {
        if (soNgayCong >= 25) {
            this.thuong = (int) Math.round(luongThang * 0.2);
        } else if (soNgayCong >= 22) {
            this.thuong = (int) Math.round(luongThang * 0.1);
        } else {
            this.thuong = 0;
        }
    }

    public void setPhuCap(String chucVu) {
        if (chucVu.equals("GD")) {
            this.phuCap = 250000;
        } else if (chucVu.equals("PGD")) {
            this.phuCap = 200000;
        } else if (chucVu.equals("TP")) {
            this.phuCap = 180000;
        } else if (chucVu.equals("NV")) {
            this.phuCap = 150000;
        }
    }

    public void setThucLinh() {
        this.thucLinh = luongThang + phuCap + thuong;
    }

    public int getThucLinh() {
        return thucLinh;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + luongThang + " " + thuong + " " + phuCap + " " + thucLinh + "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05038[] a = new J05038[n];
        for (int i = 0; i < n; i++) {
            String ten = sc.nextLine();
            int luongNgay = sc.nextInt();
            int soNgayCong = sc.nextInt();
            sc.nextLine();
            String chucVu = sc.nextLine();
            a[i] = new J05038(i + 1, ten);
            a[i].setLuongThang(luongNgay, soNgayCong);
            a[i].setThuong(soNgayCong);
            a[i].setPhuCap(chucVu);
            a[i].setThucLinh();
        }
        int salary = 0;
        for (int i = 0; i < n; i++) {
            salary += a[i].getThucLinh();
            System.out.println(a[i]);
        }
        System.out.println("Tong chi phi tien luong: " + salary);
    }
}
