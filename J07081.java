/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J07081 implements Comparable<J07081> {

    private String maSV, hoTen, soDT, email;

    public J07081() {
    }

    public J07081(String maSV, String hoTen, String soDT, String email) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.soDT = soDT;
        this.email = email;
    }

    public String getTen() {
        String[] s = hoTen.split("\\s+");
        return s[s.length - 1];
    }

    public String getHo() {
        String[] s = hoTen.split("\\s+");
        return s[0];
    }

    public String getDem() {
        String[] s = hoTen.split("\\s+");
        String t = "";
        for (int i = 0; i < s.length - 1; i++) {
            t += s[i];
        }
        return t;
    }

    @Override
    public String toString() {
        return maSV + " " + hoTen + " " + soDT + " " + email;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<J07081> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(new J07081(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }

        Collections.sort(a);

        for (J07081 x : a) {
            System.out.println(x);
        }
    }

    @Override
    public int compareTo(J07081 t) {
        if (!getTen().equals(t.getTen())) {
            return getTen().compareTo(t.getTen());
        }
        if (!getHo().equals(t.getHo())) {
            return getHo().compareTo(t.getHo());
        }
        if (!getDem().equals(t.getDem())) {
            return getDem().compareTo(t.getDem());
        }
        return maSV.compareTo(t.maSV);
    }
}
