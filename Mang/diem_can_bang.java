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
public class diem_can_bang {
    public static int check(int[] a, int n, int sum) {
        int suml = 0;
        int l = 0;
        while(l < n - 1) {
            suml += a[l];
            if(suml * 2 == sum - a[l + 1]) return l + 1;
            l++;
        } 
        return -2;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int sum = 0;
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                sum += a[i];
            }
            System.out.println(check(a, n, sum) + 1);
        }
    }
}
