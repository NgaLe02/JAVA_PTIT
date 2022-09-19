/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang;

import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Dell E7440
 */
public class hop_cua_2_day_so {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        TreeSet<Integer> hop = new TreeSet<Integer>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            hop.add(a[i]);
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
            hop.add(b[i]);
        }
        for (int x : hop) {
            System.out.print(x + " ");
        }
    }
}
