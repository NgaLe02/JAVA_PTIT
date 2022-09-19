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
public class J04004 {
    
    private long tuSo, mauSo;

    public J04004() {
    }

    public J04004(long tuSo, long mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }
    
    public static long gcd (long a, long b) {
        if (b == 0) {
            return a;
        }
        else {
            return gcd(b, a % b);
        }
    }
    
    public static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
    
    public J04004 rutGon() {
        long uocChung = gcd(this.tuSo, this.mauSo);
        this.tuSo /= uocChung;
        this.mauSo /= uocChung;
        return new J04004(this.tuSo, this.mauSo);
    }
    
    public J04004 add (J04004 another) {
        long boiChung = lcm(this.mauSo, another.mauSo);
        this.tuSo *= boiChung / this.mauSo;
        another.tuSo *= boiChung / another.mauSo;
        return new J04004(this.tuSo + another.tuSo, boiChung);
    }
    
    public String toString() {
        return tuSo + "/" + mauSo;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long tuSo1 = sc.nextLong();
        long mauSo1 = sc.nextLong();
        long tuSo2 = sc.nextLong();
        long mauSo2 = sc.nextLong();
        J04004 phanSo1 = new J04004(tuSo1, mauSo1);
        J04004 phanSo2 = new J04004(tuSo2, mauSo2);
        phanSo1.rutGon();
        phanSo2.rutGon();
        J04004 phanSo3 = new J04004();
        phanSo3 = phanSo1.add(phanSo2);
        phanSo3.rutGon();
        System.out.println(phanSo3.toString());
    }
}
