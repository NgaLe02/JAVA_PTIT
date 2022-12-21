/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class SoLocPhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            int n = Integer.parseInt(sc.nextLine());
            ArrayList<String> a = new ArrayList<>();
            Queue<String> q = new ArrayDeque<>();
            q.add("6");
            q.add("8");
            while(true){
                String tmp = q.remove();
                if(tmp.length() > n) {
                    break;
                }
                a.add(tmp);
                q.add(tmp + "6");
                q.add(tmp + "8");
            }
            System.out.println(a.size());
            
            for(int i = a.size() - 1; i >= 0; i--){
                System.out.print(a.get(i)+ " ");
            }
            System.out.println("");
        }
    }
}
