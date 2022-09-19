package Mang_Doi_Tuong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class J05079 {

    private String maMonHoc, tenMonHoc, nhomLop, tenGiangVien;

    public J05079(String maMonHoc, String tenMonHoc, String nhomLop, String tenGiangVien) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.nhomLop = nhomLop;
        this.tenGiangVien = tenGiangVien;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public String getNhomLop() {
        return nhomLop;
    }

    public String getTenGiangVien() {
        return tenGiangVien;
    }

    @Override
    public String toString() {
        return nhomLop + " " + tenGiangVien;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05079[] a = new J05079[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05079(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
        }

        Arrays.sort(a, new Comparator<J05079>() {
            @Override
            public int compare(J05079 t, J05079 t1) {
                return t.getNhomLop().compareTo(t1.getNhomLop());
            }
        });

        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            for (int i = 0; i < n; i++) {
                if (a[i].getMaMonHoc().equals(s)) {
                    System.out.println("Danh sach nhom lop mon " + a[i].getTenMonHoc() + ":");
                    break;
                }
            }
            for (int i = 0; i < n; i++) {
                if (a[i].getMaMonHoc().equals(s)) {
                    System.out.println(a[i]);
                }
            }
        }
    }
}