/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Khai_bao_lop_va_doi_tuong;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J07058 {

    private String maMon, tenMon, hinhThucThi;

    public J07058() {
    }

    public J07058(String maMon, String tenMon, String hinhThucThi) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.hinhThucThi = hinhThucThi;
    }

    public String getMaMon() {
        return maMon;
    }

    @Override
    public String toString() {
        return maMon + " " + tenMon + " " + hinhThucThi;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file = new FileInputStream("MONHOC.in");
        Scanner sc = new Scanner(file);
        
        int t = Integer.parseInt(sc.nextLine());
        J07058[] arr = new J07058[t];
        while (sc.hasNextLine()) {
            for (int i = 0; i < t; i++) {
                String maMon = sc.nextLine();
                String tenMon = sc.nextLine();
                String hinhThucThi = sc.nextLine();
                arr[i] = new J07058(maMon, tenMon, hinhThucThi);
            }
        }
        Arrays.sort(arr, new Comparator<J07058>() {
            @Override
            public int compare(J07058 t, J07058 t1) {
                return t.maMon.compareTo(t1.maMon);
            }
        });
        for (int i = 0; i < t; i++) {
            System.out.println(arr[i].toString());
        }
    }
}
