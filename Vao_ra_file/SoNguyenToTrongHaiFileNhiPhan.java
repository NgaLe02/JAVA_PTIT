package VaoRaFile;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dell E7440
 */
public class SoNguyenToTrongHaiFileNhiPhan {

    public static boolean snt(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return n > 1;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ArrayList<Integer> a = (ArrayList<Integer>) in.readObject();
        TreeMap<Integer, Integer> ma1 = new TreeMap<>();
        for (Integer x : a) {
            if (snt(x)) {
                if (ma1.containsKey(x)) {
                    ma1.put(x, ma1.get(x) + 1);
                } else {
                    ma1.put(x, 1);
                }
            }
        }
        
        in = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> b = (ArrayList<Integer>) in.readObject();
        TreeMap<Integer, Integer> ma2 = new TreeMap<>();
        for (Integer x : b) {
            if (snt(x)) {
                if (ma2.containsKey(x)) {
                    ma2.put(x, ma2.get(x) + 1);
                } else {
                    ma2.put(x, 1);
                }
            }
        }
        
        TreeSet<Integer> set = new TreeSet<>(a);
        for(Integer x : set){
            if(ma1.containsKey(x) && ma2.containsKey(x)){
                System.out.println(x + " " + ma1.get(x) + " " + ma2.get(x));
            }
        }
    }
}
