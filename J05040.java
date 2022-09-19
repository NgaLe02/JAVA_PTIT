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
public class J05040 {

    private String ma, ten;
    private int luongThang, thuong, phuCap, thucLinh;

    public J05040(int ma, String ten) {
        this.ma = "NV" + String.format("%02d", ma);
        this.ten = ten;
    }

    public void setLuongThang(int luongNgay, int soNgayCong) {
        this.luongThang = luongNgay * soNgayCong;
    }

    public void setThuong(int soNgayCong) {
        if (soNgayCong >= 25) {
            this.thuong = (int) Math.round(luongThang / 5);
        } else if (soNgayCong >= 22) {
            this.thuong = (int) Math.round(luongThang / 10);
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
        J05040[] a = new J05040[n];
        for (int i = 0; i < n; i++) {
            String ten = sc.nextLine();
            int luongNgay = sc.nextInt();
            int soNgayCong = sc.nextInt();
            sc.nextLine();
            String chucVu = sc.nextLine();
            a[i] = new J05040(i + 1, ten);
            a[i].setLuongThang(luongNgay, soNgayCong);
            a[i].setThuong(soNgayCong);
            a[i].setPhuCap(chucVu);
            a[i].setThucLinh();
        }
        
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
