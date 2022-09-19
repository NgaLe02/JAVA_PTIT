/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vao_ra_file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class LoaiPhong implements Comparable<LoaiPhong> {
    
    private String kyHieu, tenLoaiPhong;
    private int donGia;
    private double phiPhucVu;
    
    public LoaiPhong(String s) {
        String[] words = s.split("\\s+");
        this.kyHieu = words[0];
        this.tenLoaiPhong = words[1];
        this.donGia = Integer.parseInt(words[2]);
        this.phiPhucVu = Double.parseDouble(words[3]);
    }
    
    public int compareTo(LoaiPhong o2) {
        return this.tenLoaiPhong.compareTo(o2.tenLoaiPhong);
    }
    
    @Override
    public String toString() {
        return kyHieu + " " + tenLoaiPhong + " " + donGia + " " + phiPhucVu;
    }
    
    public static void main(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while (n-- > 0) {
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for (LoaiPhong tmp : ds) {
            System.out.println(tmp);
        }
    }
}
