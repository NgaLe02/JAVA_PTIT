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
public class Phan_tich_thua_so_nguyen_to {

    public static void phanTich(int n) {
        for (int i = 2; i * i <= n; i++) {
            int cnt = 0;
            while (n % i == 0) {
                cnt++;
                n /= i;
            }
            if (cnt != 0) {
                System.out.print(i + "(" + cnt + ")" + " ");
            }
        }
        if (n != 1) {
            System.out.print(n + "(" + 1 + ")" + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int dem = 1;
        while (dem <= t) {
            int n = sc.nextInt();
            System.out.print("Test " + dem + ": ");
            phanTich(n);
            System.out.println("");
            dem++;
        }
    }
}
