package VaoRaFile;


import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.TreeSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Dell E7440
 */
public class CapSoNguyenToTrongFile1 {

    public static boolean snt(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return n > 1;
    }

    public static boolean check(int n) {
        String s = n + "";
        if (s.length() <= 1 || s.length() % 2 == 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) - '0') % 2 == 0) {
                return false;
            }
            if(s.charAt(i) != s.charAt(s.length() - i - 1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ArrayList<Integer> a1 = (ArrayList<Integer>) in.readObject();
        in = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> a2 = (ArrayList<Integer>) in.readObject();

        LinkedHashMap<Integer, Integer> ma = new LinkedHashMap<>();
        for (Integer x : a1) {
            if (check(x)) {
                if (ma.containsKey(x)) {
                    ma.put(x, ma.get(x) + 1);
                } else {
                    ma.put(x, 1);
                }
            }
        }
        TreeSet<Integer> se = new TreeSet<>();
        for (Integer x : a2) {
            if (ma.containsKey(x)) {
                se.add(x);
                ma.put(x, ma.get(x) + 1);
            }
        }
        int cnt = 0;
        for(Integer x : se){
            System.out.println(x + " " + ma.get(x));
            cnt++;
            if(cnt == 10) break;
        }
    }
}
