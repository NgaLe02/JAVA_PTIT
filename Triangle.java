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
public class Triangle {

    private Point m, n, p;

    public static class Point {

        private double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public static Point nextPoint(Scanner sc) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            return new Point(x, y);
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

    }

    public Triangle(Point m, Point n, Point p) {
        this.m = m;
        this.n = n;
        this.p = p;
    }

    public boolean valid() {
        double mn = Math.sqrt(Math.pow(this.m.x - this.n.x, 2) + Math.pow(this.m.y - this.n.y, 2));
        double np = Math.sqrt(Math.pow(this.n.x - this.p.x, 2) + Math.pow(this.n.y - this.p.y, 2));
        double mp = Math.sqrt(Math.pow(this.m.x - this.p.x, 2) + Math.pow(this.m.y - this.p.y, 2));
        if (mn + np <= mp || mn + mp <= np || mp + np <= mn) {
            return false;
        } else {
            return true;
        }
    }

    public String getPerimeter() {
        double mn = Math.sqrt(Math.pow(this.m.x - this.n.x, 2) + Math.pow(this.m.y - this.n.y, 2));
        double np = Math.sqrt(Math.pow(this.n.x - this.p.x, 2) + Math.pow(this.n.y - this.p.y, 2));
        double mp = Math.sqrt(Math.pow(this.m.x - this.p.x, 2) + Math.pow(this.m.y - this.p.y, 2));
        double per = mn + mp + np;
        String Per = String.format("%.03f", per);
        return Per;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if (!a.valid()) {
                System.out.println("INVALID");
            } else {
                System.out.println(a.getPerimeter());
            }
        }
    }
}
