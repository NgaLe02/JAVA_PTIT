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
public class J05009 {

    private String name, date;
    private float gpa;
    private int ma;

    public J05009(int ma, String name, String date, float gpa) {
        this.ma = ma;
        this.name = name;
        this.date = date;
        this.gpa = gpa;
    }

    public float getGpa() {
        return gpa;
    }

    public int getMa() {
        return ma;
    }

    @Override
    public String toString() {
        return ma + " " + name + " " + date + " " + gpa;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        J05009[] a = new J05009[n];
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String ten = sc.nextLine();
            String date = sc.nextLine();
            float diem1 = sc.nextFloat();
            float diem2 = sc.nextFloat();
            float diem3 = sc.nextFloat();
            a[i] = new J05009(i + 1, ten, date, diem1 + diem2 + diem3);
        }

        Arrays.sort(a, new Comparator<J05009>() {
            @Override
            public int compare(J05009 t, J05009 t1) {
                if (t.getGpa() != t1.getGpa()) {
                    return Float.compare(t1.getGpa(), t.getGpa());
                }
                return t.getMa() - t1.getMa();
            }
        });
        float max = a[0].getGpa();
        for (int i = 0; i < n; i++) {
            if (a[i].getGpa() == max) {
                System.out.println(a[i]);
            } else {
                break;
            }
        }
    }
}
