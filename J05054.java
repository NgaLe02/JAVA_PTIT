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
public class J05054 {
    private String maHS, hoTen, xepLoai;
    private float gpa;
    private int xepHang;
    
    static int thuTu = 0;
    static int soHocSinh = 0;
    static float gpaXepHang = 0;

    public J05054(int maHS, String hoTen, float gpa) {
        this.maHS = "HS" + String.format("%02d", maHS);
        this.hoTen = hoTen;
        this.gpa = gpa;
    }

    public void setXepLoai( ) {
        if(gpa < 5) this.xepLoai = "Yeu";
        else if(gpa < 7) this.xepLoai = "Trung Binh";
        else if(gpa < 9) this.xepLoai = "Kha";
        else this.xepLoai = "Gioi";
    }

    public void setXepHang( ) {
        if(gpa != gpaXepHang) {
            this.xepHang  = soHocSinh + 1;
            gpaXepHang = gpa;
            thuTu = soHocSinh;
            soHocSinh ++;
        }
        else {
            this.xepHang = thuTu + 1;
            soHocSinh ++;
        }
    }

    public float getGpa() {
        return gpa;
    }

    public String getMaHS() {
        return maHS;
    }

    
    @Override
    public String toString() {
        return maHS + " " + hoTen + " " + gpa + " " + xepLoai + " " + xepHang;
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05054[] a = new J05054[n];
        for(int i = 0; i < n; i++) {
            a[i] = new J05054(i + 1, sc.nextLine(), Float.parseFloat(sc.nextLine()));
            a[i].setXepLoai();
        }
        
        Arrays.sort(a, new Comparator<J05054>() {
            @Override
            public int compare(J05054 t, J05054 t1) {       
                return Float.compare(t1.getGpa(), t.getGpa());
            }
        });
       
        for(int i = 0; i < n; i++) {
             a[i].setXepHang();
         }
        
        Arrays.sort(a, new Comparator<J05054>() {
            @Override
            public int compare(J05054 t, J05054 t1) {       
                return t.getMaHS().compareTo(t1.getMaHS());
            }
        });
        
         for(int i = 0; i < n; i++) {
             System.out.println(a[i]);
         }
    }
}
