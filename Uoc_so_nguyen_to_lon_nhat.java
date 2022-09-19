/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LapTrinhJavaCoBan;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class Uoc_so_nguyen_to_lon_nhat {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            long n = scan.nextLong();
            for (int i = 1; i < n; i++) {
                if (n % i == 0 && Prime(n / i) == 1) {
                    System.out.println(+n / i);
                    break;
                }
            }
        }
    }

    public static long Prime(long n) {
        if (n < 2) {
            return 0;
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return 0;
                }
            }
        }
        return 1;
    }
}
