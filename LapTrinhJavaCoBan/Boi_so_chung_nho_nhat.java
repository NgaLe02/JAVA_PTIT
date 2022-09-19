/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LapTrinhJavaCoBan;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class Boi_so_chung_nho_nhat {
    public static BigInteger lcm(BigInteger x, BigInteger y) {
        return x.divide(x.gcd(y)).multiply(y);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            
            BigInteger x = new BigInteger(a);
            BigInteger y = new BigInteger(b);
            
            System.out.println(lcm(x, y));
        }
    }
}
