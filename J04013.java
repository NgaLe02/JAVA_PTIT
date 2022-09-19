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
public class J04013 {

    private String ID, name, state;
    private double score, priority;

    public J04013() {
    }

    public J04013(String ID, String name, double score) {
        this.ID = ID;
        this.name = name;
        this.score = score;
    }

    public String getID() {
        return ID;
    }

    public void setState() {
        double tong = priority + score;
        if (tong >= 24) {
            this.state = "TRUNG TUYEN";
        } else {
            this.state = "TRUOT";
        }
    }

    public void setPriority() {
        String s = ID.substring(0, 3);
        if (s.equals("KV1")) {
            this.priority = 0.5;
        } else if (s.equals("KV2")) {
            this.priority = 1;
        } else {
            this.priority = 2.5;
        }
    }

    @Override
    public String toString() {
        String s1 = "";
        if ((int) priority == priority) {
            s1 = (int) priority + "";
        } else { 
            s1 = String.format("%.1f", priority);
        }
        String s2 = "";
        if ((int) score == score) {
            s2 = (int)score + "";
        } else { 
            s2 = String.format("%.1f", score);
        }
        return ID + " " + name + " " + s1 + " " + s2 + " " + state;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ID = sc.nextLine();
        String name = sc.nextLine();
        double mon1 = sc.nextDouble();
        double mon2 = sc.nextDouble();
        double mon3 = sc.nextDouble();
        J04013 a = new J04013(ID, name, mon1 * 2 + mon2 + mon3);
        a.setPriority();
        a.setState();
        System.out.println(a.toString());
    }

}
