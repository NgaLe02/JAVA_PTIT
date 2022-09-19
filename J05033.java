package Mang_Doi_Tuong;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dell E7440
 */
public class J05033 {

    private int hour, minute, second;

    public J05033() {
    }

    public J05033(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }

    @Override
    public String toString() {
        return this.hour + " " + this.minute + " " + this.second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        J05033[] a = new J05033[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05033(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(a, new Comparator<J05033>() {
            @Override
            public int compare(J05033 t, J05033 t1) {
                if (t.getHour() != t1.getHour()) {
                    return t.getHour() - t1.getHour();
                }
                if (t.getMinute() != t1.getMinute()) {
                    return t.getMinute() - t1.getMinute();
                }
                return t.getSecond() - t1.getSecond();
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
