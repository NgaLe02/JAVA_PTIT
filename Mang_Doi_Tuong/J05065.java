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
public class J05065 {

    private String ma, ten, maChucVu, soHieu, bacLuong;

    static int GD = 0;
    static int TP = 0;
    static int PP = 0;

    public J05065(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public void setMaChucVu() {
        String x = ma.substring(0, 2);
        if (x.equals("GD")) {
            GD++;
            if (GD == 2) {
                x = "NV";
                GD = 1;
            }
        } else if (x.equals("TP")) {
            TP++;
            if (TP == 4) {
                x = "NV";
                TP = 3;
            }
        } else if (x.equals("PP")) {
            PP++;
            if (PP == 4) {
                x = "NV";
                PP = 3;
            }
        }
        this.maChucVu = x;
    }

    public void setSoHieu() {
        this.soHieu = ma.substring(4, 7);
    }

    public void setBacLuong() {
        this.bacLuong = ma.substring(2, 4);
    }

    @Override
    public String toString() {
        return ten + " " + maChucVu + " " + soHieu + " " + bacLuong;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05065[] a = new J05065[n];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] t = s.split("\\s+");
            a[i] = new J05065(t[0], t[1]);
            a[i].setBacLuong();
            a[i].setSoHieu();
            a[i].setMaChucVu();
        }

        Arrays.sort(a, new Comparator<J05065>() {
            @Override
            public int compare(J05065 t, J05065 t1) {
                if (!t.bacLuong.equals(t1.bacLuong)) {
                    return t1.bacLuong.compareTo(t.bacLuong);
                }
                return t.soHieu.compareTo(t1.soHieu);
            }
        });

        int m = Integer.parseInt(sc.nextLine());
        while (m-- > 0) {
            int ok = 0;
            String s = sc.nextLine();
            for (int i = 0; i < n; i++) {
                if (a[i].maChucVu.equals(s)) {
                    System.out.println(a[i]);
                    ok = 1;
                }
            }
            if (ok == 1) {
                System.out.println("");
            }
        }
    }
}
