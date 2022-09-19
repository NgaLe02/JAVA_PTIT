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
public class J05022 {

    private String ma, ten, lop, email;

    public J05022(String ma, String ten, String lop, String email) {
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

    @Override
    public String toString() {
        return ma + " " + ten + " " + lop + " " + email;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05022[] a = new J05022[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05022(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
        }

        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            System.out.println("DANH SACH SINH VIEN LOP " + s + ":");
            for (int i = 0; i < n; i++) {
                if (a[i].getLop().equals(s)) {
                    System.out.println(a[i]);
                }
            }
        }
    }
}
