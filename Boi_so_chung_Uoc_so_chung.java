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
public class Boi_so_chung_Uoc_so_chung {

    public static long usc(long a, long b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

    public static long bsc(long a, long b) {
        return a / usc(a, b) * b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            System.out.print(bsc(a, b) + " ");
            System.out.println(usc(a, b));
        }
    }
}
