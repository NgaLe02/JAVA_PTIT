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
public class J03039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        while(t-- > 0) {
            String a = sc.next();
            String b = sc.next();
            BigInteger x = new BigInteger(a);
            BigInteger y = new BigInteger(b);
            BigInteger z = new BigInteger("0");
            if(x.mod(y).equals(z) || y.mod(x).equals(z)) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
