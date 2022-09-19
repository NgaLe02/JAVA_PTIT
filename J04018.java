/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mang_Doi_Tuong;

import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class J04018 {

    private int a, b;

    public J04018() {
    }

    public J04018(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public J04018 add(J04018 another) {
        int a = this.a + another.a;
        int b = this.b + another.b;
        return new J04018(a, b);
    }

    @Override
    public String toString() {
        String sign = "";
        if (b < 0) {
            sign = "-";
        } else {
            sign = "+";
        }
        b = Math.abs(b);
        return a + " " + sign + " " + b + "i";
    }

    public J04018 mul(J04018 another) {
        int a = this.a * another.a - this.b * another.b;
        int b = this.b * another.a + this.a * another.b;
        return new J04018(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            J04018 a = new J04018(sc.nextInt(), sc.nextInt());
            J04018 b = new J04018(sc.nextInt(), sc.nextInt());
            J04018 add = a.add(b);
            J04018 c = new J04018();
            J04018 d = new J04018();
            c = add.mul(a);
            d = add.mul(add);
            System.out.println(c + ", " + d);
        }
    }
}
