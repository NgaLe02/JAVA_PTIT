/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang_Doi_Tuong;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J05020 {

    private String ma, ten, lop, email;

    public J05020(String ma, String ten, String lop, String email) {
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
        int n = Integer.parseInt(sc.nextLine());
        J05020[] a = new J05020[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05020(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
        }

        Arrays.sort(a, new Comparator<J05020>() {
            @Override
            public int compare(J05020 t, J05020 t1) {
                if (!t.getLop().equals(t1.getLop())) {
                    return t.getLop().compareTo(t1.getLop());
                }
                return t.getMa().compareTo(t1.getMa());
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
