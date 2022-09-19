/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J07011 {

    public static class map implements Comparable<map> {

        private String x;
        private int y;

        public map(String x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(map t) {
            if (t.y != y) {
                return t.y - y;
            }
            return x.compareTo(t.x);
        }

        @Override
        public String toString() {
            return x + " " + y;
        }

    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(new File("D:\\VANBAN.in"));
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, Integer> m = new HashMap<String, Integer>();
        while (n-- > 0) {
            String[] s = sc.nextLine().split("[ ,.?!:;()/]+");

            for (String x : s) {
                if (m.containsKey(x.toLowerCase())) {
                    m.put(x.toLowerCase(), m.get(x.toLowerCase()) + 1);
                } else {
                    m.put(x.toLowerCase(), 1);
                }
            }
        }

        ArrayList<map> a = new ArrayList<>();

        for (Map.Entry<String, Integer> x : m.entrySet()) {
            a.add(new map(x.getKey(), x.getValue()));
        }

        Collections.sort(a);

        for (map x : a) {
            System.out.println(x);
        }
    }
}
