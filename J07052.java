/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J07052 {

    private String maTS, hoTen, trangThai;
    private double diem, diemUuTien, tongDiem;

    static double diemChuan;

    public J07052(String maTS, String hoTen, double diem) {
        this.maTS = maTS;
        this.hoTen = hoTen;
        this.diem = diem;
    }

    public void setTrangThai() {
        if (tongDiem >= diemChuan) {
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
    
    public static String chuanHoa(String s) {
        s = s.trim().toLowerCase();
        String[] words = s.split("\\s+");
        s = "";
        for (String x : words) {
            s += String.valueOf(x.charAt(0)).toUpperCase() + x.substring(1);
            s += " ";
        }
        return s.trim();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("THISINH.in"));
        int n = Integer.parseInt(sc.nextLine());
        J07052[] a = new J07052[n];
        for (int i = 0; i < n; i++) {
            String maTS = sc.nextLine();
            String hoTen = sc.nextLine();
            double diemToan = Double.parseDouble(sc.nextLine());
            double diemLy = Double.parseDouble(sc.nextLine());
            double diemHoa = Double.parseDouble(sc.nextLine());
            a[i] = new J07052(maTS, chuanHoa(hoTen), diemToan * 2 + diemLy + diemHoa);
            a[i].setDiemUuTien();
            a[i].setTongDiem();
        }

        int x = Integer.parseInt(sc.nextLine());
        Arrays.sort(a, new Comparator<J07052>() {
            @Override
            public int compare(J07052 t, J07052 t1) {
                return Double.compare(t1.tongDiem, t.tongDiem);
            }
        });

        for (int i = 0; i < n; i++) {
            x--;
            if (x == 0) {
                diemChuan = a[i].tongDiem;
                break;
            }
        }

        System.out.println(String.format("%.1f", diemChuan));
        for (int i = 0; i < n; i++) {
            a[i].setTrangThai();
            System.out.println(a[i]);
        }
    }
}
