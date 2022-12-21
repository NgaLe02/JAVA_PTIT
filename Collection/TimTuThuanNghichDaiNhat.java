/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class TimTuThuanNghichDaiNhat {

    public static boolean tn(String s) {
        String t = "";
        for (int i = 0; i < s.length(); i++) {
            t = s.charAt(i) + t;
        }
        if (t.equals(s)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, Integer> ma = new LinkedHashMap<>();
        int lonNhat = 0;

        while (sc.hasNext()) {
            String s = sc.next();
            if (tn(s)) {
                if (ma.containsKey(s)) {
                    ma.put(s, ma.get(s) + 1);
                } else {
                    if (s.length() > lonNhat) {
                        lonNhat = s.length();
                    }
                    ma.put(s, 1);
                }
            }

        }
        for (Map.Entry<String, Integer> en : ma.entrySet()) {
            if (en.getKey().length() == lonNhat) {
                System.out.println(en.getKey() + " " + en.getValue());
            }
        }
    }
}