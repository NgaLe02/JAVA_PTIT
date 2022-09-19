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
public class Chu_so_4_va_chu_so_7 {
    public static int solve(long n) {
        int dem = 0;
        while(n > 0) {
            if(n % 10 == 4 || n % 10 == 7) {
                dem++;
            }
            n /= 10;
        }
        if(dem == 4 || dem == 7) return 1;
        return 0;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        if(solve(n) == 1) {
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
