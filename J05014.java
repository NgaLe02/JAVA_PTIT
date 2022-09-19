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
public class J05014 {
    private String ma, hoTen, maXT, monHoc, ketQua;
    private double diemTH, diemCM, tongDiem;

    public J05014(int ma, String hoTen, String maXT, double diemTH, double diemCM) {
        this.ma = "GV" + String.format("%02d", ma);
        this.hoTen = hoTen;
        this.maXT = maXT;
        this.diemTH = diemTH;
        this.diemCM = diemCM;
    }

    public void setMonHoc() {
        if(maXT.startsWith("A")) {
            this.monHoc = "TOAN";
        }
        else if(maXT.startsWith("B")) {
            this.monHoc = "LY";
        }
        else if(maXT.startsWith("C")) {
            this.monHoc = "HOA";
        }
    }

    public void setKetQua() {
        if(tongDiem < 18) {
            this.ketQua = "LOAI";
        }
        else {
            this.ketQua = "TRUNG TUYEN";
        }
    }

    public void setTongDiem() {
        double diemUuTien = 0;
        if(maXT.endsWith("1")) {
            diemUuTien = 2;
        }
        else if(maXT.endsWith("2")) {
            diemUuTien = 1.5;
        }
        else if(maXT.endsWith("3")) {
            diemUuTien = 1;
        }
        else if(maXT.endsWith("4")) {
            diemUuTien = 0;
        }
        this.tongDiem = diemTH * 2 + diemCM + diemUuTien;
    }

    
    @Override
    public String toString() {
        return ma + " " + hoTen + " " + monHoc + " " + String.format("%.1f",tongDiem) + " " + ketQua;
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05014[] a = new J05014[n];
        for(int i = 0; i < n; i++) {
            String hoTen = sc.nextLine();
            String maXT = sc.nextLine();
            double diemTH = sc.nextDouble();
            double diemCM = sc.nextDouble();
            sc.nextLine();
            a[i] =  new J05014(i + 1, hoTen, maXT, diemTH, diemCM);
            a[i].setMonHoc();
            a[i].setTongDiem();
            a[i].setKetQua();
        }
        
        Arrays.sort(a, new Comparator<J05014>(){
            @Override
            public int compare(J05014 t, J05014 t1) {
                return  Double.compare(t1.tongDiem, t.tongDiem);
            }
        });
        
        for(int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
