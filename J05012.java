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
public class J05012 {

    private String maMH, tenMH;
    private long soLuongMua, donGia, tienChietKhau, tongTien;

    public J05012(String maMH, String tenMH, long soLuongMua, long donGia, long tienChietKhau) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.soLuongMua = soLuongMua;
        this.donGia = donGia;
        this.tienChietKhau = tienChietKhau;
    }

    public void setTongTien() {
        this.tongTien = donGia * soLuongMua - tienChietKhau;
    }

    @Override
    public String toString() {
        return maMH + " " + tenMH + " " + soLuongMua + " " + donGia + " " + tienChietKhau + " " + tongTien;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05012[] a = new J05012[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05012(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()));
            a[i].setTongTien();
        }

        Arrays.sort(a, new Comparator<J05012>() {
            @Override
            public int compare(J05012 t, J05012 t1) {
                return Long.compare(t1.tongTien, t.tongTien);
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
