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
public class liet_ke_to_hop_2 {
    static int n, k, ans = 0;
    static int[] a = new int[11];

    public static void in() {
        for (int i = 1; i <= k; i++) {
            System.out.print(a[i]);
        }
        System.out.print(" ");
    }

    public static void backtrack(int i) {
        for (int j = a[i - 1] + 1; j <= n - k + i; j++) {
            a[i] = j;
            if (i == k) {
                in();
                ans++;
            } else {
                backtrack(i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int x : a) {
            x = 0;
        }
        backtrack(1);
        System.out.println("");
        System.out.println("Tong cong co " + ans + " to hop");
    }
}
