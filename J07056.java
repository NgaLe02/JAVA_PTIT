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
public class J07056 implements Comparable<J07056> {

    private String maKH, ten, loaiHGD;
    private int chiSoDau, chiSoCuoi, dinhMuc, thue;
    private int tienTrongDM, tienVuotDM, tongTien;

    public J07056(int maKH, String ten, String loaiHGD, int chiSoDau, int chiSoCuoi) {
        this.maKH = String.format("KH%02d", maKH);
        this.ten = ten;
        this.loaiHGD = loaiHGD;
        this.chiSoDau = chiSoDau;
        this.chiSoCuoi = chiSoCuoi;
    }

    public void setDinhMuc() {
        if (loaiHGD.equals("A")) {
            this.dinhMuc = 100;
        } else if (loaiHGD.equals("B")) {
            this.dinhMuc = 500;
        } else if (loaiHGD.equals("C")) {
            this.dinhMuc = 200;
        }
    }

    public void setTienTrongDM() {
        int x = chiSoCuoi - chiSoDau;
        if (x < dinhMuc) {
            this.tienTrongDM = x * 450;
        } else if (x > dinhMuc) {
            this.tienTrongDM = dinhMuc * 450;
        }
    }

    public void setTienVuotDM() {
        int x = chiSoCuoi - chiSoDau;
        if (x > dinhMuc) {
            this.tienVuotDM = (x - dinhMuc) * 1000;
        } else {
            this.tienVuotDM = 0;
        }
    }

    public void setThue() {
        this.thue = (int) tienVuotDM / 20;
    }

    public void setTongTien() {
        this.tongTien = tienTrongDM + tienVuotDM + thue;
    }

    @Override
    public String toString() {
        return maKH + " " + ten + " " + tienTrongDM + " " + tienVuotDM + " " + thue + " " + tongTien;
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
        Scanner sc = new Scanner(new File("D:\\KHACHHANG.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<J07056> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String ten = sc.nextLine();
            String s = sc.nextLine();
            String[] t = s.split("\\s+");
            String loaiHGD = t[0];
            int chiSoDau = Integer.parseInt(t[1]);
            int chiSoCuoi = Integer.parseInt(t[2]);
            a.add(new J07056(i + 1, chuanHoa(ten), loaiHGD, chiSoDau, chiSoCuoi));
            a.get(i).setDinhMuc();
            a.get(i).setTienTrongDM();
            a.get(i).setTienVuotDM();
            a.get(i).setThue();
            a.get(i).setTongTien();
        }

        Collections.sort(a);

        for (J07056 x : a) {
            System.out.println(x);
        }
    }

    @Override
    public int compareTo(J07056 t) {
        return t.tongTien - tongTien;
    }
}
