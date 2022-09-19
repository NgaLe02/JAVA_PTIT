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
public class J05070 {

    private String ma, ten, maTran;
    private int giaVe, doanhThu, soCDV;

    public J05070(String ma, String ten, int giaVe) {
        this.ma = ma;
        this.ten = ten;
        this.giaVe = giaVe;
    }

    public void setMaTran(String maTran) {
        this.maTran = maTran;
    }

    public void setDoanhThu() {
        this.doanhThu = soCDV * giaVe;
    }

    public void setSoCDV(int soCDV) {
        this.soCDV = soCDV;
    }

    public int getDoanhThu() {
        return doanhThu;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public int getGiaVe() {
        return giaVe;
    }

    @Override
    public String toString() {
        return maTran + " " + ten + " " + doanhThu;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05070[] a = new J05070[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05070(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()));
        }

        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            String[] words = s.split("\\s+");
            String maTran = words[0];
            int soCDV = Integer.parseInt(words[1]);
            for (int i = 0; i < n; i++) {
                if (maTran.substring(1, 3).equals(a[i].getMa())) {
                    a[i].setSoCDV(soCDV);
                    a[i].setDoanhThu();
                    a[i].setMaTran(maTran);
                }
            }
        }
        Arrays.sort(a, new Comparator<J05070>() {
            @Override
            public int compare(J05070 t, J05070 t1) {
                if (t.doanhThu != t1.doanhThu) {
                    return t1.doanhThu - t.doanhThu;
                }
                return t.ten.compareTo(t1.ten);
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
