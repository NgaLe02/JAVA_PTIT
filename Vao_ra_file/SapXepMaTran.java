/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VaoRaFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class SapXepMaTran {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/VaoRaFile/MATRIX.in"));
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n, m, i;
            n = Integer.parseInt(sc.next());
            m = Integer.parseInt(sc.next());
            i = Integer.parseInt(sc.next());
            int[][] a = new int[n + 1][m + 1];
            for(int k= 1; k<= n; k++){
                for(int j = 1; j <= m; j++){
                    a[k][j] = Integer.parseInt(sc.next());
                }
            }
            
            for(int k = 1; k < n; k++){
                for(int j = k + 1; j <= n; j++){
                    if(a[j][i] < a[k][i]){
                        int temp = a[k][i];
                        a[k][i] = a[j][i];
                        a[j][i] = temp;
                    }
                }
            }
            
            for(int k = 1; k <= n; k++){
                for(int j = 1; j <= m; j++){
                    System.out.print(a[k][j] + " ");
                }
                System.out.println("");
            }
        }
    }
}
