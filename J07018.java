/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J07018 {

    private String maSV, ten, lop, ngaySinh;
    private double diem;

    public J07018(int maSV, String ten, String lop, String ngaySinh, double diem) {
        this.maSV = String.format("B20DCCN%03d", maSV);
        this.ten = ten;
        this.lop = lop;
        this.ngaySinh = ngaySinh;
        this.diem = diem;
    }


    @Override
    public String toString() {
        return maSV + " " + ten + " " + lop + " " + ngaySinh + " " + String.format("%.2f", diem);
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
    
    public static String chuanHoaNgay(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(1) == '/') sb.insert(0, '0');
        if(sb.charAt(4) == '/') sb.insert(3, '0');
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("D:\\SINHVIEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<J07018> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(new J07018(i + 1, chuanHoa(sc.nextLine()), sc.nextLine(), chuanHoaNgay(sc.nextLine()), Double.parseDouble(sc.nextLine())));
        }

        for (J07018 x : a) {
            System.out.println(x);
        }
    }
}
