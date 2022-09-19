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
public class Tinh_so_Fibonacci {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[93];
            a[1] = a[2] = 1;
            for(int i = 3; i <= n; i++) {
                a[i] = a[i - 1] + a[i - 2];
            }
            System.out.println(a[n]);
        }       
    }    
}
