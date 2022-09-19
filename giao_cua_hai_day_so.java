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
public class giao_cua_hai_day_so {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        TreeSet<Integer> giao = new TreeSet<Integer>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            giao.add(a[i]);
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        for (int x : giao) {
            for(int i = 0; i < m; i++) {
                if(b[i] == x) {
                    System.out.print(x + " ");
                    break;
                }
            }
        }
    }
}
