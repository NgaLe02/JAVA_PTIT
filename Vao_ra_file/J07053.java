/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J07053 {
    private String maTT, hoTen, xepLoai;
    private int tuoi, diemTB;
    private double diemThuong;
    

    public J07053(int maTT, String hoTen) {
        this.maTT = "PH" + String.format("%02d", maTT);
        this.hoTen = hoTen;
    }

    public void setXepLoai( ) {
        if(diemTB < 5) {
            this.xepLoai = "Truot";
        }
        else if(diemTB <= 6) {
            this.xepLoai = "Trung binh";
        }
        else if(diemTB == 7) {
            this.xepLoai = "Kha";
        }
        else if(diemTB == 8) {
            this.xepLoai = "Gioi";
        }
        else if(diemTB == 9 || diemTB == 10) {
            this.xepLoai = "Xuat sac";
        }
    }

    public void setTuoi(String ngaySinh) {
        String[] word = ngaySinh.split("/");
        this.tuoi = 2021 - Integer.parseInt(word[2]);
    }

    public void setDiemTB(double diemLT, double diemTH ) {
        double x = 0;
        x = (diemLT + diemTH) / 2 + diemThuong;
        if(x > 10) x = 10;
        this.diemTB = (int) Math.round(x);
    }

    public void setDiemThuong(double diemLT, double diemTH) {
        if(diemLT >= 8 && diemTH >= 8) {
            this.diemThuong = 1;
        }
        else if(diemLT >= 7.5 && diemTH >= 7.5) {
            this.diemThuong = 0.5;
        }
        else this.diemThuong = 0;
    }

    @Override
    public String toString() {
        return maTT + " " + hoTen + " " + tuoi + " " + diemTB + " " + xepLoai;
    }
    
    public static String chuanHoa(String s) {
        s = s.trim().toLowerCase();
        String[] words = s.split("\\s+");
        s = "";
        for (String x : words) {
            s += String.valueOf(x.charAt(0)).toUpperCase() + x.substring(1);
            s += " ";
        }
        return s.trim();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("XETTUYEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        J07053[] a = new J07053[n];
        for(int i = 0; i < n; i++) {
            String hoTen = sc.nextLine();
            String ngaySinh = sc.nextLine();
            double diemLT = Double.parseDouble(sc.nextLine());
            double diemTH = Double.parseDouble(sc.nextLine());
            a[i] = new J07053(i + 1, chuanHoa(hoTen));
            a[i].setTuoi(ngaySinh);
            a[i].setDiemThuong(diemLT, diemTH);
            a[i].setDiemTB(diemLT, diemTH);
            a[i].setXepLoai();
        }
        
        for(int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
