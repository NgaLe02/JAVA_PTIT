/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J07010 {

    private String ma, ten, lop, ngaySinh;
    private double diem;

    public J07010() {
    }

    public J07010(int ma, String ten, String lop, String ngaySinh, double diem) {
        this.ma = String.format("B20DCCN%03d", ma);
        this.ten = ten;
        this.lop = lop;
        this.ngaySinh = ngaySinh;
        this.diem = diem;
    }

    public static String chuanHoaNgaySinh(String s) {
        StringBuilder sb = new StringBuilder(s);
        if (sb.charAt(1) == '/') {
            sb.insert(0, '0');
        }
        if (sb.charAt(4) == '/') {
            sb.insert(3, '0');
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + lop + " " + ngaySinh + " " + String.format("%.2f", diem);
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("SV.in");
        Scanner sc = new Scanner(file);
        int n = Integer.parseInt(sc.nextLine());
        J07010[] a = new J07010[n];
        for (int i = 0; i < n; i++) {
            String ten = sc.nextLine();
            String lop = sc.nextLine();
            String ngaySinh = sc.nextLine();
            double diem = Double.parseDouble(sc.nextLine());
            a[i] = new J07010(i + 1, ten, lop, chuanHoaNgaySinh(ngaySinh), diem);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
