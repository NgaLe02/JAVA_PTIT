/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J07001 {

    public static void main(String[] args) throws Exception {
        File file = new File("DATA.in");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}
