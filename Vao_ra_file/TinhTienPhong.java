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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class TinhTienPhong implements Comparable<TinhTienPhong>{
    String ma, ten, soPhong, ngayNhan, ngayTra;
    int tienDV, tongTien, soNgayO;
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

    public TinhTienPhong(int ma, String ten, String soPhong, String ngayNhan, String ngayTra, int tien) {
        this.ma = String.format("KH%02d", ma);
        this.ten = chuanHoa(ten);
        this.soPhong = soPhong;
        this.ngayNhan = ngayNhan;
        this.ngayTra = ngayTra;
        this.tienDV = tien;
    }

    public void setTongTien() {
        int x = soPhong.charAt(0) - '0';
        int tongTien = 0;
        if(x == 1){
            tongTien = soNgayO * 25;
        }
        else if(x == 2){
            tongTien = soNgayO * 34;
        }
        else if(x == 3){
            tongTien = soNgayO * 50;
        }
        else{
            tongTien = soNgayO * 80;
        }
        this.tongTien = tongTien  + tienDV;
    }

    public void setSoNgayO() throws ParseException {
        Date date1 = null, date2 = null;
        date1 = date.parse(ngayNhan);
        date2 = date.parse(ngayTra);
        this.soNgayO = (int)((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24)) + 1;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + soPhong + " " + soNgayO + " " + tongTien;
    }
    
    public static String chuanHoa(String s){
        String t = "";
        String[] words = s.toLowerCase().trim().split("\\s+");
        for(String x : words){
            t += String.valueOf(x.charAt(0)).toUpperCase() + x.substring(1) + " ";
        }
        return t.trim();
    }
    
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("src/VaoRaFile/KHACHHANG.in"));
        ArrayList<TinhTienPhong> a = new ArrayList<>();
        int t = Integer.parseInt(sc.nextLine());
        for(int i = 0 ; i < t; i++){
            a.add(new TinhTienPhong(i + 1, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine())));
            a.get(a.size() - 1).setSoNgayO();
            a.get(a.size() - 1).setTongTien();
        }
        Collections.sort(a);
        for(TinhTienPhong x : a){
            System.out.println(x);
        }
    }

    @Override
    public int compareTo(TinhTienPhong t) {
        return t.tongTien - tongTien;
    }
}
