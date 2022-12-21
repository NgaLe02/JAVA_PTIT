/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class ThoiGianOnlineLienTuc implements Comparable<ThoiGianOnlineLienTuc> {

    String hoTen, vao, ra;
    int time;
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date in = null, out = null;

    public ThoiGianOnlineLienTuc(String hoTen, String vao, String ra) throws ParseException {
        this.hoTen = hoTen;
        this.vao = vao;
        this.ra = ra;
        in = date.parse(vao);
        out = date.parse(ra);
    }

    public void setTime() {
        int x = (int) ((out.getTime() - in.getTime()) / (1000 * 60));
        this.time = x;
    }

    @Override
    public String toString() {
        return hoTen + " " + time;
    }

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("src/VaoRaFile/ONLINE.in"));
        ArrayList<ThoiGianOnlineLienTuc> a = new ArrayList<>();
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            a.add(new ThoiGianOnlineLienTuc(sc.nextLine(), sc.nextLine(), sc.nextLine()));
            a.get(a.size() - 1).setTime();
        }
        Collections.sort(a);
        for (ThoiGianOnlineLienTuc x : a) {
            System.out.println(x);
        }
    }

    @Override
    public int compareTo(ThoiGianOnlineLienTuc t) {
        return t.time - time;
    }
}
