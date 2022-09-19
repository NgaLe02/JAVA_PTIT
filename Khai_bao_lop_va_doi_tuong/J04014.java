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
public class J04014 {

    private long tuSo;
    private long mauSo;

    public J04014() {
    }

    public J04014(long tuSo, long mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }

    public long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public void toiGian() {
        long uocChung = gcd(this.getTuSo(), this.getMauSo());
        this.tuSo /= uocChung;
        this.mauSo /= uocChung;
    }

    @Override
    public String toString() {
        return this.getTuSo() + "/" + this.getMauSo();
    }

    public long getTuSo() {
        return tuSo;
    }

    public long getMauSo() {
        return mauSo;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long x1 = sc.nextLong();
            long y1 = sc.nextLong();
            long x2 = sc.nextLong();
            long y2 = sc.nextLong();
            long x3 = x1 * y2 + x2 * y1;
            long y3 = y1 * y2;
            J04014 phanSo3 = new J04014(x3 * x3, y3 * y3);
            phanSo3.toiGian();
            long z = x1 * x2 * phanSo3.getTuSo();
            long w = y1 * y2 * phanSo3.getMauSo();
            J04014 phanSo4 = new J04014(z, w);
            phanSo4.toiGian();
            System.out.println(phanSo3.toString() + " " + phanSo4.toString());
        }
    }
}