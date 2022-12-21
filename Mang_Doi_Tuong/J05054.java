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
public class J05054 implements Comparable<J05054> {

    String ma, ten, xepLoai;
    float diem;
    int xepHang;

    public J05054(int ma, String ten, float diem) {
        this.ma = String.format("HS%02d", ma);
        this.ten = ten;
        this.diem = diem;
        if (diem < 5) {
            xepLoai = "Yeu";
        } else if (diem < 7) {
            xepLoai = "Trung Binh";
        } else if (diem < 9) {
            xepLoai = "Kha";
        } else {
            xepLoai = "Gioi";
        }
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + String.format("%.1f", diem) + " " + xepLoai + " " + xepHang;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<J05054> a = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            a.add(new J05054(i + 1, sc.nextLine(), Float.parseFloat(sc.nextLine())));
        }

        Collections.sort(a);

        a.get(0).xepHang = 1;
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i).diem == a.get(i - 1).diem) {
                a.get(i).xepHang = a.get(i - 1).xepHang;
            } else {
                a.get(i).xepHang = i + 1;
            }
        }

        Collections.sort(a, new Comparator<J05054>() {
            @Override
            public int compare(J05054 t, J05054 t1) {
                return t.ma.compareTo(t1.ma);
            }
        });

        for (J05054 x : a) {
            System.out.println(x);
        }

    }

    @Override
    public int compareTo(J05054 t) {
        return Float.compare(t.diem, diem);
    }
}
