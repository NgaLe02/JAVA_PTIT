/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VaoRaFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Dell E7440
 */
public class WordSet {

    TreeSet<String> se;

    public WordSet(String s) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(s));
        TreeSet<String> tmp = new TreeSet<>();
        while (sc.hasNext()) {
            tmp.add(sc.next().toLowerCase());
        }
        this.se = tmp;
    }

    public String intersection(WordSet another) {
        TreeSet<String> tmp = new TreeSet<>();
        for (String x : se) {
            if (another.se.contains(x)) {
                tmp.add(x);
            }
        }
        String s = "";
        for (String x : tmp) {
            s += x + " ";
        }
        return s.trim();
    }

    public String union(WordSet another) {
        TreeSet<String> tmp = new TreeSet<>();
        for (String x : se) {
            tmp.add(x);
        }
        for (String x : another.se) {
            tmp.add(x);
        }
        String s = "";
        for (String x : tmp) {
            s += x + " ";
        }
        return s.trim();
    }

    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("src/VaoRaFile/DATA1.in");
        WordSet s2 = new WordSet("src/VaoRaFile/DATA2.in");
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
