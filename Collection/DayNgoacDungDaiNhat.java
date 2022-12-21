/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Dell E7440
 */
public class DayNgoacDungDaiNhat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kq = 0;
        boolean check = false;
        String s = sc.nextLine();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (s.charAt(stack.peek()) == '(') {
                    kq++;
                    stack.pop();
                } else {
                    System.out.println(kq);
                    check = true;
                    break;
                }
            } 
        }
        if (!check) {
            System.out.println(kq);
        }
    }
}
