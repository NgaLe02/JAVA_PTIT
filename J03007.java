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
public class J03007 {

    public static int check(String s) {
        int tong = 0;
        if (s.charAt(0) != '8' || s.charAt(s.length() - 1) != '8') {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            tong = tong + (s.charAt(i) - '0');
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return 0;
            }
        }
        if (tong % 10 != 0) {
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            if (check(s) == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
