/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VaoRaFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class ChuanHoaVaSapXep {
    public static String chuanHoa(String s){
        s = s.toLowerCase().trim();
        String t = "";
        String[] words = s.split("\\s+");
        for(String x : words){
            t += String.valueOf(x.charAt(0)).toUpperCase() + x.substring(1) + " ";
        }
        return t.trim();
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        ArrayList<String> a = new ArrayList<>();
        while(sc.hasNextLine()){
            a.add(chuanHoa(sc.nextLine()));
        }
       
    }
}
