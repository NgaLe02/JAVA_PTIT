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
public class Cat_doi {

    public static void catDoi(long n) {
        long dem = 1, tmp, check = 0, tong = 0;
        while (n > 0) {
            tmp = n % 10;
            if (tmp != 0 && tmp != 8 && tmp != 1 && tmp != 9) {
                check = 1;
                break;
            } else if (tmp == 8 || tmp == 9) {
                tmp = 0;
            }
            tong = tong + tmp * (long) Math.pow(10, dem - 1);
            dem++;
            n /= 10;
        }
        if (check == 1 || tong == 0) {
            System.out.println("INVALID");
        } else {
            System.out.println(tong);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            long n = sc.nextLong();
            catDoi(n);
        }
    }
}
