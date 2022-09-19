/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang;

import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class ma_tran_nhi_phan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int ans = 0, dem;
        for(int i = 0; i < n; i++) {
            dem = 0;
            for(int j = 0; j < 3; j++) {
                if(a[i][j] == 1) dem++;
            }
            if(dem > 1) ans++;
        }
        System.out.println(ans);
    }
}
