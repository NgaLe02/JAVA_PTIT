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
public class J03040 {

    public static int check1(String dau, String cuoi) {
        String tong = dau + cuoi + "";
        for (int i = 0; i < 4; i++) {
            if (tong.charAt(i + 1) <= tong.charAt(i)) {
                return 0;
            }
        }
        return 1;
    }

    public static int check2(String dau, String cuoi) {
        String tong = dau + cuoi + "";
        for (int i = 0; i < 4; i++) {
            if (tong.charAt(i + 1) != tong.charAt(i)) {
                return 0;
            }
        }
        return 1;
    }

    public static int check3(String dau, String cuoi) {
        for(int i = 0; i < 2; i++) {
            if(dau.charAt(i + 1) != dau.charAt(i)) return 0;
        }
        if(cuoi.charAt(0) != cuoi.charAt(1)) return 0;
        return 1;
    }
    
    public static int check4(String dau, String cuoi) {
        String tong = dau + cuoi + "";
        for(int i = 0; i < 5; i++) {
            if(tong.charAt(i) != '6' && tong.charAt(i) != '8') return 0;
        }       
        return 1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            String s = sc.next();
            String[] words = s.split("-");
            String[] numbers = words[1].split("[.]");
            String dau = numbers[0];
            String cuoi = numbers[1];
            if(check1(dau, cuoi) == 1 || check2(dau, cuoi) == 1
               || check3(dau, cuoi) == 1 || check4(dau, cuoi) == 1) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}