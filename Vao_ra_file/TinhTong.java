/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VaoRaFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *z
 * @author Dell E7440
 */
public class TinhTong {
    public static int check(String s){
        if(s.length() > 9) return 0;
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i)) == false){
                return 0;
            }
        }
        return 1;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\Dell E7440\\OneDrive\\Documents\\NetBeansProjects\\OnTap\\src\\VaoRaFile\\DATA.in");
        Scanner sc = new Scanner(file);
        long tong = 0;
        while(sc.hasNext()){
            String s = sc.next();
            if(check(s) == 1){
                int x = Integer.parseInt(s);
                if (x <= 2147483647){
                    tong += x;
                }
            }
        }
        System.out.println(tong);
    }
}
