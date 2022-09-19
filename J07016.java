/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.TreeSet;

/**
 *
 * @author Dell E7440
 */
public class J07016 {

    public static int snt(int n) {
        if (n < 2) {
            return 0;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ArrayList<Integer> a = (ArrayList<Integer>) in.readObject();
        LinkedHashMap<Integer, Integer> map1 = new LinkedHashMap<Integer, Integer>();
        for (Integer x : a) {
            if (map1.containsKey(x)) {
                map1.put(x, map1.get(x) + 1);
            } else {
                map1.put(x, 1);
            }
        }

        in = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> b = (ArrayList<Integer>) in.readObject();
        LinkedHashMap<Integer, Integer> map2 = new LinkedHashMap<Integer, Integer>();
        for (Integer x : b) {
            if (map2.containsKey(x)) {
                map2.put(x, map2.get(x) + 1);
            } else {
                map2.put(x, 1);
            }
        }

        TreeSet<Integer> set = new TreeSet<>(a);
        for (Integer x : set) {
            if (snt(x) == 1 && map1.containsKey(x) && map2.containsKey(x)) {
                System.out.println(x + " " + map1.get(x) + " " + map2.get(x));
            }
        }
    }
}