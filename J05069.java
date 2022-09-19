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
public class J05069 {

    private String ma, ten;
    private int giaVe;

    public J05069(String ma, String ten, int giaVe) {
        this.ma = ma;
        this.ten = ten;
        this.giaVe = giaVe;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public int getGiaVe() {
        return giaVe;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05069[] a = new J05069[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05069(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()));
        }

        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            String[] words = s.split("\\s+");
            String maTran = words[0];
            int soCDV = Integer.parseInt(words[1]);
            String tenDoi = "";
            int giaVe = 0;
            for (int i = 0; i < n; i++) {
                if (maTran.subSequence(1, 3).equals(a[i].getMa())) {
                    tenDoi = a[i].getTen();
                    giaVe = a[i].getGiaVe();
                    break;
                }
            }
            int doanhThu = giaVe * soCDV;
            System.out.println(maTran + " " + tenDoi + " " + doanhThu + "");
        }
    }
}
