/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class LoaiBoSoNguyen {
    public static boolean check(String t){
        try{
            Integer.parseInt(t);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/VaoRaFile/DATA.in"));
        ArrayList<String> a = new ArrayList();
        while(sc.hasNext()){
            String t = sc.next();
            if(check(t) == false){
                a.add(t);
            }
        }
        Collections.sort(a);
        for(String x : a){
            System.out.print(x + " ");
        }
    }
}
