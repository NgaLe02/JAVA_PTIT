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
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell E7440
 */
public class J07025 implements Comparable<J07025>{
    private String ma, ten, gioiTinh, ngaySinh, diaChi;
    
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public J07025(int ma, String ten, String gioiTinh, String ngaySinh, String diaChi) {
        this.ma = String.format("KH%03d", ma);
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + gioiTinh + " " + diaChi + " " + ngaySinh;
    }
    
    public static String chuanHoaTen(String s) {
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
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<J07025> a = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            a.add(new J07025(i + 1, chuanHoaTen(sc.nextLine()), sc.nextLine(), chuanHoaNgay(sc.nextLine()), sc.nextLine()));
        }
        
        Collections.sort(a);
        for(J07025 x : a) System.out.println(x);
    }

    @Override
    public int compareTo(J07025 t) {
        Date date1 = null, date2 = null;
        try {
            date1 = simpleDateFormat.parse(ngaySinh);
        } catch (ParseException ex) {
            Logger.getLogger(J07025.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            date2 = simpleDateFormat.parse(t.ngaySinh);
        } catch (ParseException ex) {
            Logger.getLogger(J07025.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date1.compareTo(date2);
    }
}
