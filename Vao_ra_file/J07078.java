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
public class J07078 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("STRING.in"));
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            String s = sc.nextLine();
            String t = sc.nextLine();
            int i = 0;
            while (s.indexOf(t, i) != -1) {
                System.out.print((s.indexOf(t, i) + 1) + " ");
                i = s.indexOf(t, i) + 1;
                if (i >= s.length()) {
                    break;
                }
            }
            System.out.println("");
        }
    }
}
