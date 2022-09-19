/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XauKiTu;

import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Dell E7440
 */
public class J03009 {
    static TreeSet<String> a = new TreeSet<String>();
    static TreeSet<String> b = new TreeSet<String>();
    
    public static void solve(String s1, String s2) {
        String[] word1 = s1.split("\\s+");
        String[] word2 = s2.split("\\s+");
        for(String x : word1) {
            a.add(x);
        }
        for(String x : word2) {
            b.add(x);
        }
        for(String x : a) {
            if(b.contains(x) == false) {
                System.out.print(x + " ");
            }
        } 
        a.clear();
        b.clear();
        System.out.println("");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            
            solve(s1, s2);
        }
    }
}
