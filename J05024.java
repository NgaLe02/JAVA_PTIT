/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang_Doi_Tuong;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J05024 {

    private String ma, ten, lop, email, nganh;

    public J05024(String ma, String ten, String lop, String email) {
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

    public String getNganh() {
        return nganh;
    }

    public void setNganh() {
        String s = "";
        String res = ma.substring(3, 7);
        if (res.equals("DCKT")) {
            s = "KE TOAN";
        } else if (res.equals("DCCN") && lop.charAt(0) != 'E') {
            s = "CONG NGHE THONG TIN";
        } else if (res.equals("DCAT") && lop.charAt(0) != 'E') {
            s = "AN TOAN THONG TIN";
        } else if (res.equals("DCDT")) {
            s = "DIEN TU";
        } else if (res.equals("DCVT")) {
            s = "VIEN THONG";
        }
        this.nganh = s.toString();
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + lop + " " + email;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05024[] a = new J05024[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05024(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            a[i].setNganh();
        }

        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            s = s.toUpperCase();
            System.out.println("DANH SACH SINH VIEN NGANH " + s + ":");
            for (int i = 0; i < n; i++) {
                if (a[i].getNganh().equals(s)) {
                    System.out.println(a[i]);
                }
            }
        }
    }
}
