/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class day_con_co_k_phan_tu_tang_dan {

    static int n, k;
    static int[] a = new int[21];
    static int[] x = new int[21];

    public static void backtrack(int i) {
        for (int j = x[i - 1] + 1; j <= n - k + i; j++) {
            x[i] = j;
            if (i == k) {
                for (int l = 1; l <= k; l++) {
                    System.out.print(a[x[l]] + " ");
                }
                System.out.println("");
            } else {
                backtrack(i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            k = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a, 0, n + 1);
//            for (int i = 1; i <= n; i++) {
//                a[i] = b[n + 1 - i];
//            }
            backtrack(1);
        }
    }
}
