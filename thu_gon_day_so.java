/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class thu_gon_day_so {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> b = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            b.add(x);
        }
        while (true) {
            int ind = 0;
            for (int i = 0; i < b.size() - 1; i++) {
                if ((b.get(i) + b.get(i + 1)) % 2 == 0) {
                    b.remove(i);
                    b.remove(i);
                    ind++;
                }
            }
            if (ind == 0) {
                break;
            }
        }
        System.out.println(b.size());
    }
}
