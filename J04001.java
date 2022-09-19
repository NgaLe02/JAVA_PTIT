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
public class J04001 {
    Double x, y;
    public J04001() {
        
    }

    public J04001(Double x, Double y) {
        this.x = x;
        this.y = y;
    }
    public J04001(J04001 p) {
        
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }
    
    public double distance(J04001 secondPoint) {
        return Math.sqrt((x - secondPoint.x) * (x - secondPoint.x)
                         + (y - secondPoint.y) * (y - secondPoint.y));
    }
    
    public double distance(J04001 p1, J04001 p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x)
                         + (p1.y - p2.y) * (p1.y - p2.y));
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            J04001 a = new J04001(x1, y1);
            J04001 b = new J04001(x2, y2);
            double dis = a.distance(b);
            System.out.printf("%.4f", dis);
            System.out.println("");
        }
    }
}
