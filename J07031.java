package VaoRaFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class J07031 {
    public static boolean nt(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return n > 1;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream sc = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ArrayList<Integer> ds1 = (ArrayList<Integer>) sc.readObject();

        LinkedHashMap<Integer, Integer> map1 = new LinkedHashMap<>();
        for (Integer x : ds1) {
            map1.put(x, 1);
        }

        sc = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> ds2 = (ArrayList<Integer>) sc.readObject();

        LinkedHashMap<Integer, Integer> map2 = new LinkedHashMap<>();

        for (Integer x : ds2) {
            map2.put(x, 1);
        }

        TreeSet<Integer> set = new TreeSet<>(ds1);

        for (Integer x : set) {
            if (x < 500000 && !map2.containsKey(x)) {
                int y = 1000000 - x;
                if (map1.containsKey(y) && !map2.containsKey(y) && nt(x) && nt(y)) {
                    System.out.println(x + " " + y);
                }
            }
        }
    }
}