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
public class J03018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            String s = sc.next();
            BigInteger n = new BigInteger(s);
            BigInteger a = new BigInteger("4");
            BigInteger b = new BigInteger("0");
            if(n.mod(a).equals(b) == false) {
                System.out.println("0");
            }
            else {
                System.out.println("4");
            }
        }
    }
}
