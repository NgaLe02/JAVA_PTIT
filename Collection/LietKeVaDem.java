/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class LietKeVaDem {

    public static boolean skg(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) - '0' > s.charAt(i + 1) - '0') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, Integer> ma = new LinkedHashMap<>();

        while (sc.hasNext()) {
            String s = sc.next();
            if (s.equals("000")) {
                break;
            }
            if (skg(s)) {
                if (ma.containsKey(s)) {
                    ma.put(s, ma.get(s) + 1);
                } else {
                    ma.put(s, 1);
                }
            }

        }
        LinkedList<Map.Entry<String, Integer>> list = new LinkedList<>(ma.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> t, Map.Entry<String, Integer> t1) {
                return t1.getValue() - t.getValue();
            }
        });

        LinkedHashMap<String, Integer> tmp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> x : list) {
            tmp.put(x.getKey(), x.getValue());
        }
        for (Map.Entry<String, Integer> entry : tmp.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
