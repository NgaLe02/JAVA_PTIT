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
public class J07037 {

    private String ma, ten;
    private int soSv;

    public J07037(String ma, String ten, int soSv) {
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

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DN.in"));
        int n = Integer.parseInt(sc.nextLine());
        J07037[] a = new J07037[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J07037(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()));
        }

        Arrays.sort(a, new Comparator<J07037>() {
            @Override
            public int compare(J07037 t, J07037 t1) {
                return t.getMa().compareTo(t1.getMa());
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}