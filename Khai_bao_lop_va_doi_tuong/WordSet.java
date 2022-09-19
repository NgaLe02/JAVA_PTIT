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
public class WordSet {

    private TreeSet<String> w;

    public WordSet(String s) {
        this.w = new TreeSet<>();
        s = s.toLowerCase();
        String[] words = s.split("\\s+");
        for (String x : words) {
            this.w.add(x);
        }
    }

    public WordSet(TreeSet<String> w) {
        this.w = w;
    }

    
    public WordSet union(WordSet another) {
        TreeSet<String> hop = new TreeSet<>();
        for(String x : this.w) {
            hop.add(x);
        }
        for(String x : another.w) {
            hop.add(x);
        }
        return new WordSet(hop);
    }
    
    public WordSet intersection(WordSet another) {
        TreeSet<String> giao = new TreeSet<>();
        for(String x : this.w) {
            if(another.w.contains(x)) {
                giao.add(x);
            }
        }
        return new WordSet(giao);
    }

    @Override
    public String toString() {
        String res = "";
        for(String x : this.w) {
            res += x + " ";
        }
        return res.trim();
    }

    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
