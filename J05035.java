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
public class J05035 {

    private int stt;
    private String maSV, ten, lop, email, doanhNghiep;

    public J05035(int stt, String maSV, String ten, String lop, String email, String doanhNghiep) {
        this.stt = stt;
        this.maSV = maSV;
        this.ten = ten;
        this.lop = lop;
        this.email = email;
        this.doanhNghiep = doanhNghiep;
    }

    public String getMaSV() {
        return maSV;
    }

    

    public String getDoanhNghiep() {
        return doanhNghiep;
    }

    @Override
    public String toString() {
        return stt + " " + maSV + " " + ten + " " + lop + " " + email + " " + doanhNghiep;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05035[] a = new J05035[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05035(i + 1, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
        }

        Arrays.sort(a, new Comparator<J05035>() {
            @Override
            public int compare(J05035 t, J05035 t1) {
                return t.getMaSV().compareTo(t1.getMaSV());
            }
        });

        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            for (int i = 0; i < n; i++) {
                if (a[i].getDoanhNghiep().equals(s)) {
                    System.out.println(a[i]);
                }
            }
        }
    }
}
