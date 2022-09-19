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
public class mang_doi_xung {

    public static int check(int[] a, int n) {
        for (int i = 0; i < n / 2; i++) {
            if (a[i] != a[n - 1 - i]) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            if (check(a, n) == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
