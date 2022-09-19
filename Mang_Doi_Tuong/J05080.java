package Mang_Doi_Tuong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class J05080 {

    private String maMonHoc, tenMonHoc, nhomLop, tenGiangVien;

    public J05080(String maMonHoc, String tenMonHoc, String nhomLop, String tenGiangVien) {
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
        return maMonHoc + " " + tenMonHoc + " " + nhomLop;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        J05080[] a = new J05080[n];
        for (int i = 0; i < n; i++) {
            a[i] = new J05080(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
        }

        Arrays.sort(a, new Comparator<J05080>() {
            @Override
            public int compare(J05080 t, J05080 t1) {
                if (!t.getMaMonHoc().equals(t1.getMaMonHoc())) {
                    return t.getMaMonHoc().compareTo(t1.getMaMonHoc());
                }
                return t.getNhomLop().compareTo(t1.getNhomLop());
            }
        });

        
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            System.out.println("Danh sach cho giang vien " + s + ":");
            for (int i = 0; i < n; i++) {
                if (a[i].getTenGiangVien().equals(s)) {
                    System.out.println(a[i]);
                }
            }
        }
    }
}
