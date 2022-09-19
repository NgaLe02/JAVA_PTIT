/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XauKiTu;

import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J03032 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            String s = sc.nextLine();
            String[] word = s.split("\\s+");
            for(String x : word) {
                StringBuilder sb = new StringBuilder(x);
                System.out.print(sb.reverse().toString() + " ");
            }
            System.out.println("");
        }
    }
}
