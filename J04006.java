/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Khai_bao_lop_va_doi_tuong;

import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J04006 {
    private String ID, name, lop, date;
    private float gpa;

    public J04006() {
        this.ID = "";
        this.name = "";
        this.lop = "";
        this.date = "";
        this.gpa = 0;
    }

    public J04006(String ID, String name, String lop, String date, float gpa) {
        this.ID = ID;
        this.name = name;
        this.lop = lop;
        this.date = date;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        String diem = String.format("%.2f", gpa);
        return ID + " " + name + " " + lop + " " + date + " " + diem;
    }
    
    public static String chuanHoaName(String s) {
        s = s.toLowerCase();
        String[] arr = s.split("\\s+");
        s = "";
        for (int i = 0; i < arr.length; i++) {
            s += String.valueOf(arr[i].charAt(0)).toUpperCase() + arr[i].substring(1);
            s += " ";
        }
        return s.toString();
    }
    
    public static String chuanHoaDate(String s) {
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(1) == '/') {
            sb.insert(0, "0");
        }
        if(sb.charAt(4) == '/') {
            sb.insert(3, "0");
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String lop = sc.nextLine();
        String date = sc.nextLine();
        float gpa = sc.nextFloat();
        J04006 sinhVien = new J04006("B20DCCN001",chuanHoaName(name), chuanHoaDate(lop), date, gpa);
        
        System.out.println(sinhVien.toString());
    }
}
