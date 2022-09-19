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
public class J03027 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        while (true) {
            int check = 0;
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    check = 1;
                    s = s.substring(0, i) + s.substring(i + 2);
                }
            }
            if (check == 0) {
                break;
            }
        }
        if (s.length() == 0) {
            System.out.println("Empty String");
        } else {
            System.out.println(s);
        }
    }
}
