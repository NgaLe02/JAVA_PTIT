/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VaoRaFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */

class MH{
    String ma, ten;

    public MH(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }
    
}

class GV{
    String ma, ten;
    float tongGioChuan;
    
    public GV(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    @Override
    public String toString() {
        return ten + " " + String.format("%.2f", tongGioChuan);
    }
    
    
    
}

class GC{
    GV gv;
    MH mh;
    float gioChuan;

    public GC(GV gv, MH mh, float gioChuan) {
        this.gv = gv;
        this.mh = mh;
        this.gioChuan = gioChuan;
    }
      
}

public class TinhGioChuan {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/VaoRaFile/MONHOC.in"));
        ArrayList<MH> mh = new ArrayList<MH>();
        int t = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < t; i++){
            String[] s = sc.nextLine().trim().split("\\s+");
            mh.add(new MH(s[0], s[1]));
        }
        
        sc = new Scanner(new File("src/VaoRaFile/GIANGVIEN.in"));
        ArrayList<GV> gv = new ArrayList<>();
        t = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < t; i++){
            String[] s = sc.nextLine().trim().split("\\s+", 2);
            gv.add(new GV(s[0], s[1]));
        }
        
        sc = new Scanner(new File("src/VaoRaFile/GIOCHUAN.in"));
        ArrayList<GC> gc = new ArrayList<>();
        t = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < t; i++){
            String[] s = sc.nextLine().trim().split("\\s+");
            MH a = null;
            GV b = null;
            for(GV x : gv){
                if(x.ma.equals(s[0])){
                    b= x;
                    break;
                }
            }
            
            for(MH x : mh){
                if(x.ma.equals(s[1])){
                    a = x;
                    break;
                }
            }
            
            gc.add(new GC(b, a, Float.parseFloat(s[2])));
        }
        
        for(GV x : gv){
            float tong = 0;
            for(GC y : gc){
                if(y.gv.ma.equals(x.ma)){
                    tong += y.gioChuan;
                }
            }
            x.tongGioChuan = tong;
        }
        
        for(GV x : gv){
            System.out.println(x);
        }
    }
}
