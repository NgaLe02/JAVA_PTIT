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
public class dem_so_lan_xuat_hien {
    
    public static int snt(int n) {
        if(n < 2) return 0;
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) return 0;
        }
        return 1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int dem = 1;
        while(dem <= t) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[100001];
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                b[a[i]]++;
            }
            System.out.println("Test " + dem + ":");
            for(int i = 0; i < n; i++) {
                if(b[a[i]] != 0) {
                    System.out.println(a[i] + " xuat hien " + b[a[i]] + " lan");
                    b[a[i]] = 0;
                }
            }
            dem++;
        }
    }
}
