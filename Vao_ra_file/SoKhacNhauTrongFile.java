package VaoRaFile;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dell E7440
 */
public class SoKhacNhauTrongFile {
    public static void main(String[] args) throws FileNotFoundException {
        File file  = new File("C:\\Users\\Dell E7440\\OneDrive\\Documents\\NetBeansProjects\\OnTap\\src\\VaoRaFile\\DATA.in");
        Scanner sc = new Scanner(file);
        TreeMap<Integer, Integer> ma = new TreeMap<>();
        while(sc.hasNext()){
            int s = Integer.parseInt(sc.next());
            if(ma.containsKey(s)){
                int x = ma.get(s);
                x++;
                ma.put(s, x);
            }
            else{
                ma.put(s, 1);
            }
        }
        Set<Integer> se = ma.keySet();
        for(int key : se){
            System.out.println(key + " " + ma.get(key));
        }
    }
}
