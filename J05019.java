/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang_Doi_Tuong;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Dell E7440
 */
public class J05019 {

    private String maTD, tenTram, thoiDiemBatDauMua, thoiDiemKetThucMua;
    private double luongMua, luongMuaTB;
    private int thoiGian;

    static TreeSet<String> se = new TreeSet<>();

    public J05019(int x, String tenTram, String thoiDiemBatDauMua, String thoiDiemKetThucMua, double luongMua) {
        this.maTD = String.format("T%02d", x);
        this.tenTram = tenTram;
        this.thoiDiemBatDauMua = thoiDiemBatDauMua;
        this.thoiDiemKetThucMua = thoiDiemKetThucMua;
        this.luongMua = luongMua;
    }

    public void setThoiGian(String thoiDiemBatDauMua, String thoiDiemKetThucMua) {
        String[] t = thoiDiemBatDauMua.split(":");
        String[] t1 = thoiDiemKetThucMua.split(":");
        this.thoiGian += (Integer.parseInt(t1[0]) * 60 + Integer.parseInt(t1[1])) - (Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]));
    }

    public void setLuongMua(double luongMua) {
        this.luongMua += luongMua;
    }

    public void setLuongMuaTB() {
        double t = (double) thoiGian / 60;
        this.luongMuaTB = (double) luongMua / t;
    }

    @Override
    public String toString() {
        return maTD + " " + tenTram + " " + String.format("%.2f", luongMuaTB);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<J05019> a = new ArrayList<J05019>();
        for (int i = 0; i < n; i++) {
            String tenTram = sc.nextLine();
            String t1 = sc.nextLine();
            String t2 = sc.nextLine();
            double luongMua = Double.parseDouble(sc.nextLine());
            if (!se.contains(tenTram)) {
                se.add(tenTram);
                a.add(new J05019(i + 1, tenTram, t1, t2, luongMua));
                a.get(a.size() - 1).setThoiGian(t1, t2);
            } else {
                for (J05019 x : a) {
                    if (x.tenTram.endsWith(tenTram)) {
                        x.setThoiGian(t1, t2);
                        x.setLuongMua(luongMua);
                    }
                }
            }
        }

//        for(J05019 x : a){
//            System.out.println(x.thoiGian);
//        }
        
//        for(J05019 x : a){
//            System.out.println(x.luongMua);
//        }
//        
        for (J05019 x : a) {
            x.setLuongMuaTB();
            System.out.println(x);
        }
    }
}
