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
public class J05082 {

    private String ma, ten, gioTinh, ngaySinh, diaChi;

    public J05082(int ma, String ten, String gioTinh, String ngaySinh, String diaChi) {
        this.ma = "KH" + String.format("%03d", ma);
        this.ten = ten;
        this.gioTinh = gioTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + gioTinh + " " + diaChi + " " + ngaySinh;
    }

    public static String chuanHoaTen(String s) {
        s = s.toLowerCase().trim();
        String[] t = s.split("\\s+");
        s = "";
        for(String x : t) {
            s += String.valueOf(x.charAt(0)).toUpperCase() + x.substring(1);
            s += " ";
        }
        return s.toString().trim();
    }

    public static String chuanHoaNgaySinh(String s) {
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(1) == '/') {
            sb.insert(0, '0');
        }
        if(sb.charAt(4) == '/') {
            sb.insert(3, '0');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05082[] a = new J05082[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05082(i + 1, chuanHoaTen(sc.nextLine()), sc.nextLine(), chuanHoaNgaySinh(sc.nextLine()), sc.nextLine());
        }

        Arrays.sort(a, new Comparator<J05082>() {
            @Override
            public int compare(J05082 t, J05082 t1) {
                String[] date = t.ngaySinh.split("/");
                String[] date1 = t1.ngaySinh.split("/");
                if (Integer.parseInt(date[2]) != Integer.parseInt(date1[2])) {
                    return Integer.parseInt(date[2]) - Integer.parseInt(date1[2]);
                }
                if (Integer.parseInt(date[1]) != Integer.parseInt(date1[1])) {
                    return Integer.parseInt(date[1]) - Integer.parseInt(date1[1]);
                }
                return Integer.parseInt(date[0]) - Integer.parseInt(date1[0]);
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
