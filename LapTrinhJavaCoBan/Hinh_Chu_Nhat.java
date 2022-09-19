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
public class Hinh_Chu_Nhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dai, rong;
        dai = sc.nextInt();
        rong = sc.nextInt();
        if(dai <= 0 || rong <= 0) {
            System.out.println("0\n");
        }
        else {
            System.out.println(2 * (dai + rong) + " " + dai * rong);
        }
    }
}
