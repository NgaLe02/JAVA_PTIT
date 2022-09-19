/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Khai_bao_lop_va_doi_tuong;

import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Dell E7440
 */
public class IntSet {
    private TreeSet<Integer> set;

    public IntSet(int[] a) {
        this.set = new TreeSet<>();
        for (int i = 0; i < a.length; i++) {
            this.set.add(a[i]);
        }
    }

    public IntSet(TreeSet<Integer> set) {
        this.set = set;
    }

    public IntSet intersection(IntSet another) {
        // luu phan giao cua 2 mang
        TreeSet<Integer> res = new TreeSet<>();
        for (int x : this.set) {
            if (another.set.contains(x)) {
                res.add(x);
            }
        }
        return new IntSet(res);
    }

    public IntSet union(IntSet another) {
        TreeSet<Integer> res = new TreeSet<>();
        for (int x : this.set) {
            res.add(x);
        }
        for (int x : another.set) {
            res.add(x);
        }
        return new IntSet(res);
    }

    @Override
    public String toString() {
        String res = "";
        for (int x : this.set) {
            res += x + " ";
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        //IntSet s3 = s1.intersection(s2);
        IntSet s3 = s1.union(s2);
        System.out.println(s3);

    }
}
