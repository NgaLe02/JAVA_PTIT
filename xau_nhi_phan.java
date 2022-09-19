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
public class xau_nhi_phan {

    public static int fi(int n, long k, long[] a) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (k <= a[n - 2]) {
            return fi(n - 2, k, a);
        }
        return fi(n - 1, k - a[n - 2], a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        long[] a = new long[100];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i <= 92; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            System.out.println(fi(n, k, a));
        }
    }
}
