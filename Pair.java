/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class Pair<a, b> {

    private a key;
    private b value;

    public Pair(a key, b value) {
        this.key = key;
        this.value = value;
    }

    public static boolean snt(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrime() {
        int t = Integer.parseInt(String.valueOf(key));
        int t1 = Integer.parseInt(String.valueOf(value));
        if (snt(t) && snt(t1)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return key + " " + value;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            boolean check = false;
            for (int i = 2; i <= 2 * Math.sqrt(n); i++) {
                Pair<Integer, Integer> p = new Pair<>(i, n - i);
                if (p.isPrime()) {
                    System.out.println(p);
                    check = true;
                    break;
                }
            }
            if (!check) {
                System.out.println(-1);
            }
        }
    }
}
