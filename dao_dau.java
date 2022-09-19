/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class dao_dau {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int sum = 0;
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
            sum += a.get(i);
        }
        Collections.sort(a);
        while (k-- > 0 && a.size() > 0) {
            int x = a.get(0);
            System.out.println(x);
            a.remove(0);
            sum -= 2 * x;
        }
        System.out.println(sum);
    }
}
