/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class day_con_tang_dan {

    static int n;
    static ArrayList<Integer> a = new ArrayList<>();
    static int[] x = new int[21];
    static ArrayList<String> ans = new ArrayList<>();
    static ArrayList<Integer> tmp = new ArrayList<>();

    public static int check() {
        tmp.clear();
        for (int i = 1; i <= n; i++) {
            if (x[i] == 1) {
                tmp.add(a.get(i));
            }
        }
        if (tmp.size() < 2) {
            return 0;
        }

        for (int i = 0; i < tmp.size() - 1; i++) {
            if (tmp.get(i) >= tmp.get(i + 1)) {
                return 0;
            }
        }
        return 1;
    }

    public static void update() {
        String s = "";
        for (int i = 0; i < tmp.size(); i++) {
            s = s + tmp.get(i) + " ";
        }
        ans.add(s);
    }

    public static void in() {
        Collections.sort(ans);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    public static void backtrack(int i) {
        for (int j = 0; j <= 1; j++) {
            x[i] = j;
            if (i == n) {
                if (check() == 1) {
                    update();
                }
            } else {
                backtrack(i + 1);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("DAYSO.in");
        Scanner sc = new Scanner(file);
        while(sc.hasNext()) {
            int x = sc.nextInt();
            a.add(x);
        }
        n = a.get(0);
        a.remove(0);
        backtrack(1);
        in();
    }
}
