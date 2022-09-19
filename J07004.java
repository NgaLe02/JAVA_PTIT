/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Dell E7440
 */
public class J07004 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("DATA.in");
        Scanner sc = new Scanner(file);
        TreeMap<Integer, Integer> ma = new TreeMap<Integer, Integer>();
        while (sc.hasNextInt()) {
            int x = sc.nextInt();
            if (ma.containsKey(x)) {
                int y = ma.get(x);
                y++;
                ma.put(x, y);
            } else {
                ma.put(x, 1);
            }
        }
        
        Set<Integer> keySet = ma.keySet();
        for (Integer key : keySet) {
            System.out.println(key + " " + ma.get(key));
        }
    }
}