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
public class Giai_phuong_trinh_bac_nhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a == 0 && b == 0) {
            System.out.println("VSN");
        }
        else if(a == 0 && b != 0) {
            System.out.println("VN");
        }
        else {
            float c = (float) -b / a;
            System.out.printf("%.2f", c);
        }
    }
}
