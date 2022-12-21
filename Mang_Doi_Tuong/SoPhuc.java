/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MangDoiTuong;

import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class SoPhuc {

    int thuc, ao;

    public SoPhuc(int thuc, int ao) {
        this.thuc = thuc;
        this.ao = ao;
    }

    public SoPhuc add(SoPhuc another){
        int x = thuc + another.thuc;
        int y = ao + another.ao;
        return new SoPhuc(x, y);
    }
    
    public SoPhuc mul(SoPhuc another){
        int x = thuc * another.thuc - ao * another.ao;
        int y = thuc * another.ao + ao * another.thuc;
        return new SoPhuc(x, y);
    }
    
    @Override
    public String toString() {
        String sign = "+";
        if(ao < 0) sign = "-";
        ao = Math.abs(ao);
        return thuc + " " + sign + " " + ao + "i";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            String[] words = s.split("\\s+");
            SoPhuc a = new SoPhuc(Integer.parseInt(words[0]), Integer.parseInt(words[1]));
            SoPhuc b = new SoPhuc(Integer.parseInt(words[2]), Integer.parseInt(words[3]));
            SoPhuc tong = a.add(b); //a + b
            SoPhuc c = tong.mul(a); //(a + b) * a
            System.out.print(c + ", ");
            SoPhuc d = tong.mul(tong); // (a + b) ^ 2
            System.out.println(d);
        }
    }
}
