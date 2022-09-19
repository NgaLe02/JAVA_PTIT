/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang_Doi_Tuong;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import javafx.scene.shape.Arc;

/**
 *
 * @author Dell E7440
 */
public class J05042 {

    private String ten;
    private int AC, submit;

    public J05042(String ten, int AC, int submit) {
        this.ten = ten;
        this.AC = AC;
        this.submit = submit;
    }

    public int getAC() {
        return AC;
    }

    public int getSubmit() {
        return submit;
    }

    public String getTen() {
        return ten;
    }

    @Override
    public String toString() {
        return ten + " " + AC + " " + submit + "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        J05042[] a = new J05042[n];
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String ten = sc.nextLine();
            int AC = sc.nextInt();
            int submit = sc.nextInt();
            a[i] = new J05042(ten, AC, submit);
        }

        Arrays.sort(a, new Comparator<J05042>() {
            @Override
            public int compare(J05042 t, J05042 t1) {
                if (t.getAC() != t1.getAC()) {
                    return t1.getAC() - t.getAC();
                }
                if (t.getSubmit() != t1.getSubmit()) {
                    return t.getSubmit() - t1.getSubmit();
                }
                return t.getTen().compareTo(t1.getTen());
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
