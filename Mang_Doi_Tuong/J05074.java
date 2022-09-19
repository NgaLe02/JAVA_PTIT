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
public class J05074 {

    private String MSV, hoTen, lop, ghiChu;
    private int diemCC;

    public J05074(String MSV, String hoTen, String lop) {
        this.MSV = MSV;
        this.hoTen = hoTen;
        this.lop = lop;
    }

    public void setDiemCC(String diemDanh) {
        int diem = 10;
        for (int i = 0; i < 10; i++) {
            if (diemDanh.charAt(i) == 'v') {
                diem -= 2;
            } else if (diemDanh.charAt(i) == 'm') {
                diem -= 1;
            }
        }
        if (diem < 0) {
            diem = 0;
        }
        this.diemCC = diem;
    }

    @Override
    public String toString() {
        return MSV + " " + hoTen + " " + lop + " " + diemCC;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05074[] a = new J05074[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05074(sc.nextLine(), sc.nextLine(), sc.nextLine());
        }

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] words = s.split("\\s+");
            String SBD = words[0];
            String diemDanh = words[1];
            for (int j = 0; j < n; j++) {
                if (SBD.equals(a[j].MSV)) {
                    a[j].setDiemCC(diemDanh);
                    break;
                }
            }
        }

        String lop = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (a[i].lop.equals(lop)) {
                System.out.print(a[i] + " ");
                if (a[i].diemCC == 0) {
                    System.out.print("KDDK");
                }
                System.out.println("");
            }
        }
    }
}
