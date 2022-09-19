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
public class J05044 {
    
    private String ma, ten, chucVu;
    private int phuCap, luongChinh, tamUng, conLai;
    
    public J05044(int ma, String ten, String chucVu) {
        this.ma = "NV" + String.format("%02d", ma);
        this.ten = ten;
        this.chucVu = chucVu;
    }
    
    public void setPhuCap(String chucVu) {
        if (chucVu.equals("GD")) {
            this.phuCap = 500;
        } else if (chucVu.equals("PGD")) {
            this.phuCap = 400;
        } else if (chucVu.equals("TP")) {
            this.phuCap = 300;
        } else if (chucVu.equals("KT")) {
            this.phuCap = 250;
        } else {
            this.phuCap = 100;
        }
    }
    
    public void setLuongChinh(int luongCoBan, int soNgayCong) {
        this.luongChinh = luongCoBan * soNgayCong;
    }
    
    public void setTamUng() {
        int tmp = (int) (phuCap + luongChinh) * 2 / 3;
        if (tmp < 25000) {
            this.tamUng = (int) Math.round(tmp / 1000.0) * 1000;
        } else {
            this.tamUng = 25000;
        }
    }
    
    public void setConLai(int conLai) {
        this.conLai = luongChinh - tamUng + phuCap;
    }
    
    public String getChucVu() {
        return chucVu;
    }
    
    @Override
    public String toString() {
        return ma + " " + ten + " " + phuCap + " " + luongChinh + " " + tamUng + " " + conLai + "";
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05044[] a = new J05044[n];
        for (int i = 0; i < n; i++) {
            String ten = sc.nextLine();
            String chucVu = sc.nextLine();
            int luongCoBan = Integer.parseInt(sc.nextLine());
            int soNgayCong = Integer.parseInt(sc.nextLine());
            a[i] = new J05044(i + 1, ten, chucVu);
            a[i].setPhuCap(chucVu);
            a[i].setLuongChinh(luongCoBan, soNgayCong);
            a[i].setTamUng();
            a[i].setConLai(i);
        }
        
        String s = sc.nextLine();
        
        for (int i = 0; i < n; i++) {
            if (a[i].getChucVu().equals(s)) {
                System.out.println(a[i]);
            }
        }
    }
}
