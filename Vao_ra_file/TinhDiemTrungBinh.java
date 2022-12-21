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
public class TinhDiemTrungBinh implements Comparable<TinhDiemTrungBinh> {

    String ma, hoTen;
    float diem;
    int xepHang;

    public TinhDiemTrungBinh(int ma, String hoTen, float diem) {
        this.ma = String.format("SV%02d", ma);
        this.hoTen = chuanHoa(hoTen);
        this.diem = diem;
    }

    @Override
    public String toString() {
        return ma + " " + hoTen + " " + String.format("%.2f", diem / 8) + " " + xepHang;
    }

    public static String chuanHoa(String s){
        String t = "";
        String[] words = s.toLowerCase().trim().split("\\s+");
        for(String x : words){
            t += String.valueOf(x.charAt(0)).toUpperCase() + x.substring(1) + " ";
        }
        return t.trim();
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/VaoRaFile/BANGDIEM.in"));
        ArrayList<TinhDiemTrungBinh> a = new ArrayList<>();
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            String ten = sc.nextLine();
            float x, y, z;
            x = Float.parseFloat(sc.nextLine());
            y = Float.parseFloat(sc.nextLine());
            z = Float.parseFloat(sc.nextLine());

            a.add(new TinhDiemTrungBinh(i + 1, ten, x * 3 + y * 3 + z * 2));
        }
        Collections.sort(a);
        a.get(0).xepHang = 1;
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i).diem == a.get(i - 1).diem) {
                a.get(i).xepHang = a.get(i - 1).xepHang;
            }
            else{
                a.get(i).xepHang = i + 1;
            }
        }
        for(TinhDiemTrungBinh x : a){
            System.out.println(x);
        }
    }

    @Override
    public int compareTo(TinhDiemTrungBinh t) {
        return Float.compare(t.diem, diem);
    }
}
