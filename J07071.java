/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J07071 implements Comparable<J07071> {

    private String ten, ho, tenDem, hoTen, vietTat;

    public J07071(String s) {
        this.hoTen = s;

        String[] t = s.split("\\s+");

        this.ten = t[t.length - 1];

        this.ho = t[0];

        String tmp = "";
        for (int i = 1; i < t.length - 1; i++) {
            tmp = tmp + t[i] + " ";
        }
        this.tenDem = tmp.trim();

        tmp = "";
        for (String x : t) {
            tmp += x.charAt(0) + ".";
        }

        this.vietTat = tmp.substring(0, tmp.length() - 1);
    }

    @Override
    public int compareTo(J07071 t) {
        if (t.ten.compareTo(ten) != 0) {
            return ten.compareTo(t.ten);
        }
        return ho.compareTo(t.ho);
    }

    @Override
    public String toString() {
        return hoTen;
    }

    public static String chuanHoa(String s) {
        s = s.trim().toLowerCase();
        String[] words = s.split("\\s+");
        s = "";
        for (String x : words) {
            s += String.valueOf(x.charAt(0)).toUpperCase() + x.substring(1);
            s += " ";
        }
        return s.trim();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("D:\\DANHSACH.in"));
        ArrayList<J07071> a = new ArrayList<J07071>();
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            a.add(new J07071(chuanHoa(sc.nextLine())));
        }

        Collections.sort(a);
//        for (J07071 x : a) {
//            System.out.println(x);
//        }
        int m = Integer.parseInt(sc.nextLine());
        int dem = 0, cnt = 0;
        while (m-- > 0) {
            String s = sc.nextLine();
            cnt = (s.length() + 1) / 2;
            for (J07071 x : a) {
                dem = 0;
                if (s.length() == x.vietTat.length()) {
                    for (int i = 0; i < s.length(); i += 2) {
                        if (s.charAt(i) == x.vietTat.charAt(i)) {
                            dem++;
                        }
                    }
                    if (dem >= cnt - 1) {
                        System.out.println(x);
                    }
                }
            }
        }
    }
}
