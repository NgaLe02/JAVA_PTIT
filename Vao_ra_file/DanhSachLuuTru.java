/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VaoRaFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell E7440
 */
public class DanhSachLuuTru implements Comparable<DanhSachLuuTru>{

    String maKhach, ten, maPhong, ngayDen, ngayDi;
    long soNgayLuuTru;
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

    public DanhSachLuuTru(int maKhach, String ten, String maPhong, String ngayDen, String ngayDi) {
        this.maKhach = String.format("KH%02d", maKhach);
        this.ten = ten;
        this.maPhong = maPhong;
        this.ngayDen = ngayDen;
        this.ngayDi = ngayDi;
    }

    public void setSoNgayLuuTru() throws ParseException {
        Date date1 = null, date2 = null;
        date1 = date.parse(ngayDen);
        date2= date.parse(ngayDi);
        this.soNgayLuuTru = (long)(date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24);
    }

    @Override
    public String toString() {
        return maKhach + " " + ten + " " + maPhong + " " + soNgayLuuTru;
    }

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("src/VaoRaFile/KHACH.in"));
        ArrayList<DanhSachLuuTru> a = new ArrayList<>();
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            a.add(new DanhSachLuuTru(i + 1, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
            a.get(a.size() - 1).setSoNgayLuuTru();
        }
        Collections.sort(a);
        for(DanhSachLuuTru x : a){
            System.out.println(x);
        }
    }

    @Override
    public int compareTo(DanhSachLuuTru t) {
        return Long.compare(t.soNgayLuuTru, soNgayLuuTru);
    }
}
