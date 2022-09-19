/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Khai_bao_lop_va_doi_tuong;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class DaThuc {
    private int[] a = new int[10001];
    
    public DaThuc(String s) {
        this.a = new int[10001];
        String[] words = s.split(" + ");
        for(String x : words) {
            int a = Integer.parseInt(String.valueOf(x.charAt(0)));
            int b = Integer.parseInt(String.valueOf(x.charAt(4)));
            this.a[b] = a;
        }
    }

    public DaThuc() {
    }
    
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            DaThuc p = new DaThuc(sc.nextLine());
            DaThuc q = new DaThuc(sc.nextLine());
            //DaThuc r = p.cong(q);
           // System.out.println(r);
        }
    }
}
