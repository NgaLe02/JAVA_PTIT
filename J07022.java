/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Dell E7440
 */
public class J07022 {

    public static int check(String s) {
        if (s.length() > 9) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return 0;
            }
        }
        return 1;
    }

    public static boolean check2(String s) {
        try {
            Integer.parseInt(s);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("D:\\DATA.in"));
        ArrayList<String> a = new ArrayList<>();
        while (sc.hasNext()) {
            String s = sc.next();
//            if (check(s) == 0) {
//                a.add(s);
//            } else {
//                int x = Integer.parseInt(s);
//                if (x > 2147483647) {
//                    a.add(s);
//                }
//            }
            if (check2(s)) {
                a.add(s);
            }
        }
        Collections.sort(a);
        for (String x : a) {
            System.out.print(x + " ");
        }
    }
}
