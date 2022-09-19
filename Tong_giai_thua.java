/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LapTrinhJavaCoBan;

import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class Tong_giai_thua {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long tong = 1;
        long nho = 1;
        for(long i = 2; i <= n; i++) {
            nho = nho * i;
            tong += nho;
        }
        System.out.println(tong);
    }
}
