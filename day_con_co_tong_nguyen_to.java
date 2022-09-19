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
public class day_con_co_tong_nguyen_to {
        static int n;
    static int[] a = new int[21];
    static int[] b = new int[21];
    static int[] x = new int[21];

    public static int snt(int n) {
        if (n < 2) {
            return 0;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return 0;
            }
        }
        return 1;
    }

    public static void backtrack(int i) {
        for (int j = 0; j <= 1; j++) {
            x[i] = j;
            if (i == n) {
                ArrayList<Integer> c = new ArrayList<>();
                int sum = 0;
                for (int l = 1; l <= n; l++) {
                    if (x[l] == 1) {
                        sum += a[l];
                        c.add(a[l]);
                    }
                }
                if (snt(sum) == 1) {
                    for (int l = 0; l < c.size(); l++) {
                        System.out.print(c.get(l) + " ");
                    }
                    System.out.println("");
                }
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
            for (int i = 1; i <= n; i++) {
                b[i] = sc.nextInt();
            }
            Arrays.sort(b, 0, n + 1);
            for (int i = 1; i <= n; i++) {
                a[i] = b[n + 1 - i];
            }
            backtrack(1);
        }
    }
}
