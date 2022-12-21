/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Dell E7440
 */
public class So0VaSo9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            long n = sc.nextLong();
            Queue<Long> q = new ArrayDeque<Long>();
            q.add((long)9);
            while(!q.isEmpty()){
                long tmp = q.remove();
                if(tmp % n == 0){
                    System.out.println(tmp);
                    break;
                }
                else{
                    q.add(tmp * 10);
                    q.add(tmp * 10 + 9);
                }
            }
        }
    }
}
