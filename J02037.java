/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XauKiTu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J02037 {

    static ArrayList<Integer> a = new ArrayList<>();

    public static int check() {
        int c = 0, l = 0;
        for (Integer x : a) {
            if (x % 2 == 0) {
                c++;
            } else {
                l++;
            }
        }
        if (c > l && a.size() % 2 == 0) {
            return 1;
        }
        if (l > c && a.size() % 2 == 1) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] s = sc.nextLine().split("\\s+");
            for (String x : s) {
                a.add(Integer.parseInt(x));
            }
            if (check() == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            a.clear();
        }
    }
}
