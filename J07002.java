/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J07002 {
   
    public static boolean check(String s) {
        if (s.length() > 9) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException  {
        File file = new File("DATA.in");
        Scanner sc = new Scanner(file);

        long tong = 0;
        while (sc.hasNext()) {
            String s1 = sc.next();
            if (check(s1)) {
                int s = Integer.parseInt(s1);
                if (s <= 2147483647) {
                    tong += s;
                }
            }
        }
        System.out.println(tong);
    }
}
