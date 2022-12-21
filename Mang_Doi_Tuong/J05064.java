/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MangDoiTuong;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J05064 {

    String ma, ten;
    int luongCB;
    int bacLuong, phuCap, thuNhap;

    public J05064() {
    }

    static int HT = 0, HP = 0;

    public J05064(String ma, String ten, int luongCB) {
        this.ma = ma;
        this.ten = ten;
        this.luongCB = luongCB;
        bacLuong = Integer.parseInt(ma.substring(2));
        if(ma.startsWith("GV")) phuCap = 500000;
        else if(ma.startsWith("HP")) phuCap = 900000;
        else if(ma.startsWith("HT")) phuCap = 2000000;
        thuNhap = luongCB * bacLuong + phuCap;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + bacLuong + " " + phuCap + " " + thuNhap;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<J05064> a = new ArrayList<>();
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            int luong = Integer.parseInt(sc.nextLine());
            int ok = 1;
            if (ma.substring(0, 2).equals("HT")) {
                HT++;
                if (HT >= 2) {
                    ok = 0;
                }
            } else if (ma.substring(0, 2).equals("HP")) {
                HP++;
                if (HP >= 3) {
                    ok = 0;
                }
            }
            if (ok == 1) {
                a.add(new J05064(ma, ten, luong));
            }
            
        }
        for(J05064 x : a){
            System.out.println(x);
        }
    }
}
