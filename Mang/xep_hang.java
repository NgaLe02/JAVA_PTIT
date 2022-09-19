/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import javafx.util.Pair;

/**
 *
 * @author Dell E7440
 */
public class xep_hang {

    public static class Pair {

        public int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }            
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] pi = new Pair[n];
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int d = sc.nextInt();
            pi[i] = new Pair(t, d);        
        }
        Arrays.sort(pi, new Comparator<Pair>() {
            @Override
            public int compare(Pair t, Pair t1) {
                if(t.x != t1.x) return t.x - t1.x;
                return t.y - t1.y;
            }           
        });
        int time = 0;
        for(int i = 0; i < n; i++) {
            if(time <= pi[i].x) time =pi[i].x + pi[i].y;
            else {
                time += pi[i].y;
            }
        }
        System.out.println(time);
    }
}
