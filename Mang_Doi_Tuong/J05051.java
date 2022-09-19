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
public class J05051 {

    private String maKH;
    private int heSo, thanhTien, phuTroi, tongTienPhaiTra;

    public J05051(int maKH) {
        this.maKH = "KH" + String.format("%02d", maKH);
    }

    public void setHeSo(String loaiSD) {
        if (loaiSD.equals("KD")) {
            this.heSo = 3;
        } else if (loaiSD.equals("NN")) {
            this.heSo = 5;
        } else if (loaiSD.equals("TT")) {
            this.heSo = 4;
        } else if (loaiSD.equals("CN")) {
            this.heSo = 2;
        }
    }

    public void setThanhTien(int chiSoCu, int chiSoMoi) {
        this.thanhTien = (chiSoMoi - chiSoCu) * heSo * 550;
    }

    public void setPhuTroi(int chiSoCu, int chiSoMoi) {
        int tmp = chiSoMoi - chiSoCu;
        if (tmp < 50) {
            this.phuTroi = 0;
        } else if (tmp <= 100) {
            this.phuTroi = (int) Math.round((float) (thanhTien * 0.35));
        } else {
            this.phuTroi = thanhTien;
        }
    }

    public void setTongTienPhaiTra(int tongTienPhaiTra) {
        this.tongTienPhaiTra = phuTroi + thanhTien;
    }

    public int getTongTienPhaiTra() {
        return tongTienPhaiTra;
    }

    
    @Override
    public String toString() {
        return maKH + " " + heSo + " " + thanhTien + " " + phuTroi + " " + tongTienPhaiTra;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        J05051[] a = new J05051[n];
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String loaiSD = sc.nextLine();
            int chiSoCu = sc.nextInt();
            int chiSoMoi = sc.nextInt();
            a[i] = new J05051(i + 1);
            a[i].setHeSo(loaiSD);
            a[i].setThanhTien(chiSoCu, chiSoMoi);
            a[i].setPhuTroi(chiSoCu, chiSoMoi);
            a[i].setTongTienPhaiTra(chiSoMoi);
        }

        Arrays.sort(a, new Comparator<J05051>() {
            @Override
            public int compare(J05051 t, J05051 t1) {       
                return t1.getTongTienPhaiTra() - t.getTongTienPhaiTra();
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
