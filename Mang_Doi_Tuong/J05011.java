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
public class J05011 {

    private String ma, ten, gioVao, gioRa;
    private String time;
    private int thoiGian;

    public J05011(String ma, String ten, String gioVao, String gioRa) {
        this.ma = ma;
        this.ten = ten;
        this.gioVao = gioVao;
        this.gioRa = gioRa;
    }

    public void setTime() {
        int gio = thoiGian / 60;
        int phut = thoiGian % 60;
        this.time = (gio + "") + " gio " + (phut + "") + " phut";
    }

    public void setThoiGian() {
        String[] times = gioVao.split(":");
        int gio = Integer.parseInt(times[0]);
        int phut = Integer.parseInt(times[1]);
        String[] times1 = gioRa.split(":");
        int gio1 = Integer.parseInt(times1[0]);
        int phut1 = Integer.parseInt(times1[1]);
        this.thoiGian = (gio1 * 60 + phut1) - (gio * 60 + phut);
    }

    public int getThoiGian() {
        return thoiGian;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + time;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05011[] a = new J05011[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05011(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            a[i].setThoiGian();
            a[i].setTime();
        }

        Arrays.sort(a, new Comparator<J05011>() {
            @Override
            public int compare(J05011 t, J05011 t1) {
                return t1.getThoiGian() - t.getThoiGian();
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
