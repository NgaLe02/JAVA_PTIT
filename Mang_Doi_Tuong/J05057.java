/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang_Doi_Tuong;

import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J05057 {
    private String maTS, hoTen, trangThai;
    private double diemUuTien, tongDiem;

    public J05057(String maTS, String hoTen, double tongDiem) {
        this.maTS = maTS;
        this.hoTen = hoTen;
        this.tongDiem = tongDiem;
    }

    public void setTrangThai( ) {
        if(tongDiem + diemUuTien >= 24) {
            this.trangThai = "TRUNG TUYEN";
        }
        else {
            this.trangThai = "TRUOT";
        }
    }

    public void setDiemUuTien( ) {
        if(maTS.startsWith("KV1")) {
            this.diemUuTien = 0.5;
        }
        else if (maTS.startsWith("KV2")) {
            this.diemUuTien = 1.0;
        }
        else if(maTS.startsWith("KV3")) {
            this.diemUuTien = 2.5;
        }
    }


    @Override
    public String toString() {
        String s = maTS + " " + hoTen + " ";
        if(diemUuTien == (int)diemUuTien) {
            s += (int)diemUuTien + " ";
        }
        else {
            String t = String.format("%1.1f", diemUuTien);
            s = s +  t + " ";
        }
        if(tongDiem == (int)tongDiem) {
            s += (int)tongDiem + " ";
        }
        else {
            String t = String.format("%1.1f", tongDiem);
            s = s + t + " ";
        }
        s += trangThai;
        return s;
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        J05057[] a = new J05057[n];
        for(int i = 0; i < n; i++) {
            sc.nextLine();
            String maTS = sc.nextLine();
            String hoTen = sc.nextLine();
            double diemToan = sc.nextFloat();
            double diemLy = sc.nextFloat();
            double diemHoa = sc.nextFloat();
            a[i] = new J05057(maTS, hoTen, diemToan * 2 + diemLy + diemHoa);
            a[i].setDiemUuTien();
            a[i].setTrangThai();
        }
        
        for(int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
