/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XauKiTu;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J03015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        BigInteger x = new BigInteger(a);
        BigInteger y = new BigInteger(b);
        BigInteger z = x.subtract(y);
        System.out.println(z);
    }
}
