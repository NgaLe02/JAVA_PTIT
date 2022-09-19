/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Dell E7440
 */
public class WordSet {

    private TreeSet<String> se;

    public WordSet(TreeSet<String> se) {
        this.se = se;
    }

    public WordSet(String s) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(s));
        TreeSet<String> set = new TreeSet<>();
        while (sc.hasNext()) {
            set.add(sc.next().toLowerCase());
        }
        this.se = set;
    }

    public WordSet union(WordSet another) {
        TreeSet<String> ans = new TreeSet<>();
        for (String x : se) {
            ans.add(x);
        }
        for (String x : another.se) {
            ans.add(x);
        }
        return new WordSet(ans);
    }

    public WordSet intersection(WordSet another) {
        TreeSet<String> ans = new TreeSet<>();
        for (String x : se) {
            if (another.se.contains(x)) {
                ans.add(x);
            }
        }
        return new WordSet(ans);
    }

    @Override
    public String toString() {
        String t = "";
        for (String x : se) {
            t += x + " ";
        }
        return t.trim();
    }

    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
