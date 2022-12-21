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
public class J05007 implements Comparable<J05007>{

    String ma, ten, gt, ns, dc, mst, nkhd;
    SimpleDateFormat date = new SimpleDateFormat("dd/mm/yyyy");
    Date ngay = null;
    public J05007(int ma, String ten, String gt, String ns, String dc, String mst, String nghd) throws ParseException {
        this.ma = String.format("%05d", ma);
        this.ten = ten;
        this.gt = gt;
        this.ns = ns;
        ngay = date.parse(ns);
        this.dc = dc;
        this.mst = mst;
        this.nkhd = nghd;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + gt + " " + ns + " " + dc + " " + mst + " " + nkhd;
    }

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<J05007> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(new J05007(i + 1, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        Collections.sort(a);
        for(J05007 x : a){
            System.out.println(x);
        }
    }

    @Override
    public int compareTo(J05007 t) {
        return ngay.compareTo(t.ngay);
    }
}
