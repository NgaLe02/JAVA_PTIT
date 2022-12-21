/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VaoRaFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
class LoaiPhong {

    String kyHieu, ten;
    double donGiaNgay, phiPhucvu;

    public LoaiPhong(String kyHieu, String ten, double donGiaNgay, double phiPhucvu) {
        this.kyHieu = kyHieu;
        this.ten = ten;
        this.donGiaNgay = donGiaNgay;
        this.phiPhucvu = phiPhucvu;
    }

}

class KH implements Comparable<KH> {

    String ma, ten, ngayDen, ngayDi, maPhong;
    LoaiPhong lp;
    long soNgayO;
    double tongTien;
    Date den = null, di = null;
    SimpleDateFormat date = new SimpleDateFormat("dd/mm/yyyy");

    public KH(int ma, String ten, String maPhong, String ngayDen, String ngayDi, LoaiPhong lp) throws ParseException {
        this.ma = String.format("KH%02d", ma);
        this.ten = ten;
        this.maPhong = maPhong;
        this.ngayDen = ngayDen;
        this.ngayDi = ngayDi;
        this.den = date.parse(ngayDen);
        this.di = date.parse(ngayDi);
        this.lp = lp;
    }

    public void setSoNgayO() {
        this.soNgayO = (long) (di.getTime() - den.getTime()) / (1000 * 60 * 60 * 24);
    }

    public void setTongTien() {
        double x = 0;
        if (soNgayO > 0) {
            x = lp.donGiaNgay * soNgayO;
        } else if (soNgayO == 0) {
            x = lp.donGiaNgay;
        }
        x += lp.phiPhucvu * x;
        if (soNgayO >= 10 && soNgayO < 20) {
            x -= x * 0.02;
        } else if (soNgayO >= 20 && soNgayO < 30) {
            x -= x * 0.04;
        } else if (soNgayO >= 30) {
            x -= x * 0.06;
        }
        this.tongTien = x;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + maPhong + " " + soNgayO + " " + String.format("%.2f", tongTien);
    }

    @Override
    public int compareTo(KH t) {
        return Long.compare(t.soNgayO, soNgayO);
    }

}

public class QuanLyKhachSan {

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("src/VaoRaFile/DATA.in"));
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<LoaiPhong> lp = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            String x = sc.nextLine().trim();
            String[] s = x.split("\\s+");
            lp.add(new LoaiPhong(s[0], s[1], Double.parseDouble(s[2]), Double.parseDouble(s[3])));
        }

        t = Integer.parseInt(sc.nextLine());
        ArrayList<KH> kh = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            String ten = sc.nextLine().trim();
            String maPhong = sc.nextLine().trim();
            String ngayDen = sc.nextLine().trim();
            String ngayDi = sc.nextLine().trim();
            for (LoaiPhong x : lp) {
                if (x.kyHieu.equals(String.valueOf(maPhong.charAt(2)))) {
                    kh.add(new KH(i + 1, ten, maPhong, ngayDen, ngayDi, x));
                    break;
                }
            }

        }
        for (KH x : kh) {
            x.setSoNgayO();
            x.setTongTien();
        }
        Collections.sort(kh);
        for (KH x : kh) {
            System.out.println(x);
        }
    }
}
