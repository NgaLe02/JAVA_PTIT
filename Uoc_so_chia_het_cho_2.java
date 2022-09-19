/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LapTrinhJavaCoBan;

import java.util.Scanner;
import java.util.*;

/**
 *
 * @author Dell E7440
 */
public class Uoc_so_chia_het_cho_2 {

    public static int soUocSo(int n) {
        if (n % 2 == 1) {
            return 0;
        }

        int dem = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                if (i % 2 == 0) {
                    dem++;
                }
                //System.out.println(i);
                if ((n / i) % 2 == 0 && n / i != i) {
                    dem++;
                    //System.out.println(n / i);
                }
            }
        }
        return dem;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(soUocSo(n));
        }
    }
}
