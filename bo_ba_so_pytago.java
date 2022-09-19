/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang;

import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class bo_ba_so_pytago {

    public static int solve(long [] a, int n) {
        for (int i = n - 1; i >= 2; i--) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (a[l] + a[r] == a[i]) {
                    return 1;
                } else if (a[l] + a[r] < a[i]) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                a[i] *= a[i];
            }
            if (solve(a, n) == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
