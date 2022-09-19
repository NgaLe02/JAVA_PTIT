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
public class so_khong_lien_ke {

    public static int check1(long n) {
        long tong = 0;
        while (n > 0) {
            tong += n % 10;
            n /= 10;
        }
        if (tong % 10 == 0) {
            return 1;
        }
        return 0;
    }

    public static int check2(long n) {
        long a, b;
        while (n > 10) {
            a = n % 10;
            n /= 10;
            b = n % 10;
            if (Math.abs(a - b) != 2) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            if (check1(n) == 1 && check2(n) == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
