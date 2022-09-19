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
public class J05055 {

    private String ma, hoTen, ngaySinh;
    private int thoiGianXuatPhat, thoiGianDenDich, uuTien, thanhTichDeXepHang;
    private String thanhTichThucTe;
    private int xepHang;

    static int thuTu = 0;
    static int soVDV = 0;
    static int thoiGianXepHang = 0;
    
    public J05055(int ma, String hoTen, String ngaySinh) {
        this.ma = "VDV" + String.format("%02d", ma);
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
    }

    public void setThoiGianXuatPhat(String thoiGianXuatPhat) {
        String[] time1 = thoiGianXuatPhat.split(":");
        int se1 = Integer.parseInt(time1[0]) * 3600 + Integer.parseInt(time1[1]) * 60 + Integer.parseInt(time1[2]);
        this.thoiGianXuatPhat = se1;
    }

    public void setThoiGianDenDich(String thoiGianDenDich) {
        String[] time2 = thoiGianDenDich.split(":");
        int se2 = Integer.parseInt(time2[0]) * 3600 + Integer.parseInt(time2[1]) * 60 + Integer.parseInt(time2[2]);
        this.thoiGianDenDich = se2;
    }

    public void setThanhTichThucTe() {
        int diff = thoiGianDenDich - thoiGianXuatPhat;
        this.thanhTichThucTe = String.format("%02d:%02d:%02d", diff / 3600, (diff % 3600) / 60, (diff % 60));
    }

    public void setUuTien() {
        String[] date = ngaySinh.split("/");
        int year = Integer.parseInt(date[2]);
        int uuTien = 0;
        if (2021 - year < 18) {
            uuTien = 0;
        } else if (2021 - year < 25) {
            uuTien = 1;
        } else if (2021 - year < 32) {
            uuTien = 2;
        } else if (2021 - year >= 32) {
            uuTien = 3;
        }
        this.uuTien = uuTien;
    }

    public void setThanhTichDeXepHang() {
        int time = thoiGianDenDich - thoiGianXuatPhat - uuTien;
        this.thanhTichDeXepHang = time;
    }
    
    public void setXepHang() {
         if(thanhTichDeXepHang != thoiGianXepHang) {
            this.xepHang  = soVDV + 1;
            thoiGianXepHang = thanhTichDeXepHang;
            thuTu = soVDV;
            soVDV ++;
        }
        else {
            this.xepHang = thuTu + 1;
            soVDV ++;
        }
    }

    public String getMa() {
        return ma;
    }

    public int getThanhTichDeXepHang() {
        return thanhTichDeXepHang;
    }

    @Override
    public String toString() {
        int t = thanhTichDeXepHang;
        return ma + " " + hoTen + " " + thanhTichThucTe + " " +
             ("00:00:" + String.format("%02d", uuTien)) + " " +
             String.format("%02d:%02d:%02d", t / 3600, (t % 3600) / 60, (t % 60)) + " " +
             xepHang + "";
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05055[] a = new J05055[n];
        for (int i = 0; i < n; i++) {
            String hoTen = sc.nextLine();
            String ngaySinh = sc.nextLine();
            String thoiGianXuatPhat = sc.nextLine();
            String thoiGianDenDich = sc.nextLine();
            a[i] = new J05055(i + 1, hoTen, ngaySinh);
            a[i].setThoiGianDenDich(thoiGianDenDich);
            a[i].setThoiGianXuatPhat(thoiGianXuatPhat);
            a[i].setUuTien();
            a[i].setThanhTichThucTe();
            a[i].setThanhTichDeXepHang();
        }
        
         Arrays.sort(a, new Comparator<J05055>() {
            @Override
            public int compare(J05055 t, J05055 t1) {       
                return t.getThanhTichDeXepHang() - t1.getThanhTichDeXepHang();
            }
        });
       
        for(int i = 0; i < n; i++) {
             a[i].setXepHang();
         }
        
        Arrays.sort(a, new Comparator<J05055>() {
            @Override
            public int compare(J05055 t, J05055 t1) {       
                return t.getMa().compareTo(t1.getMa());
            }
        });
        for(int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
