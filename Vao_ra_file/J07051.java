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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J07051 {

    private String ma, name, soPhong, ngayNhanPhong, ngayTraPhong;

    private int tienPhatSinh, soNgayO, thanhTien;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public J07051(int ma, String name, String soPhong, String ngayNhanPhong, String ngayTraPhong, int tienPhatSinh) {
        this.ma = String.format("KH%02d", ma);
        this.name = name;
        this.soPhong = soPhong;
        this.ngayNhanPhong = ngayNhanPhong;
        this.ngayTraPhong = ngayTraPhong;
        this.tienPhatSinh = tienPhatSinh;
    }

    public int getDonGia() {
        char c = soPhong.charAt(0);
        if (c == '1') {
            return 25;
        } else if (c == '2') {
            return 34;
        } else if (c == '3') {
            return 50;
        } else {
            return 80;
        }
    }

    public int getSoNgayO() throws ParseException {
        int diff = -1;
        Date dateStart = simpleDateFormat.parse(ngayNhanPhong);
        Date dateEnd = simpleDateFormat.parse(ngayTraPhong);
        diff = Math.round((dateEnd.getTime() - dateStart.getTime()) / (1000 * 60 * 60 * 24));
        return diff + 1;
    }

    public int getThanhTien() throws ParseException {
        return getDonGia() * getSoNgayO() + tienPhatSinh;
    }

    @Override
    public String toString() {
        try {
            return ma + " " + name + " " + soPhong + " " + getSoNgayO() + " " + getThanhTien();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
public static String chuanHoa(String s) {
        s = s.trim().toLowerCase();
        String[] words = s.split("\\s+");
        s = "";
        for (String x : words) {
            s += String.valueOf(x.charAt(0)).toUpperCase() + x.substring(1);
            s += " ";
        }
        return s.trim();
    }
    

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));

        int t = Integer.parseInt(sc.nextLine());
        ArrayList<J07051> list = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            list.add(new J07051(i + 1, chuanHoa(sc.nextLine()), sc.nextLine(), sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine())));
        }

        Collections.sort(list, new Comparator<J07051>() {
            @Override
            public int compare(J07051 o1, J07051 o2) {
                try {
                    return o2.getThanhTien() - o1.getThanhTien();
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        for (J07051 x : list) {
            System.out.println(x.toString());
        }
    }
}
