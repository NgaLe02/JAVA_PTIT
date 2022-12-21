/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VaoRaFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Dell E7440
 */
public class DanhSachCaThi implements Comparable<DanhSachCaThi>{
    String ma, ngay, gio, ID;
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat hour = new SimpleDateFormat("HH:mm");
    Date day = null, time1 = null;
    
    public DanhSachCaThi(int ma, String ngay, String gio, String ID) throws ParseException {
        this.ma = String.format("C%03d", ma);
        this.ngay = ngay;
        day = date.parse(ngay);
        this.gio = gio;
        time1 = hour.parse(gio);
        this.ID = ID;
    }

    
    @Override
    public String toString() {
        return this.ma + " " + this.ngay + " " + this.gio + " " + this.ID;
    }
    
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("src/VaoRaFile/CATHI.in"));
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<DanhSachCaThi> a = new ArrayList<>();
        for(int i = 0; i < t; i++){
            a.add(new DanhSachCaThi(i + 1, sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        Collections.sort(a);
        for(DanhSachCaThi x :a){
            System.out.println(x);
        }
    }
    
    @Override
    public int compareTo(DanhSachCaThi t) {
        if(this.day.compareTo(t.day) != 0){
            return this.day.compareTo(t.day);
        }
        else if(this.time1.compareTo(t.time1) != 0){
            return this.time1.compareTo(t.time1);
        }
        return ma.compareTo(t.ma);
    }

}
