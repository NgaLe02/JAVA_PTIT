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
public class J05023 {

    private String ma, ten, lop, email, khoa;

    public J05023(String ma, String ten, String lop, String email) {
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.email = email;
    }

    public String getLop() {
        return lop;
    }

    public String getMa() {
        return ma;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa() {
        this.khoa = ("20" + lop.substring(1, 3)).toString();
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + lop + " " + email;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05023[] a = new J05023[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05023(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            a[i].setKhoa();
        }

        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            System.out.println("DANH SACH SINH VIEN KHOA " + s + ":");
            for (int i = 0; i < n; i++) {
                if (a[i].getKhoa().equals(s)) {
                    System.out.println(a[i]);
                }
            }
        }
    }
}
