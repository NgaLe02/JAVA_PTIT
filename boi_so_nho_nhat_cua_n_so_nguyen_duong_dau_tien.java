/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class boi_so_nho_nhat_cua_n_so_nguyen_duong_dau_tien {

    static int max = 1000000;
    static ArrayList<Integer> primes = new ArrayList<Integer>();

    public static void sieve() {
        boolean[] a = new boolean[max + 1];
        for (int i = 2; i * i <= max; i++) {
            if (a[i] == false) {
                for (int j = 2; j * i <= max; j++) {
                    a[i * j] = true;
                }
            }
        }
        for (int i = 2; i <= max; i++) {
            if (a[i] == false) {
                primes.add(i);
            }
        }
    }

    public static long lcm(int n) {
        long lcm = 1;
        for (int i = 0; i < primes.size() && primes.get(i) <= n; i++) {
            int pp = primes.get(i);
            while (pp * primes.get(i) <= n) {
                pp = pp * primes.get(i);
            }
            lcm *= pp;           
        }
        return lcm;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sieve();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(lcm(n));
        }
    }
}
