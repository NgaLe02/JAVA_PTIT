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
public class J05030 {
    private String ma, ten, lop;
    private float diem1, diem2, diem3;

    public J05030(String ma, String ten, String lop, float diem1, float diem2, float diem3) {
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
    }

    public String getMa() {
        return ma;
    }

    
    @Override
    public String toString() {
        return ma + " " + ten + " " + lop + " " + String.format("%.1f", diem1)
                + " " + String.format("%.1f", diem2) + " " + String.format("%.1f", diem3);
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        J05030[] a = new J05030[n];
        for(int i = 0; i < n; i++) {
            sc.nextLine();
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String lop = sc.nextLine();
            float diem1 = sc.nextFloat();
            float diem2 = sc.nextFloat();
            float diem3 = sc.nextFloat();
            a[i] = new J05030(ma, ten, lop, diem1, diem2, diem3);
        }
        
        Arrays.sort(a, new Comparator<J05030>() {
            @Override
            public int compare(J05030 t, J05030 t1) {
                return t.getMa().compareTo(t1.getMa());
            }      
        });
        
        for(int i = 0; i < n; i++) {
            System.out.println((i + 1 + " ") + a[i]);
        }
    }
}
