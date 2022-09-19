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
public class J07074 {

    public static class MonHoc {

        private String maMon, tenMon, soTC;

        public MonHoc(String maMon, String tenMon, String soTC) {
            this.maMon = maMon;
            this.tenMon = tenMon;
            this.soTC = soTC;
        }
    }

    public static class LichGD implements Comparable<LichGD> {

        private String maNhom, maMon, thu, kip, hoTen, phongHoc;

        public LichGD(int ma, String maMon, String thu, String kip, String hoTen, String phongHoc) {
            this.maNhom = String.format("HP%03d", ma);
            this.maMon = maMon;
            this.thu = thu;
            this.kip = kip;
            this.hoTen = hoTen;
            this.phongHoc = phongHoc;
        }

        @Override
        public String toString() {
            return maNhom + " " + thu + " " + kip + " " + hoTen + " " + phongHoc;
        }

        @Override
        public int compareTo(LichGD t) {
            if (!thu.equals(t.thu)) {
                return thu.compareTo(t.thu);
            }
            if (!kip.equals(t.kip)) {
                return kip.compareTo(t.kip);
            }
            return hoTen.compareTo(t.hoTen);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("MONHOC.in"));
        ArrayList<MonHoc> a = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            a.add(new MonHoc(sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }

        Scanner sc1 = new Scanner(new File("LICHGD.in"));
        ArrayList<LichGD> b = new ArrayList<>();
        int m = Integer.parseInt(sc1.nextLine());
        for (int i = 0; i < m; i++) {
            b.add(new LichGD(i + 1, sc1.nextLine(), sc1.nextLine(), sc1.nextLine(), sc1.nextLine(), sc1.nextLine()));
        }
        String find = sc1.nextLine();
        Collections.sort(b);
        
        for (LichGD x : b) {
            if (x.maMon.equals(find)) {
                for (MonHoc y : a) {
                    if (y.maMon.equals(find)) {
                        System.out.println("LICH GIANG DAY MON " + y.tenMon + ":");
                        break;
                    }
                }
                break;
            }
        }

        for (LichGD x : b) {
            if (x.maMon.equals(find)) {
                System.out.println(x);
            }
        }
    }
}
