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
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class TenVietTat implements Comparable<TenVietTat>{
    String fullName, shortName, ten, ho;

    public TenVietTat(String fullName) {
        this.fullName = fullName;
        String[] words = fullName.split("\\s+");
        ten = words[words.length - 1];
        ho = words[0];
        shortName = "";
        for(int i = 0; i < words.length - 1; i++){
            shortName += String.valueOf(words[i].charAt(0)) + ".";
        }
        shortName += words[words.length - 1].charAt(0);
    }

    @Override
    public String toString() {
        return fullName;
    }
    
    public static boolean check(String a, String b){
        if(a.length() != b.length()) return false;
        boolean hasStar = false;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) == '*') hasStar = true;
        }
        int dem = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                dem++;
            }
        }
        if(dem == 0) return true;
        if(dem == 1 && hasStar) return true;
        return false;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/VaoRaFile/DANHSACH.in"));
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<TenVietTat> a = new ArrayList<>();
        for(int i = 0; i < t; i++){
            a.add(new TenVietTat(sc.nextLine()));
        }
        Collections.sort(a);
        t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            String find = sc.nextLine();
            for(TenVietTat x : a){
                if(check(find, x.shortName)){
                    System.out.println(x.fullName);
                }
            }
        }

//         for(TenVietTat x : a){
//             System.out.println(x);
//         }
    }

    @Override
    public int compareTo(TenVietTat t) {
        if(ten.compareTo(t.ten) != 0) {
            return ten.compareTo(t.ten);
        }
        return ho.compareTo(t.ho);
    }
}
