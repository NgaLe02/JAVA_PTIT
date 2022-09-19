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
public class J04015 {
    private String maNgach, name;
    private int salary, bacLuong, phuCap, thuNhap;
    
    public J04015() {
    }

    public J04015(String maNgach, String name, int salary) {
        this.maNgach = maNgach;
        this.name = name;
        this.salary = salary;
        this.bacLuong = Integer.parseInt(maNgach.substring(2));
        int pC = 0;
        String chucVu = maNgach.substring(0, 2);
        if(chucVu.equals("HT")){
            pC = 2000000;
        }
        else if (chucVu.equals("HP")) {
            pC = 900000;
        }
        else {
            pC = 500000;
        }
        this.phuCap = pC;
        this.thuNhap = pC + salary * this.bacLuong;
    } 

    @Override
    public String toString() {
        return maNgach + " " + name + " " + bacLuong + " " + phuCap + " " + thuNhap;
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String maNgach = sc.nextLine();
        String name = sc.nextLine();
        int salary = sc.nextInt();
        J04015 giaoVien = new J04015(maNgach, name, salary);
        System.out.println(giaoVien.toString());
    }
}
