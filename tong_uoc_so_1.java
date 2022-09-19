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
public class tong_uoc_so_1 {

    static int[] minPrime = new int[2 * 1000000 + 1];
    
    public static void sieve() {
        for (int i = 2; i * i <= 2000000; ++i) {
            if (minPrime[i] == 0) { //if i is prime
                for (int j = i * i; j <= 2000000; j += i) {
                    if (minPrime[j] == 0) {
                        minPrime[j] = i;
                    }
                }
            }
        }
        for (int i = 2; i <= 2000000; ++i) {
            if (minPrime[i] == 0) {
                minPrime[i] = i;
            }
        }
    }

    public static long solve(int n) {
        long tong = 0;
        while (n != 1) {
            tong += minPrime[n];
            n /= minPrime[n];
        }
        return tong;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long tong = 0;
        sieve();
        while (t-- > 0) {
            int n = sc.nextInt();
            tong += solve(n);
        }
        System.out.println(tong);
    }
}
