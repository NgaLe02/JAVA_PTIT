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
public class tinh_luy_thua {
    static long mod = (long) 1e9 + 7;
    public static long pow(long a, long b) {
        if(b == 0) return 1;
        long t = pow(a, b / 2);
        t = t * t % mod;
        if(b % 2 == 1) {
            t = t * a % mod;
        }
        return t;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {            
            long a = sc.nextLong();
            long b = sc.nextLong();
            if(a == 0 && b == 0) break;
            System.out.println(pow(a, b));
        }
    }
}
