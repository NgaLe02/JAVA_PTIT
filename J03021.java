/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XauKiTu;

import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J03021 {

    public static int check(String s) {
        String t = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'b' || s.charAt(i) == 'c') {
                t += "2";
            } else if (s.charAt(i) == 'd' || s.charAt(i) == 'e' || s.charAt(i) == 'f') {
                t += "3";
            } else if (s.charAt(i) == 'g' || s.charAt(i) == 'h' || s.charAt(i) == 'i') {
                t += "4";
            } else if (s.charAt(i) == 'j' || s.charAt(i) == 'k' || s.charAt(i) == 'l') {
                t += "5";
            } else if (s.charAt(i) == 'm' || s.charAt(i) == 'n' || s.charAt(i) == 'o') {
                t += "6";
            } else if (s.charAt(i) == 'p' || s.charAt(i) == 'q' || s.charAt(i) == 'r' || s.charAt(i) == 's') {
                t += "7";
            } else if (s.charAt(i) == 't' || s.charAt(i) == 'u' || s.charAt(i) == 'v') {
                t += "8";
            } else if (s.charAt(i) == 'w' || s.charAt(i) == 'x' || s.charAt(i) == 'y' || s.charAt(i) == 'z') {
                t += "9";
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != t.charAt(t.length() - 1 - i)) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.next();
            s = s.toLowerCase();
            if (check(s) == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
