/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XauKiTu;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J03010 {
    static HashMap<String, Integer> ma = new HashMap<String, Integer>();
    public static String chuanHoaTen(String ten) {
        ten = ten.toLowerCase().trim();
        String[] arr = ten.split("\\s+");
        String s = "";
        s += arr[arr.length - 1];
        for(int i = 0; i < arr.length - 1; i++) {
            s += arr[i].charAt(0);
        }
        if(ma.containsKey(s) == false) {
            ma.put(s, 1);
        }
        else {
            int x = ma.get(s);
            x++;
            ma.put(s, x);
            s += x + "";
        }
        return s.toString();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            System.out.println(chuanHoaTen(s) + "@ptit.edu.vn");
        }
    }
}
