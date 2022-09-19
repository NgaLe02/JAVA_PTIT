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
public class Chia_tam_giac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int h = sc.nextInt();
            for(int i = 1; i < n; i++) {
                System.out.printf("%.6f", (double) h * Math.sqrt(i / (n * 1.0)));
                System.out.print(" ");
            }
            System.out.println("");
        }
    }          
}
