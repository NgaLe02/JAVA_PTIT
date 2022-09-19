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
public class J04002 {

    Double width, hieght;
    String color;

    public J04002() {

    }

    public J04002(Double width, Double hieght, String color) {
        this.width = width;
        this.hieght = hieght;
        this.color = color;
    }

    public Double getWidth() {
        return width;
    }

    public Double getHieght() {
        return hieght;
    }

    public String getColor() {
        return color;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public void setHieght(Double hieght) {
        this.hieght = hieght;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double findArea() {
        return hieght * width;
    }

    public double findPerimeter() {
        return 2 * (hieght + width);
    }

    public static String chuanHoa(String s) {
        s = s.toLowerCase();
        String res = "";
        res += Character.toUpperCase(s.charAt(0));
        res += s.substring(1);
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double w = sc.nextDouble();
        double h = sc.nextDouble();
        String color = sc.next();
        if (w > 0 && h > 0) {
            J04002 x = new J04002(w, h, color);
            double chuVi = x.findPerimeter();
            double dTich = x.findArea();
            System.out.printf("%.0f %.0f ", chuVi, dTich);
            System.out.println(chuanHoa(color));
        } else {
            System.out.println("INVALID");
        }
    }
}
