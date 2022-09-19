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
public class J07034 {

    private String maMon, tenMon;
    private int soTinChi;

    public J07034(String maMon, String tenMon, int soTinChi) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.soTinChi = soTinChi;
    }

    @Override
    public String toString() {
        return maMon + " " + tenMon + " " + soTinChi;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int n = Integer.parseInt(sc.nextLine());
        J07034[] a = new J07034[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J07034(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()));
        }

        Arrays.sort(a, new Comparator<J07034>() {
            @Override
            public int compare(J07034 t, J07034 t1) {
                return t.tenMon.compareTo(t1.tenMon);
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
