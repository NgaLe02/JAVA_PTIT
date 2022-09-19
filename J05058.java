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
public class J05058 {

    private String maTS, hoTen, trangThai;
    private double diem, diemUuTien, tongDiem;

    public J05058(String maTS, String hoTen, double diem) {
        this.maTS = maTS;
        this.hoTen = hoTen;
        this.diem = diem;
    }

    public void setTrangThai() {
        if (tongDiem >= 24) {
            this.trangThai = "TRUNG TUYEN";
        } else {
            this.trangThai = "TRUOT";
        }
    }

    public void setTongDiem() {
        this.tongDiem = diem + diemUuTien;
    }

    public void setDiemUuTien() {
        if (maTS.startsWith("KV1")) {
            this.diemUuTien = 0.5;
        } else if (maTS.startsWith("KV2")) {
            this.diemUuTien = 1.0;
        } else if (maTS.startsWith("KV3")) {
            this.diemUuTien = 2.5;
        }
    }

    @Override
    public String toString() {
        String s = maTS + " " + hoTen + " ";
        if (diemUuTien == (int) diemUuTien) {
            s += (int) diemUuTien + " ";
        } else {
            String t = String.format("%1.1f", diemUuTien);
            s = s + t + " ";
        }
        if (tongDiem == (int) tongDiem) {
            s += (int) tongDiem + " ";
        } else {
            String t = String.format("%1.1f", tongDiem);
            s = s + t + " ";
        }
        s += trangThai;
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        J05058[] a = new J05058[n];
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String maTS = sc.nextLine();
            String hoTen = sc.nextLine();
            double diemToan = sc.nextFloat();
            double diemLy = sc.nextFloat();
            double diemHoa = sc.nextFloat();
            a[i] = new J05058(maTS, hoTen, diemToan * 2 + diemLy + diemHoa);
            a[i].setDiemUuTien();
            a[i].setTongDiem();
            a[i].setTrangThai();
        }

        Arrays.sort(a, new Comparator<J05058>() {
            @Override
            public int compare(J05058 t, J05058 t1) {
                return Double.compare(t1.tongDiem, t.tongDiem);
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
