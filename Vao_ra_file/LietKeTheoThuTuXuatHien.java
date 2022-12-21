/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VaoRaFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class LietKeTheoThuTuXuatHien {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("NHIPHAN.in"));
        ArrayList<String> a = (ArrayList<String>) in.readObject();
        LinkedHashSet<String> se = new LinkedHashSet<>();
        for (String x : a) {
            String[] words = x.trim().toLowerCase().split("\\s+");
            for (String y : words) {
                se.add(y);
            }
        }

        Scanner sc = new Scanner(new File("VANBAN.in"));
//        LinkedHashSet<String> se2 = new LinkedHashSet<>();
        while(sc.hasNext()){
            String s = sc.next().toLowerCase();
            if(se.contains(s)){
                se.remove(s);
                System.out.println(s);
            }
        }
    }
}
