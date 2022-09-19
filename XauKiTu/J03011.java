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
public class J03011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            BigInteger x = new BigInteger(a);
            BigInteger y = new BigInteger(b);
            System.out.println(x.gcd(y));
        }
    }
}
