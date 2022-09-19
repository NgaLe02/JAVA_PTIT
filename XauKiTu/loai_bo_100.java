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
public class loai_bo_100 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while (n-- > 0) {
            String s = sc.nextLine();
            int len = 0;
            while (s.contains("100")) {
                int ind = s.indexOf("100");
                len += 3;
                String t = s.substring(0, ind) + s.substring(ind + 3);
                s = t;
            }
            System.out.println(len);
        }
    }
}
