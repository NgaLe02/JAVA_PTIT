/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J07076 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MATRIX.in"));
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.next());
            int m = Integer.parseInt(sc.next());
            int i = Integer.parseInt(sc.next());
            int[][] a = new int[n + 1][m + 1];
            for (int l = 1; l <= n; l++) {
                for (int j = 1; j <= m; j++) {
                    a[l][j] = Integer.parseInt(sc.next());
                }
            }
            for (int l = 1; l < n; l++) {
                for (int k = l + 1; k <= n; k++) {
                    if (a[l][i] > a[k][i]) {
                        int tmp = a[k][i];
                        a[k][i] = a[l][i];
                        a[l][i] = tmp;
                    }
                }
            }
            for (int l = 1; l <= n; l++) {
                for (int j = 1; j <= m; j++) {
                    System.out.print(a[l][j] + " ");
                }
                System.out.println("");
            }
        }
    }
}
