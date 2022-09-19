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
public class bo_sung_day_so {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mem = 0;
        int ok = 0;
        while(n-- > 0) {
            int x = sc.nextInt();
            while(x - mem != 1) {
                ok = 1;
                System.out.println(mem + 1);
                mem++;
            }
            mem = x;
        }
        if(ok == 0) {
            System.out.println("Excellent!");
        }
    }
}
