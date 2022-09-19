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
public class J04010 {

    Double x, y;

    public J04010() {

    }

    public J04010(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public J04010(J04010 p) {

    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public double distance(J04010 secondPoint) {
        return Math.sqrt((x - secondPoint.x) * (x - secondPoint.x)
                + (y - secondPoint.y) * (y - secondPoint.y));
    }

    public double distance(J04010 p1, J04010 p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x)
                + (p1.y - p2.y) * (p1.y - p2.y));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            double x3 = sc.nextDouble();
            double y3 = sc.nextDouble();
            J04010 a = new J04010(x1, y1);
            J04010 b = new J04010(x2, y2);
            J04010 c = new J04010(x3, y3);
            double ab = a.distance(b);
            double ac = a.distance(c);
            double bc = b.distance(c);
            if (ab + ac > bc && ab + bc > ac && ac + bc > ab) {
                double dTich = Math.sqrt((ab + bc + ac) * (ab + bc - ac) * (ab + ac - bc) * (-ab + ac + bc));
                double R = ab * ac * bc / (dTich);
                System.out.printf("%.3f", Math.PI * R * R);
                System.out.println("");
            } else {
                System.out.println("INVALID");
            }
        }
    }
}
