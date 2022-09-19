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
public class J07073 implements Comparable<J07073> {

    private String maMon, tenMon, hinhThucHocLT, hinhThucHocTH;
    private int soTinChi;

    public J07073(String maMon, String tenMon, int soTinChi, String hinhThucHocLT, String hinhThucHocTH) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.soTinChi = soTinChi;
        this.hinhThucHocLT = hinhThucHocLT;
        this.hinhThucHocTH = hinhThucHocTH;
    }

    @Override
    public String toString() {
        return maMon + " " + tenMon + " " + soTinChi + " " + hinhThucHocLT + " " + hinhThucHocTH;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<J07073> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String maMon = sc.nextLine();
            String tenMon = sc.nextLine();
            int sTC = Integer.parseInt(sc.nextLine());
            String x = sc.nextLine();
            String y = sc.nextLine();
            if (y.equals("Truc tuyen") || y.endsWith(".ptit.edu.vn")) {
                a.add(new J07073(maMon, tenMon, sTC, x, y));
            }
        }

        Collections.sort(a);

        for (J07073 x : a) {
            System.out.println(x);
        }
    }

    @Override
    public int compareTo(J07073 t) {
        return maMon.compareTo(t.maMon);
    }
}
