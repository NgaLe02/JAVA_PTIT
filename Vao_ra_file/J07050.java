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
public class J07050 {

    private String ma;
    private String ten, nhom;
    private float loiNhuan;

    public J07050(int ma, String ten, String nhom, float loiNhuan) {
        this.ma = String.format("MH%02d", ma);
        this.ten = ten;
        this.nhom = nhom;
        this.loiNhuan = loiNhuan;
    }

    public float getLoiNhuan() {
        return loiNhuan;
    }

    @Override
    public String toString() {
        return (ma + "") + " " + ten + " " + nhom + " " + String.format("%.2f", loiNhuan);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MATHANG.in"));
        int n = Integer.parseInt(sc.nextLine());
        J07050[] a = new J07050[n];
        for (int i = 0; i < n; i++) {
            String ten = sc.nextLine();
            String nhom = sc.nextLine();
            float mua = Float.parseFloat(sc.nextLine());
            float ban = Float.parseFloat(sc.nextLine());
            a[i] = new J07050(i + 1, ten, nhom, ban - mua);
        }

        Arrays.sort(a, new Comparator<J07050>() {
            @Override
            public int compare(J07050 t, J07050 t1) {
                return Float.compare(t1.loiNhuan, t.loiNhuan);
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
