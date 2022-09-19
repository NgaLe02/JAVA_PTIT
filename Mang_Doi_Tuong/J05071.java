/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang_Doi_Tuong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J05071 {

    static int n, m;
    static ArrayList<tinh> a = new ArrayList<>();
    static ArrayList<cuocGoi> b = new ArrayList<>();

    public static class tinh {

        private String maVung, tenTinh;
        private int giaCuoc;

        public tinh(String maVung, String tenTinh, int giaCuoc) {
            this.maVung = maVung;
            this.tenTinh = tenTinh;
            this.giaCuoc = giaCuoc;
        }
    }

    public static class cuocGoi {

        private String thueBao, thoiDiemBatDau, thoiDiemKetThuc;
        private String tinh;
        private int soPhutGoi, giaCuocPhaiTra;

        public cuocGoi(String thueBao, String thoiDiemBatDau, String thoiDiemKetThuc) {
            this.thueBao = thueBao;
            this.thoiDiemBatDau = thoiDiemBatDau;
            this.thoiDiemKetThuc = thoiDiemKetThuc;
        }

        public void setTinh() {
            if (thueBao.startsWith("0")) {
                String s = thueBao.substring(1, 3);
                for (tinh x : a) {
                    if (s.equals(x.maVung)) {
                        this.tinh = x.tenTinh;
                        break;
                    }
                }
            } else {
                this.tinh = "Noi mang";
            }
        }

        public void setSoPhutGoi() {
            String[] t = thoiDiemBatDau.split(":");
            String[] t1 = thoiDiemKetThuc.split(":");
            int tmp = (Integer.parseInt(t1[0]) * 60 + Integer.parseInt(t1[1])) - (Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]));
            if (tinh.equals("Noi mang")) {
                if (tmp % 3 == 0) {
                    this.soPhutGoi = tmp / 3;
                } else {
                    this.soPhutGoi = (int) tmp / 3 + 1;
                }
            } else {
                this.soPhutGoi = tmp;
            }
        }

        public void setGiaCuocPhaiTra() {
            if (tinh.equals("Noi mang")) {
                this.giaCuocPhaiTra = soPhutGoi * 800;
            } else {
                int giaCuoc = 0;
                String s = thueBao.substring(1, 3);
                for (tinh x : a) {
                    if (s.equals(x.maVung)) {
                        giaCuoc = x.giaCuoc;
                        break;
                    }
                }
                this.giaCuocPhaiTra = giaCuoc * soPhutGoi;
            }
        }

        @Override
        public String toString() {
            return thueBao + " " + tinh + " " + soPhutGoi + " " + giaCuocPhaiTra;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            a.add(new tinh(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine())));
        }

        m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            String[] t = s.split("\\s+");
            b.add(new cuocGoi(t[0], t[1], t[2]));
            b.get(i).setTinh();
            b.get(i).setSoPhutGoi();
            b.get(i).setGiaCuocPhaiTra();
        }

        Collections.sort(b, new Comparator<cuocGoi>() {
            @Override
            public int compare(cuocGoi t, cuocGoi t1) {
                return t1.giaCuocPhaiTra - t.giaCuocPhaiTra;
            }
            
        });
        for (int i = 0; i < m; i++) {
            System.out.println(b.get(i));
        }
    }
}
