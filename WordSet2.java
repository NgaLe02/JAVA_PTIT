/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Dell E7440
 */
public class WordSet2 {
    private TreeSet<String>set;

    public WordSet2(TreeSet<String> set) {
        this.set = set;
    }
    
    public WordSet2(String s) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(s));
        TreeSet<String> set = new TreeSet<>();
        while (sc.hasNext()) {
            set.add(sc.next().toLowerCase());
        }
        this.set = set;
    }
    
    public WordSet2 difference(WordSet2 t){
        TreeSet<String> ans = new TreeSet<>();
        for(String x : set) {
            if(!t.set.contains(x)) {
                ans.add(x);
            }
        }
        return new WordSet2(ans);
    }

    @Override
    public String toString() {
        String t = "";
        for(String x : set) {
            t += x + " ";
        }
        return t.trim();
    }
    
    public static void main(String[] args) throws IOException {
        WordSet2 s1 = new WordSet2("DATA1.in");
        WordSet2 s2 = new WordSet2("DATA2.in");
        System.out.println(s1.difference(s2));
        System.out.println(s2.difference(s1));
    }
}
