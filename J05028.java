/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang_Doi_Tuong;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J05028 {

    private String ma, ten;
    private int soSv;

    public J05028(String ma, String ten, int soSv) {
        this.ma = ma;
        this.ten = ten;
        this.soSv = soSv;
    }

    public int getSoSv() {
        return soSv;
    }

    public String getMa() {
        return ma;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + soSv;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05028[] a = new J05028[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05028(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()));
        }

        Arrays.sort(a, new Comparator<J05028>() {
            @Override
            public int compare(J05028 t, J05028 t1) {
                if (t.getSoSv() != t1.getSoSv()) {
                    return t1.getSoSv() - t.getSoSv();
                }
                return t.getMa().compareTo(t1.getMa());
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
