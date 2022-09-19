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
public class J03004 {
    
    public static String chuanHoaTen(String ten) {
        ten = ten.toLowerCase().trim();
        String[] arr = ten.split("\\s+");
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s += String.valueOf(arr[i].charAt(0)).toUpperCase() + arr[i].substring(1);
            s += " ";
        }
        return s.toString();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            System.out.println(chuanHoaTen(s));
        }
    }
}
