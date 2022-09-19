/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Khai_bao_lop_va_doi_tuong;

import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J04007 {
    private String ID, name, sexiual, date, address, vat, contract;

    public J04007() {
    }

    public J04007(String ID, String name, String sexiual, String date, String address, String vat, String contract) {
        this.ID = ID;
        this.name = name;
        this.sexiual = sexiual;
        this.date = date;
        this.address = address;
        this.vat = vat;
        this.contract = contract;
    }

    @Override
    public String toString() {
        return ID + " " + name + " " + sexiual + " " + date + " " + address + " " + vat + " " + contract;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String sexiual = sc.nextLine();
        String date = sc.nextLine();
        String address = sc.nextLine();
        String vat = sc.nextLine();
        String contract = sc.nextLine();
        J04007 nhanVien = new J04007("00001", name, sexiual, date, address, vat, contract);
        System.out.println(nhanVien.toString());
    }
    
}
