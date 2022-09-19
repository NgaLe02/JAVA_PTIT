/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J07019 {

    static ArrayList<SanPham> a = new ArrayList<>();
    static ArrayList<HoaDon> b = new ArrayList<>();

    public static class SanPham {

        private String ma, ten;
        private int giaLoai1, giaLoai2;

        public SanPham(String ma, String ten, int giaLoai1, int giaLoai2) {
            this.ma = ma;
            this.ten = ten;
            this.giaLoai1 = giaLoai1;
            this.giaLoai2 = giaLoai2;
        }
    }

    public static class HoaDon {

        private String maHoaDon, tenSP;
        private int soLuongMua, giaBan;

        public HoaDon(int ma, String maHoaDon, int soLuongMua) {
            this.maHoaDon = String.format(maHoaDon + "-%03d", ma);
            this.soLuongMua = soLuongMua;
        }

        public void set() {
            String t = maHoaDon.substring(0, 2);
            Character tmp = maHoaDon.charAt(2);
            for (SanPham x : a) {
                if (x.ma.equals(t)) {
                    this.tenSP = x.ten;
                    if (tmp == '1') {
                        this.giaBan = x.giaLoai1;
                    } else {
                        this.giaBan = x.giaLoai2;
                    }
                }
            }
        }

        public int getSoTienGiamGia() {
            if (soLuongMua >= 150) {
                return (int) soLuongMua * giaBan / 2;
            } else if (soLuongMua >= 100) {
                return (int) soLuongMua * giaBan * 3 / 10;
            } else if (soLuongMua >= 50) {
                return (int) soLuongMua * giaBan * 15 / 100;
            }
            return 0;
        }

        public int getSoTienPhaiTra() {
            return soLuongMua * giaBan - getSoTienGiamGia();
        }

        @Override
        public String toString() {
            return maHoaDon + " " + tenSP + " " + getSoTienGiamGia() + " " + getSoTienPhaiTra();
        }

    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("DATA1.in"));
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            a.add(new SanPham(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine())));
        }

        Scanner sc1 = new Scanner(new File("DATA2.in"));
        int m = Integer.parseInt(sc1.nextLine());

        for (int i = 0; i < m; i++) {
            String s = sc1.nextLine();
            String[] t = s.split("\\s+");
            b.add(new HoaDon(i + 1, t[0], Integer.parseInt(t[1])));
            b.get(i).set();
        }

        for (HoaDon x : b) {
            System.out.println(x);
        }
    }
}
