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
public class Kiem_tra_so_Fibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        long[] a = new long[93];
        a[0] = 0;
        a[1] = a[2] = 1;
        for (int i = 3; i <= 92; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }

        while (t-- > 0) {
            long n = sc.nextLong();
            int check = 0;
            for (int i = 0; i <= 92; i++) {
                if (a[i] == n) {
                    check = 1;
                    break;
                }
            }
            if (check == 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
