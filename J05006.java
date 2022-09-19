/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang_Doi_Tuong;

import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J05006 {

    private String ma, name, sexiual, date, address, tax, contract;

    public J05006(int stt, String name, String sexiual, String date, String address, String tax, String contract) {
        this.ma = String.format("%05d", stt);
        this.name = name;
        this.sexiual = sexiual;
        this.date = date;
        this.address = address;
        this.tax = tax;
        this.contract = contract;
    }

    @Override
    public String toString() {
        return ma + " " + name + " " + sexiual + " " + date + " "
                + address + " " + tax + " " + contract;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05006[] a = new J05006[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05006(i + 1, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
        }
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
