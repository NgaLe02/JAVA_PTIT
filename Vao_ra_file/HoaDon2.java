/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VaoRaFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */

class KhachHang{
    String ma, ten, gioiTinh, ngaySinh, diaChi;

    public KhachHang(int ma, String ten, String gioiTinh, String ngaySinh, String diaChi) {
        this.ma = String.format("KH%03d", ma);
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }
    
}

class MatHang{
    String ma, ten, dvt;
    int giaMua, giaBan;

    public MatHang(int ma, String ten, String dvt, int giaMua, int giaBan) {
        this.ma = String.format("MH%03d", ma);
        this.ten = ten;
        this.dvt = dvt;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }
    
    
}

class HoaDon{
    String ma;
    KhachHang khachHang;
    MatHang matHang;
    int soLuong, thanhTien;

    public HoaDon(int ma, KhachHang khachHang, MatHang matHang, int soLuong) {
        this.ma = String.format("HD%03d", ma);
        this.khachHang = khachHang;
        this.matHang = matHang;
        this.soLuong = soLuong;
        this.thanhTien = matHang.giaBan * soLuong;
    }

    @Override
    public String toString() {
        return ma + " " + khachHang.ten + " " + khachHang.diaChi + " " + 
                matHang.ten + " " + matHang.dvt + " " + matHang.giaMua + " " + 
                matHang.giaBan + " " + soLuong + " " + thanhTien;
    }
    
    
}
public class HoaDon2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/VaoRaFile/KH.in"));
        ArrayList<KhachHang> kh = new ArrayList<>();
        int t = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < t; i++){
            kh.add(new KhachHang(i + 1, sc.nextLine().trim(), sc.nextLine().trim(), sc.nextLine().trim(), sc.nextLine().trim()));
        }
        
        sc = new Scanner(new File("src/VaoRaFile/MH.in"));
        ArrayList<MatHang> mh = new ArrayList<>();
        t = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < t; i++){
            mh.add(new MatHang(i + 1, sc.nextLine().trim(), sc.nextLine().trim(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine())));
        }
        
         sc = new Scanner(new File("src/VaoRaFile/HD.in"));
        ArrayList<HoaDon> hd= new ArrayList<>();
        t = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < t; i++){
            String s = sc.nextLine();
            String[] words = s.trim().split("\\s+");
            String maKH = words[0];
            String maMH = words[1];
            int soLuong = Integer.parseInt(words[2]);
            MatHang a = null;
            KhachHang b= null;
            for(MatHang x : mh){
                if(x.ma.equals(maMH)){
                    a = x;
                    break;
                }
            }
            for(KhachHang x : kh){
                if(x.ma.equals(maKH)){
                    b = x;
                    break;
                }
            }
            hd.add(new HoaDon(i + 1, b, a, soLuong));
        }
        
        for(HoaDon x : hd){
            System.out.println(x);
        }
    }
}
