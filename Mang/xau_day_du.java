/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang;

import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Dell E7440
 */
public class xau_day_du {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            String s = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine());
            TreeSet<Character> tree = new TreeSet<>();
            for(int i = 0; i < s.length(); i++) {
                tree.add(s.charAt(i));
            }
            if(k >= 26 - tree.size()) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
