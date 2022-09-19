/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Khai_bao_lop_va_doi_tuong;

import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J04005 {
    private String name, date;
    private float score;

    public J04005() {
    }

    public J04005(String name, String date, float score) {
        this.name = name;
        this.date = date;
        this.score = score;
    }

    @Override
    public String toString() {
        String diem = String.format("%.1f", score);
        return name + " " + date + " " + diem;
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String date = sc.next();
        float x = sc.nextFloat();
        float y = sc.nextFloat();
        float z = sc.nextFloat();
        J04005 thiSinh = new J04005(name, date, x + y + z);
        
        System.out.println(thiSinh.toString());
    }
}
