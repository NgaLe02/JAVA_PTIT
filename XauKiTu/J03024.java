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
public class J03024 {
    
    public static int check(String s) {
        if(s.charAt(0) == '0') return -1;
        int demc = 0, deml = 0;
        for(int i = 0; i < s.length(); i++) {
            int x  = Character.getNumericValue(s.charAt(i));
            if(x > 9) return -1;
            if(x % 2 == 0) demc++;
            else deml++;
        }
        if(s.length() % 2 == 0 && demc > deml) return 1;
        if(s.length() % 2 == 1 && demc < deml) return 1;
        return 0;
    }
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            String s = sc.next();
            if(check(s) == 1) {
                System.out.println("YES");
            }
            else if(check(s) == 0){
                System.out.println("NO");
            }
            else {
                System.out.println("INVALID");
            }
        }
    }
}
