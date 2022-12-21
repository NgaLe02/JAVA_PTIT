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
public class KiemTraDayNgoacDung {

    public static boolean check(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                st.push(s.charAt(i));
            } else {
                if (st.empty()) {
                    return false;
                }
                if (st.peek() == '(' && s.charAt(i) == ')') {
                    st.pop();
                } else if (st.peek() == '[' && s.charAt(i) == ']') {
                    st.pop();
                } else if (st.peek() == '{' && s.charAt(i) == '}') {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            if(check(s)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
