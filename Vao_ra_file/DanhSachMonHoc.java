package VaoRaFile;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell E7440
 */

class Monhoc implements Comparable<Monhoc>{
    String ma, ten, soTC;

    public Monhoc(String ma, String ten, String soTC) {
        this.ma = ma;
        this.ten = ten;
        this.soTC = soTC;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + soTC;
    }

    @Override
    public int compareTo(Monhoc t) {
        return ten.compareTo(t.ten);
    }
    
}
public class DanhSachMonHoc {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<Monhoc> a = new ArrayList<>();
        for(int i = 0; i < t; i++){
            a.add(new Monhoc(sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        Collections.sort(a);
        for(Monhoc x : a){
            System.out.println(x);
        }
    }
}
