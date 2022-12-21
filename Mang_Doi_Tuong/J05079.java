/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MangDoiTuong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J05079 implements Comparable<J05079> {

    String ma, ten, nhom, gv;

    public J05079(String ma, String ten, String nhom, String gv) {
        this.ma = ma;
        this.ten = ten;
        this.nhom = nhom;
        this.gv = gv;
    }

    @Override
    public String toString() {
        return nhom + " " + gv;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<J05079> a = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            a.add(new J05079(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        //Collections.sort(a);
        Collections.sort(a, new Comparator<J05079>() {
            @Override
            public int compare(J05079 t, J05079 t1) {
                return t.nhom.compareTo(t1.nhom);
            }
        });
        
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            for (J05079 x : a) {
                if (x.ma.equals(s)) {
                    System.out.println("Danh sach nhom lop mon " + x.ten + ":");
                    break;
                }
            }
            for (J05079 x : a) {
                if (x.ma.equals(s)) {
                    System.out.println(x);
                }
            }
        }
    }

    @Override
    public int compareTo(J05079 t) {
        return nhom.compareTo(t.nhom);
    }
}
