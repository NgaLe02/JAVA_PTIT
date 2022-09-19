/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Khai_bao_lop_va_doi_tuong;

import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class Pair<K, V> {

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public boolean isPrime() {
        int x = Integer.parseInt(String.valueOf(key));
        int y = Integer.parseInt(String.valueOf(value));
        if (x < 2 || y < 2) {
            return false;
        }

        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        for (int j = 2; j * j <= y; j++) {
            if (y % j == 0) {
                return false;
            }
        }
        
        return true;
    }

    @Override
    public String toString() {
        return key + " " + value;
    }
    
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
