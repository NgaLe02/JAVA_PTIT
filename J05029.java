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
public class J05029 {

    private String ma, ten;
    private int soSv;

    public J05029(String ma, String ten, int soSv) {
        this.ma = ma;
        this.ten = ten;
        this.soSv = soSv;
    }

    public int getSoSv() {
        return soSv;
    }

    public String getMa() {
        return ma;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + soSv;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05029[] a = new J05029[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05029(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()));
        }

        Arrays.sort(a, new Comparator<J05029>() {
            @Override
            public int compare(J05029 t, J05029 t1) {
                if (t.getSoSv() != t1.getSoSv()) {
                    return t1.getSoSv() - t.getSoSv();
                }
                return t.getMa().compareTo(t1.getMa());
            }
        });

        int t = sc.nextInt();
        while(t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println("DANH SACH DOANH NGHIEP NHAN TU " + x + " DEN " + y + " SINH VIEN:");
            for(int i = 0; i < n; i++) {
                if(a[i].getSoSv() >= x && a[i].getSoSv() <= y) {
                    System.out.println(a[i]);
                }
            }
        }
    }
}
