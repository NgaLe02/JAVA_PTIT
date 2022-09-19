/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang_Doi_Tuong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J05062 {

    private String hoTen, ketQua;
    private double diemTBC, diemRL;

    static int m;
    static double diemChuan;

    static ArrayList<String> mem = new ArrayList<>();

    public J05062(String hoTen, double diemTBC, double diemRL) {
        this.hoTen = hoTen;
        this.diemTBC = diemTBC;
        this.diemRL = diemRL;
    }

    public void setKetQua() {
        if (m > 0) {
            if (diemTBC >= 3.6 && diemRL >= 90) {
                this.ketQua = "XUATSAC";
                m--;
                diemChuan = diemTBC;
            } else if (diemTBC >= 3.2 && diemRL >= 80) {
                this.ketQua = "GIOI";
                m--;
                diemChuan = diemTBC;
            } else if (diemTBC >= 2.5 && diemRL >= 70) {
                this.ketQua = "KHA";
                m--;
                diemChuan = diemTBC;
            } else {
                this.ketQua = "KHONG";
            }
        } else if (m <= 0 && diemTBC == diemChuan) {
            if (diemRL >= 90) {
                this.ketQua = "XUATSAC";
            } else if (diemRL >= 80) {
                this.ketQua = "GIOI";
            } else if (diemRL >= 70) {
                this.ketQua = "KHA";
            } else {
                this.ketQua = "KHONG";
            }
        } else {
            this.ketQua = "KHONG";
        }
    }

    @Override
    public String toString() {
        return hoTen + ": " + ketQua;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] words = s.split("\\s+");
        int n = Integer.parseInt(words[0]);
        m = Integer.parseInt(words[1]);
        J05062[] a = new J05062[n];
        for (int i = 0; i < n; i++) {
            String hoTen = sc.nextLine();
            mem.add(hoTen);
            String t = sc.nextLine();
            String[] tmp = t.split("\\s+");
            double diemTBC = Double.parseDouble(tmp[0]);
            double diemRL = Double.parseDouble(tmp[1]);
            a[i] = new J05062(hoTen, diemTBC, diemRL);
        }

        Arrays.sort(a, new Comparator<J05062>() {
            @Override
            public int compare(J05062 t, J05062 t1) {
                if (t1.diemTBC != t.diemTBC) {
                    return Double.compare(t1.diemTBC, t.diemTBC);
                }
                return Double.compare(t1.diemRL, t.diemRL);
            }
        });

        for (int i = 0; i < n; i++) {
            a[i].setKetQua();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[j].hoTen.equals(mem.get(i))) {
                    System.out.println(a[j]);
                    break;
                }
            }
        }
    }
}
