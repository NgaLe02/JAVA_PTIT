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
public class sap_xep_chen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("Buoc 0: " + a[0]);
        for(int i = 1; i < n; i++) {
            System.out.print("Buoc " + (i) + ": ");
            int key = a[i];
            int pos = i - 1;
            while(pos >= 0 && a[pos] > key) {
                a[pos + 1] = a[pos];
                pos--;
            }
            a[pos + 1] = key;
            for(int k = 0; k <= i; k++) {
                System.out.print(a[k] + " ");
            }
            System.out.println("");
        }
                
    }
}
