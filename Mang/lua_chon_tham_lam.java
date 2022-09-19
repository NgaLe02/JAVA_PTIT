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
public class lua_chon_tham_lam {

    public static void snn(int n, int s) {
        if (n * 9 < s || s == 0) {
            System.out.print("-1 ");
        } else {
            int[] snn = new int[n];
            s--;
            for(int i = n - 1; i > 0; i--) {
                if(s > 9) {
                    snn[i] = 9;
                    s -= 9;
                }
                else {
                    snn[i] = s;
                    s = 0;
                }
            }
            snn[0] = s + 1;
            for(int j = 0; j < n; j++) {
                System.out.print(snn[j]);
            }         
            System.out.print(" ");
        }
    }

    public static void sln(int n, int s) {
        if (n * 9 < s || s == 0) {
            System.out.println("-1");
        } else {
            int[] sln = new int[n];
            for(int i = 0; i < n; i++) {
                if(s >= 9) {
                    sln[i] = 9;
                    s -= 9;
                }
                else {
                    sln[i] = s;
                    s = 0;
                }
            }
            for(int j = 0; j < n; j++) {
                System.out.print(sln[j]);
            }    
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        snn(n, s);
        sln(n, s);
    }
}
