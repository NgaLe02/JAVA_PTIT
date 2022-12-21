package VaoRaFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Dell E7440
 */
class WordSet1 {

    String s;

    public WordSet1(String s) {
        this.s = s;
    }

    public void solve() throws FileNotFoundException {
        File file = new File("src/VaoRaFile/" + this.s);
        Scanner sc = new Scanner(file);
        TreeSet<String> se = new TreeSet();
        while (sc.hasNext()) {
            se.add(sc.next().toLowerCase());
        }
        
        String ans = "";
        for (String x : se) {
            ans += x + "\n";
        }
        this.s = ans.trim();
    }
    
    @Override
    public String toString() {
        try {
            solve();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WordSet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
}

public class LietKeTuKhacNhau {

    public static void main(String[] args) throws IOException {
        WordSet1 ws = new WordSet1("VANBAN.in");
        System.out.println(ws);
    }
}
