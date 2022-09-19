/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XauKiTu;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J07003 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        String s = sc.nextLine();
        while (true) {
            int n = (int) s.length() / 2;
            BigInteger a = new BigInteger(s.substring(0, n));
            BigInteger b = new BigInteger(s.substring(n));
            BigInteger c = a.add(b);
            s = c.toString();
            System.out.println(s);
            if (c.compareTo(BigInteger.TEN) == -1) {
                break;
            }
        }
    }
}
