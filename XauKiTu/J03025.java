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
public class J03025 {
    public static int check(String s) {
        int change = 0;
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) {
                if(change == 0) change = 1;
                else return 0;
            }
        }
        if(change == 0 && s.length() % 2 == 0) return 0;
        return 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            String s = sc.next();
            if(check(s) == 1) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
