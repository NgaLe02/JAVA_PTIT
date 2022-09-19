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
public class J05015 {

    private String ma, hoTen, donVi, thoiDiem;
    int vanToc;

    public J05015(String hoTen, String donVi, String thoiDiem) {
        this.hoTen = hoTen;
        this.donVi = donVi;
        this.thoiDiem = thoiDiem;
    }

    @Override
    public String toString() {
        return ma + " " + hoTen + " " + donVi + " " + vanToc + " Km/h";
    }

    public void setMa() {
        String s = "";
        String[] t = donVi.split("\\s+");
        String[] t1 = hoTen.split("\\s+");
        for (String x : t) {
            s += x.charAt(0);
        }
        for (String x : t1) {
            s += x.charAt(0);
        }
        this.ma = s.toString();
    }

    public void setVanToc() {
        String[] t = thoiDiem.split(":");
        double time = (Integer.parseInt(t[0]) - 6) + (double) Integer.parseInt(t[1]) / 60;
        this.vanToc = (int) Math.round(120 / time);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05015[] a = new J05015[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05015(sc.nextLine(), sc.nextLine(), sc.nextLine());
            a[i].setMa();
            a[i].setVanToc();
        }

        Arrays.sort(a, new Comparator<J05015>() {
            @Override
            public int compare(J05015 t, J05015 t1) {
                String[] tmp = t.thoiDiem.split(":");
                String[] tmp1 = t1.thoiDiem.split(":");
                if (!tmp[0].equals(tmp1[0])) {
                    return tmp[0].compareTo(tmp1[0]);
                }
                return tmp[1].compareTo(tmp1[1]);
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
