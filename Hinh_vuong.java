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
public class Hinh_vuong {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b1 = sc.nextInt();
        int b2 = sc.nextInt();
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();
        int d1 = sc.nextInt();
        int d2 = sc.nextInt();
        int n1 = Math.min(a2, c2);
        int n2 = Math.max(b2, d2);
        int n3 = Math.min(a1, c1);
        int n4 = Math.max(b1, d1);
        int x = Math.max((n2 - n1), (n4 - n3));
        System.out.println(x * x);
    }
}
