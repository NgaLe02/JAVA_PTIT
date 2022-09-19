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
public class J05027 {

    private String ma, hoTen, ten, boMon;

    public J05027(int ma, String hoTen, String boMon) {
        this.ma = "GV" + String.format("%02d", ma);
        this.hoTen = hoTen;
        this.boMon = boMon;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getBoMon() {
        return boMon;
    }

    public String getHoTen() {
        return hoTen;
    }

    
    public void setBoMon() {
        String[] words = boMon.split("\\s+");
        String s = "";
        for (String x : words) {
            s += String.valueOf(x.charAt(0)).toUpperCase();
        }
        this.boMon = s.toString();
    }

    @Override
    public String toString() {
        return ma + " " + hoTen + " " + boMon;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05027[] a = new J05027[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05027(i + 1, sc.nextLine(), sc.nextLine());
            a[i].setBoMon();
        }

        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            System.out.println("DANH SACH GIANG VIEN THEO TU KHOA " + s + ":");
            for (int i = 0; i < n; i++) {
                String tmp = a[i].getHoTen();
                tmp = tmp.toLowerCase();
                s = s.toLowerCase();
                if(tmp.contains(s)) {
                    System.out.println(a[i]);
                }
            }
        }
    }
}
