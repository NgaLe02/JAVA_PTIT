/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VaoRaFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author tuanv
 */
class MonHoc {

    private String maMon, tenMon;
    private int soTinChi;

    public MonHoc(String maMon, String tenMon, int soTinChi) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.soTinChi = soTinChi;
    }

    public String getMaMon() {
        return maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

}

class LichGD {

    private String maHP, thu, kip, hoTen, phongHoc;
    MonHoc m;

    public LichGD(int maHP, MonHoc m, String thu, String kip, String hoTen, String phongHoc) {
        this.maHP = String.format("HP%03d", maHP);
        this.m = m;
        this.thu = thu;
        this.kip = kip;
        this.hoTen = hoTen;
        this.phongHoc = phongHoc;
    }

    public MonHoc getM() {
        return m;
    }

    public String getThu() {
        return thu;
    }

    public String getKip() {
        return kip;
    }

    public String getHoTen() {
        return hoTen;
    }

    @Override
    public String toString() {
        return this.maHP + " " + thu + " " + kip + " " + hoTen + " " + phongHoc;
    }

}

public class J07074 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/VaoRaFile/MONHOC.in"));

        ArrayList<MonHoc> l1 = new ArrayList<>();

        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            l1.add(new MonHoc(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine())));
        }

        sc = new Scanner(new File("src/VaoRaFile/LICHGD.in"));

        ArrayList<LichGD> l2 = new ArrayList<>();

        int t1 = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t1; i++) {
            String ma = sc.nextLine();
            String thu = sc.nextLine();
            String kip = sc.nextLine();
            String hoTen = sc.nextLine();
            String phongHoc = sc.nextLine();
            for (MonHoc x : l1) {
                if (x.getMaMon().equals(ma)) {
                    l2.add(new LichGD(i + 1, x, thu, kip, hoTen, phongHoc));
                }
            }
        }
        //nhap ma mon hoc
        String s = sc.nextLine();
        String res = "";
        for (MonHoc x : l1) {
            if (x.getMaMon().equals(s)) {
                res = x.getTenMon();
            }
        }

        Collections.sort(l2, new Comparator<LichGD>() {
            @Override
            public int compare(LichGD o1, LichGD o2) {
                if (o1.getThu() != o2.getThu()) {
                    return o1.getThu().compareTo(o2.getThu());
                } else if (o1.getKip() != o2.getKip()) {
                    return o1.getKip().compareTo(o2.getKip());
                } else {
                    return o1.getHoTen().compareTo(o2.getHoTen());
                }
            }

        });

        System.out.println("LICH GIANG DAY MON " + res + ":");
        for (LichGD x : l2) {
            if (x.getM().getMaMon().equals(s)) {
                System.out.println(x);
            }
        }
    }
}