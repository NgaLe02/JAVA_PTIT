/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VaoRaFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author Dell E7440
 */
public class J07029 {

    public static boolean snt(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<Integer> a = (ArrayList<Integer>) in.readObject();
        HashMap<Integer, Integer> ma = new HashMap<>();
        for (Integer x : a) {
            if (snt(x)) {
                if (ma.containsKey(x)) {
                    ma.put(x, ma.get(x) + 1);
                } else {
                    ma.put(x, 1);
                }
            }
        }
        LinkedList<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(ma.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> t, Map.Entry<Integer, Integer> t1) {
                return t1.getKey() - t.getKey();
            }
        });
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for(Map.Entry<Integer, Integer> x : list){
            temp.put(x.getKey(), x.getValue());
        }
        int dem = 0;
        for(Map.Entry<Integer, Integer> en : temp.entrySet()){
            System.out.println(en.getKey() + " " + en.getValue());
            dem++;
            if(dem == 10) break;
        }
    }
}
