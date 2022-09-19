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
public class J04003 {
    
    private long tuSo, mauSo;

    public J04003(long tuSo, long mauSo) {
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
    
    public J04003 rutGon() {
        long uocChung = gcd(this.tuSo, this.mauSo);
        this.tuSo /= uocChung;
        this.mauSo /= uocChung;
        return new J04003(this.tuSo, this.mauSo);
    }
    
    public String toString() {
        return tuSo + "/" + mauSo;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long tuSo = sc.nextLong();
        long mauSo = sc.nextLong();
        J04003 phanSo = new J04003(tuSo, mauSo);
        phanSo.rutGon();
        System.out.println(phanSo.toString());
    }
}
