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
public class J05081 {

    private String ma, ten, donVi;
    private int mua, ban, loiNhuan;

    public J05081(int stt, String ten, String donVi, int mua, int ban) {
        this.ma = "MH" + String.format("%03d", stt);
        this.ten = ten;
        this.donVi = donVi;
        this.mua = mua;
        this.ban = ban;
        this.loiNhuan = ban - mua;
    }

    public int getLoiNhuan() {
        return loiNhuan;
    }

    public String getMa() {
        return ma;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " +donVi + " " + mua + " " + ban + " " + loiNhuan;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05081[] a = new J05081[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05081(i + 1, sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
        }

        Arrays.sort(a, new Comparator<J05081>() {
            @Override
            public int compare(J05081 t, J05081 t1) {
                if (t.loiNhuan != t1.loiNhuan) {
                    return t1.loiNhuan - t.loiNhuan;
                }
                return t.ma.compareTo(t1.ma);
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
