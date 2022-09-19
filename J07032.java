package VaoRaFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class J07032 {
    public static boolean tn(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean check(String s) {
        if (s.length() <= 1) {
            return false;
        }
        if (s.length() % 2 == 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) - '0') % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ArrayList<Integer> a = (ArrayList<Integer>) in.readObject();

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (Integer x : a) {
            if(check(String.valueOf(x)) && tn(String.valueOf(x))){
                if (map.containsKey(x)) {
                    map.put(x, map.get(x) + 1);
                } else {
                    map.put(x, 1);
                }
            }
        }

        in = new ObjectInputStream(new FileInputStream("DATA2.in"));
        a = (ArrayList<Integer>) in.readObject();

        TreeSet<Integer> set = new TreeSet<>();

        for (Integer x : a) {
            if (map.containsKey(x)) {
                set.add(x);
                map.put(x, map.get(x) + 1);
            }
        }

        int cnt = 0;
        for (Integer x : set) {
            System.out.println(x + " " + map.get(x));
            ++cnt;
            if (cnt == 10) {
                break;
            }
        }
    }
}
