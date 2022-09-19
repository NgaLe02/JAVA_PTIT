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
public class J05017 {

    private String maKH, tenKH;
    private int chisoCu, chisoMoi, tongTien;

    public J05017(int ma, String tenKH, int chisoCu, int chisoMoi) {
        this.maKH = String.format("KH%02d", ma);
        this.tenKH = tenKH;
        this.chisoCu = chisoCu;
        this.chisoMoi = chisoMoi;
    }

    public void setTongTien() {
        int x = chisoMoi - chisoCu;
        if (x <= 50) {
            this.tongTien = (int) Math.round(x * 100 * 1.02);
        }
        else if (x <= 100) {
            this.tongTien = (int) Math.round((50 * 100 + (x - 50) * 150) * 1.03);
        }
        else if (x > 100) {
            this.tongTien = (int) Math.round((50 * 100 + 50 * 150 + (x - 100) * 200) * 1.05);
        }
    }

    @Override
    public String toString() {
        return maKH + " " + tenKH + " " + tongTien;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05017[] a = new J05017[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05017(i + 1, sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
            a[i].setTongTien();
        }

        Arrays.sort(a, new Comparator<J05017>() {
            @Override
            public int compare(J05017 t, J05017 t1) {
                return t1.tongTien - t.tongTien;
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
