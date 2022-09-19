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
public class Tinh_Tong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            long tong;
            if(n % 2 == 0) {
                tong = (long) n / 2 * (n + 1);
            }
            else {
                tong = (long) (n + 1) / 2 * n;
            }
            System.out.println(tong);
        }       
    }    
}
