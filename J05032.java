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
public class J05032 {

    private String name, date;
    private int day, month, year;

    public J05032(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public void setYear() {
        this.year = Integer.parseInt(date.substring(6));
    }

    public int getMonth() {
        return month;
    }

    public void setMonth() {
        this.month = Integer.parseInt(date.substring(3, 5));
    }

    public int getDay() {
        return day;
    }

    public void setDay() {
        this.day = Integer.parseInt(date.substring(0, 2));

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05032[] a = new J05032[n];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] w = s.split("\\s+");
            a[i] = new J05032(w[0], w[1]);
            a[i].setDay();
            a[i].setMonth();
            a[i].setYear();
        }

        Arrays.sort(a, new Comparator<J05032>() {
            @Override
            public int compare(J05032 t, J05032 t1) {
                if (t.getYear() != t1.getYear()) {
                    return t.getYear() - t1.getYear();
                }
                if (t.getMonth() != t1.getMonth()) {
                    return t.getMonth() - t1.getMonth();
                }
                return t.getDay() - t1.getDay();
            }
        });
        System.out.println(a[n - 1].getName());
        System.out.println(a[0].getName());
    }
}
