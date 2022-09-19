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
public class J07048 {

    private String ma, ten;
    private int giaBan, thoiHan;

    public J07048(String ma, String ten, int giaBan, int thoiHan) {
        this.ma = ma;
        this.ten = ten;
        this.giaBan = giaBan;
        this.thoiHan = thoiHan;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + giaBan + " " + thoiHan;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SANPHAM.in"));
        int n = Integer.parseInt(sc.nextLine());
        J07048[] a = new J07048[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J07048(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
        }

        Arrays.sort(a, new Comparator<J07048>() {
            @Override
            public int compare(J07048 t, J07048 t1) {
                if (t.giaBan != t1.giaBan) {
                    return t1.giaBan - t.giaBan;
                }
                return t.ma.compareTo(t1.ma);
            }
        });
        
        for(J07048 x : a) {
            System.out.println(x);
        }
    }
}
