/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MangDoiTuong;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class XepHangVanDongVien1 implements Comparable<XepHangVanDongVien1>{
    String ma, ten, ns, xp, dd;
    int xh;
    int tuoi, ttxh, tttt, ut;
    SimpleDateFormat date = new SimpleDateFormat("dd/mm/yyyy");
    SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
    Date xuatPhat = null, denDich = null, ngaySinh = new Date();

    public XepHangVanDongVien1(int ma, String ten, String ns, String xp, String dd) throws ParseException {
        this.ma = String.format("VDV%02d", ma);
        this.ten = ten;
        this.ns = ns;
        this.xp = xp;
        this.dd = dd;
        tuoi = 2021 - Integer.parseInt(ns.substring(6));
        xuatPhat = hour.parse(xp);
        denDich = hour.parse(dd);
        tttt = (int)((denDich.getTime() - xuatPhat.getTime()) / (1000));
        if(tuoi >= 32){
            ut = 3;
        }
        else if(tuoi >= 25){
            ut = 2;
        }
        else if(tuoi >= 18){
            ut = 1;
        }
        ttxh = tttt - ut;
    }
    
    public String chuanHoa(int x){
        return String.format("%02d:%02d:%02d", (int)x / 3600, (int)(x % 3600) / 60, x % 60);
    }
    @Override
    public String toString() {
        return ma + " " + ten + " " + chuanHoa(tttt) + " " + chuanHoa(ut) + " " + chuanHoa(ttxh) + " " + xh;
    }
    
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<XepHangVanDongVien1> a = new ArrayList<>();
        for(int i = 0; i < t; i++){
            a.add(new XepHangVanDongVien1(i + 1, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        
       Collections.sort(a);
       a.get(0).xh = 1;
       for(int i = 1; i < a.size(); i++){
           if(a.get(i).ttxh == a.get(i - 1).ttxh){
               a.get(i).xh = a.get(i - 1).xh;
           }
           else{
               a.get(i).xh = i + 1;
           }
       }
       
       Collections.sort(a, new Comparator<XepHangVanDongVien1>(){
            @Override
            public int compare(XepHangVanDongVien1 t, XepHangVanDongVien1 t1) {
                return t.ma.compareTo(t1.ma);
            }
           
       });
       
       for(XepHangVanDongVien1 x : a){
           System.out.println(x);
       }
    }

    @Override
    public int compareTo(XepHangVanDongVien1 t) {
        return ttxh - t.ttxh;
    }
}
