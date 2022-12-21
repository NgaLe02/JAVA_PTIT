/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VaoRaFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class DocFileVanBan {
    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("src\\VaoRaFile\\DATA.in");
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
    }
}
