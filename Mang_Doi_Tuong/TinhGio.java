/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MangDoiTuong;

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
public class TinhGio implements Comparable<TinhGio>{
    String ma, ten, vao, ra;
    SimpleDateFormat hour = new SimpleDateFormat("HH:mm");
    Date in = null, out = null;
    int gio, phut, time;

    public TinhGio(String ma, String ten, String vao, String ra) throws ParseException {
        this.ma = ma;
        this.ten = ten;
        this.vao = vao;
        this.ra = ra;
        in = hour.parse(vao);
        out = hour.parse(ra);
        time = (int)(out.getTime() - in.getTime()) / (1000 * 60);
        gio = (int)(time / 60);
        phut = time % 60;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + gio + " gio " + phut + " phut";
    }
    
    
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<TinhGio> a = new ArrayList<>();
        for(int i = 0; i < t; i++){
            a.add(new TinhGio(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        Collections.sort(a);
        for(TinhGio x : a){
            System.out.println(x);
        }
    }

    @Override
    public int compareTo(TinhGio t) {
        return t.time - time;
    }
}
