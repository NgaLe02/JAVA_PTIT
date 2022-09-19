package Vao_Ra_File;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class WordSet1 {
    private TreeSet<String> set;

    public WordSet1(String s) throws IOException {
        File file = new File(s);
        Scanner sc = new Scanner(file);
        TreeSet<String> set = new TreeSet<>();
        while (sc.hasNext()) {
            set.add(sc.next().toLowerCase());
        }
        this.set = set;
    }

    @Override
    public String toString() {
        String res = "";
        for (String x : set) {
            res += x + "\n";
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        WordSet1 ws = new WordSet1("VANBAN.in");
        System.out.println(ws);
    }
}

