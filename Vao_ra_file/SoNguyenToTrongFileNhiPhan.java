package VaoRaFile;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Dell E7440
 */
public class SoNguyenToTrongFileNhiPhan {

    public static boolean snt(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return n > 1;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("SONGUYEN.in"));
        ArrayList<Integer> a = (ArrayList<Integer>) in.readObject();
        TreeMap<Integer, Integer> ma = new TreeMap<>();
        for (int x : a) {
            if (snt(x)) {
                if (ma.containsKey(x)) {
                    ma.put(x, ma.get(x) + 1);
                } else {
                    ma.put(x, 1);
                }
            }
        }
        for (Map.Entry<Integer, Integer> en : ma.entrySet()) {
            System.out.println(en.getKey() + " " + en.getValue());
        }
    }
}
