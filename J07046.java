/*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J07046 {

    private String ma, ten, maPhong, ngayDen, ngayDi;
    private long soNgayLuuTru;

    public J07046(int ma, String ten, String maPhong, String ngayDen, String ngayDi) {
        this.ma = String.format("KH%02d", ma);
        this.ten = ten;
        this.maPhong = maPhong;
        this.ngayDen = ngayDen;
        this.ngayDi = ngayDi;
    }

    public void setSoNgayLuuTru() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
        Date t1 = simpleDateFormat.parse(ngayDen);
        Date t2 = simpleDateFormat.parse(ngayDi);
        long diff = (long) (t2.getTime() - t1.getTime()) / (1000 * 60 * 60 * 24);
        this.soNgayLuuTru = diff;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + maPhong + " " + soNgayLuuTru;
    }

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("KHACH.in"));
        int n = Integer.parseInt(sc.nextLine());
        J07046[] a = new J07046[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J07046(i + 1, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            a[i].setSoNgayLuuTru();
        }

        Arrays.sort(a, new Comparator<J07046>() {
            @Override
            public int compare(J07046 t, J07046 t1) {
                return Long.compare(t1.soNgayLuuTru, t.soNgayLuuTru);
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
