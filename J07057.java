/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J07057 implements Comparable<J07057> {

    private String ma, ten, danToc, trangThai;
    private double diem;
    private int khuVuc;

    public J07057() {
    }

    public J07057(int ma, String ten, double diem, String danToc, int khuVuc) {
        this.ma = String.format("TS%02d", ma);
        this.ten = ten;
        this.danToc = danToc;
        this.diem = diem;
        this.khuVuc = khuVuc;
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

    public void setTrangThai() {
        if (diem < 20.5) {
            this.trangThai = "Truot";
        } else {
            this.trangThai = "Do";
        }
    }

    public void setDiem() {
        if (khuVuc == 1) {
            this.diem += 1.5;
        } else if (khuVuc == 2) {
            this.diem += 1;
        }
        if (!danToc.equals("Kinh")) {
            this.diem += 1.5;
        }
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + String.format("%.1f", diem) + " " + trangThai;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("THISINH.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<J07057> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(new J07057(i + 1, chuanHoa(sc.nextLine()), Double.parseDouble(sc.nextLine()), sc.nextLine(), Integer.parseInt(sc.nextLine())));
            a.get(i).setDiem();
            a.get(i).setTrangThai();
        }
        Collections.sort(a);
        for (J07057 x : a) {
            System.out.println(x);
        }
    }

    @Override
    public int compareTo(J07057 t) {
        if (t.diem != diem) {
            return Double.compare(t.diem, diem);
        }
        return ma.compareTo(t.ma);
    }
}
