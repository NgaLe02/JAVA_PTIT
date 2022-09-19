/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang_Doi_Tuong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J05021 {

    private String ma, ten, lop, email;

    public J05021(String ma, String ten, String lop, String email) {
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.email = email;
    }

    public String getLop() {
        return lop;
    }

    public String getMa() {
        return ma;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + lop + " " + email;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList a = new ArrayList();
        while(sc.hasNext()) {
            a.add(new J05021(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }

        Collections.sort(a, new Comparator<J05021>() {
            @Override
            public int compare(J05021 t, J05021 t1) {
                return t.getMa().compareTo(t1.getMa());
            }
        });

        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
    }
}
