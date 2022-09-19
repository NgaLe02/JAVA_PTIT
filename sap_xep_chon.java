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
public class sap_xep_chon {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < n - 1; i++) {
            System.out.print("Buoc " + (i + 1) + ": ");
            int min_ind = i;
            for(int j = i + 1; j < n; j++) {
                if(a[j] < a[min_ind]) {
                    min_ind = j;
                }
            }
            int tmp = a[i];
            a[i] = a[min_ind];
            a[min_ind] = tmp;
            for(int k = 0; k < n; k++) {
                System.out.print(a[k] + " ");
            }
            System.out.println("");
        }
    }
}
