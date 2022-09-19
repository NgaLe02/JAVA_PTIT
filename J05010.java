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
public class J05010 {

    private int ma;
    private String ten, nhom;
    private float loiNhuan;

    public J05010(int ma, String ten, String nhom, float loiNhuan) {
        this.ma = ma;
        this.ten = ten;
        this.nhom = nhom;
        this.loiNhuan = loiNhuan;
    }

    public float getLoiNhuan() {
        return loiNhuan;
    }

    @Override
    public String toString() {
        return (ma + "") + " " + ten + " " + nhom + " " + String.format("%.2f",loiNhuan);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        J05010[] a = new J05010[n];
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String ten = sc.nextLine();
            String nhom = sc.nextLine();
            float mua = sc.nextFloat();
            float ban = sc.nextFloat();
            a[i] = new J05010(i + 1, ten, nhom, ban - mua);
        }

        Arrays.sort(a, new Comparator<J05010>() {
            @Override
            public int compare(J05010 t, J05010 t1) {
                return Float.compare(t1.loiNhuan, t.loiNhuan);
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
