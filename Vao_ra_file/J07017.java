/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VaoRaFile;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
class Pair<a, b> {

    a key;
    b value;

    public Pair(a key, b value) {
        this.key = key;
        this.value = value;
    }

    public boolean snt(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return n > 1;
    }

    public boolean isPrime() {
        int x1 = Integer.parseInt(String.valueOf(key));
        int x2 = Integer.parseInt(String.valueOf(value));
        if(snt(x1) && snt(x2)){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return key + " " + value;
    }
    
}

public class J07017 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("src/VaoRaFile/DATA.in"));
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
