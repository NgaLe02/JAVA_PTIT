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
public class J05050 {

    private String maKH;
    private long heSo, thanhTien, phuTroi, tongTienPhaiTra;

    public J05050(int maKH) {
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

    public void setThanhTien(long chiSoCu, long chiSoMoi) {
        this.thanhTien = (chiSoMoi - chiSoCu) * heSo * 550;
    }

    public void setPhuTroi(long chiSoCu, long chiSoMoi) {
        long tmp = chiSoMoi - chiSoCu;
        if (tmp < 50) {
            this.phuTroi = 0;
        } else if (tmp <= 100) {
            this.phuTroi = (long) Math.round((float) (thanhTien * 0.35));
        } else {
            this.phuTroi = thanhTien;
        }
    }

    public void setTongTienPhaiTra(long tongTienPhaiTra) {
        this.tongTienPhaiTra = phuTroi + thanhTien;
    }

    @Override
    public String toString() {
        return maKH + " " + heSo + " " + thanhTien + " " + phuTroi + " " + tongTienPhaiTra;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        J05050[] a = new J05050[n];
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String loaiSD = sc.nextLine();
            long chiSoCu = sc.nextInt();
            long chiSoMoi = sc.nextInt();
            a[i] = new J05050(i + 1);
            a[i].setHeSo(loaiSD);
            a[i].setThanhTien(chiSoCu, chiSoMoi);
            a[i].setPhuTroi(chiSoCu, chiSoMoi);
            a[i].setTongTienPhaiTra(chiSoMoi);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
