/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LapTrinhJavaCoBan;

import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class So_nguyen_to {
    public static int snt(int n) {
        if(n <= 2) return 0;
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) return 0; 
        }
        return 1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            if(snt(n) == 1) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }       
    }    
}
