/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Khai_bao_lop_va_doi_tuong;

import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class Matrix {

    private int[][] mat;
    private int x, y;

    public Matrix(int x, int y) {
        mat = new int[x][y];
        this.x = x;
        this.y = y;
    }

    public void nextMatrix(Scanner sc) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
    }

    public Matrix mul(Matrix another) {
        Matrix res = new Matrix(this.x, another.y);
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < another.y; j++) {
                res.mat[i][j] = 0;
                for (int k = 0; k < this.y; k++) {
                    res.mat[i][j] += this.mat[i][k] * another.mat[k][j];
                }
            }
        }
        return res;
    }

    public Matrix trans() {
        Matrix tmp = new Matrix(y, x);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                tmp.mat[j][i] = mat[i][j];
            }
        }
        return tmp;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                res += this.mat[i][j] + " ";
            }
            res += "\n";
        }
        return res;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(), m = sc.nextInt(), p = sc.nextInt();
//        Matrix a = new Matrix(n,m);
//        a.nextMatrix(sc);
//        Matrix b = new Matrix(m,p);
//        b.nextMatrix(sc);
//        System.out.println(a.mul(b));
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            Matrix a = new Matrix(n, m);
            a.nextMatrix(sc);
            Matrix b = a.trans();
            System.out.println(a.mul(b));
        }
    }
}
