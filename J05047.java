/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang_Doi_Tuong;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J05047 {
    
    private String ma, tenHang;
    private int tienChietKhau, thanhTien;

    static HashMap<String, Integer> pa = new HashMap<String, Integer>();

    public J05047() {
    }

    public J05047(String tenHang) {
        this.tenHang = tenHang;

    }

    public void setMa() {
        String[] words = tenHang.split("\\s+");
        String s = String.valueOf(words[0].charAt(0)).toUpperCase();
        s += String.valueOf(words[1].charAt(0)).toUpperCase();
        int mem = 0;
        if (pa.containsKey(s) == false) {
            mem = 1;
            pa.put(s, 1);
        } else {
            mem = pa.get(s) + 1;
            pa.put(s, mem);
        }
        s += String.format("%02d", mem);
        this.ma = s.toString();
    }

    public void setTienChietKhau(int soLuong, int donGia) {
        if (soLuong > 10) {
            this.tienChietKhau = donGia * soLuong / 20;
        } else if (soLuong >= 8) {
            this.tienChietKhau = donGia * soLuong / 50;
        } else if (soLuong >= 5) {
            this.tienChietKhau = donGia * soLuong / 100;

        } else {
            this.tienChietKhau = 0;
        }

    }

    public void setThanhTien(int soLuong, int donGia) {
        this.thanhTien = donGia * soLuong - this.tienChietKhau;
    }

    public int getTienChietKhau() {
        return tienChietKhau;
    }
    
    

    @Override
    public String toString() {
        return ma + " " + tenHang + " " + (tienChietKhau + "") + " " + (thanhTien + "");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        J05047[] a = new J05047[n];
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String ten = sc.nextLine();
            int soLuong = sc.nextInt();
            int donGia = sc.nextInt();
            a[i] = new J05047(ten);
            a[i].setTienChietKhau(soLuong, donGia);
            a[i].setThanhTien(soLuong, donGia);
            a[i].setMa();
        }
        
        Arrays.sort(a, new Comparator<J05047>() {
            @Override
            public int compare(J05047 t, J05047 t1) {
                return t1.getTienChietKhau() - t.getTienChietKhau();
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
