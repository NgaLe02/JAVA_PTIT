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
public class J05026 {

    private String ma, hoTen, ten, boMon;

    public J05026(int ma, String hoTen, String boMon) {
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

    public void setTen() {
        String[] words = hoTen.split("\\s+");
        this.ten = words[words.length - 1].toString();
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
        J05026[] a = new J05026[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05026(i + 1, sc.nextLine(), sc.nextLine());
            a[i].setTen();
            a[i].setBoMon();
        }

        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            String[] words = s.split("\\s+");
            String res = "";
            for (String x : words) {
                res += String.valueOf(x.charAt(0)).toUpperCase();
            }
            System.out.println("DANH SACH GIANG VIEN BO MON " + res + ":");
            for (int i = 0; i < n; i++) {
                if (a[i].getBoMon().equals(res)) {
                    System.out.println(a[i]);
                }
            }
        }
    }
}
