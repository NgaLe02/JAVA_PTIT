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
public class J05007 {

    private String ma, name, sexiual, date, address, tax, contract;
    private int year, month, day;

    public J05007(int stt, String name, String sexiual, String date, String address, String tax, String contract) {
        this.ma = String.format("%05d", stt);
        this.name = name;
        this.sexiual = sexiual;
        this.date = date;
        this.address = address;
        this.tax = tax;
        this.contract = contract;
    }

    public int getYear() {
        return year;
    }

    public void setYear() {
        this.year = Integer.parseInt(date.substring(6));
    }

    public int getMonth() {
        return month;
    }

    public void setMonth() {
        this.month = Integer.parseInt(date.substring(3, 5));
    }

    public int getDay() {
        return day;
    }

    public void setDay() {
        this.day = Integer.parseInt(date.substring(0, 2));

    }

    @Override
    public String toString() {
        return ma + " " + name + " " + sexiual + " " + date + " "
                + address + " " + tax + " " + contract;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05007[] a = new J05007[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05007(i + 1, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            a[i].setDay();
            a[i].setMonth();
            a[i].setYear();
        }

        Arrays.sort(a, new Comparator<J05007>() {
            @Override
            public int compare(J05007 t, J05007 t1) {
                if (t.getYear() != t1.getYear()) {
                    return t.getYear() - t1.getYear();
                }
                if (t.getMonth() != t1.getMonth()) {
                    return t.getMonth() - t1.getMonth();
                }
                return t.getDay() - t1.getDay();
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
