/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VaoRaFile;
import java.io.*;
import java.util.*;
/**
 *
 * @author Dell E7440
 */
public class J07010 {
    String maSV, hoTen, lop, ngaySinh;
    double diem;

    public J07010(int maSV, String hoTen, String lop, String ngaySinh, double diem) {
        this.maSV = String.format("B20DCCN%03d", maSV);
        this.hoTen = chuanHoaTen(hoTen);
        this.lop = lop;
        this.ngaySinh = chuanHoaNgay(ngaySinh);
        this.diem = diem;
    }
    @Override
    public String toString() {
        return maSV + " " + hoTen + " " + lop + " " + ngaySinh + " " + String.format("%.2f", diem);
    }
    
    public static String chuanHoaNgay(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(1) == '/'){
            sb.insert(0, '0');
        }
        if(sb.charAt(4) == '/'){
            sb.insert(3,'0');
        }
        return sb.toString();
    }
    
    public static String chuanHoaTen(String s){
        String t = s.toLowerCase().trim();
        String[] words = t.split("\\s+");
        t = "";
        for(String x : words){
            t += String.valueOf(x.charAt(0)).toUpperCase() + x.substring(1) + " ";
        }
        return t.trim();
    }
  
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/VaoRaFile/SV.in"));
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<J07010> a = new ArrayList<>();
        for(int i = 0; i < t; i++){
            a.add(new J07010(i + 1, sc.nextLine(), sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine())));
        }
        for(J07010 x : a){
            System.out.println(x);
        }
    }
}
