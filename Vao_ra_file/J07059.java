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
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell E7440
 */
public class J07059 implements Comparable<J07059> {

    private String maCT, ngayThi, gioThi, phongThi;

    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat hour = new SimpleDateFormat("hh:mm");

    public J07059(int maCT, String ngayThi, String gioThi, String phongThi) {
        this.maCT = String.format("C%03d", maCT);
        this.ngayThi = ngayThi;
        this.gioThi = gioThi;
        this.phongThi = phongThi;
    }

    @Override
    public String toString() {
        return maCT + " " + ngayThi + " " + gioThi + " " + phongThi;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("CATHI.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<J07059> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String ngayThi = sc.nextLine();
            String gioThi = sc.nextLine();
            String phongThi = sc.nextLine();
            a.add(new J07059(i + 1, ngayThi, gioThi, phongThi));
        }

        Collections.sort(a);

        for (J07059 x : a) {
            System.out.println(x);
        }
    }

    @Override
    public int compareTo(J07059 t) {
        Date date1 = null, date2 = null;
        try {
            date1 = date.parse(ngayThi);
        } catch (ParseException ex) {
            Logger.getLogger(J07059.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            date2 = date.parse(t.ngayThi);
        } catch (ParseException ex) {
            Logger.getLogger(J07059.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (date1.compareTo(date2) != 0) {
            return date1.compareTo(date2);
        }
        Date hour1 = null, hour2 = null;
        try {
            hour1 = hour.parse(gioThi);
        } catch (ParseException ex) {
            Logger.getLogger(J07059.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            hour2 = hour.parse(t.gioThi);
        } catch (ParseException ex) {
            Logger.getLogger(J07059.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (hour1.compareTo(hour2) != 0) {
            return hour1.compareTo(hour2);
        }
        return maCT.compareTo(t.maCT);
    }
}
