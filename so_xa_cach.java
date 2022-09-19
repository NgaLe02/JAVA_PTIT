package Mang;

import java.util.Scanner;

public class so_xa_cach {
    public static int n;

    public static int[] a = new int[20];
    public static int[] check = new int[20];

    public static void in() {
        for (int i = 1; i < n; i++) {
            if ((int) Math.abs(a[i + 1] - a[i]) == 1) {
                return;
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(a[i]);
        }
        System.out.println("");
    }

    public static void sinh(int i) {
        for (int j = 1; j <= n; j++) {
            if (check[j] == 0) {
                a[i] = j;
                check[j] = 1;
                if (i == n) {
                    in();
                } else {
                    sinh(i + 1);
                }
                check[j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            sinh(1);
        }
    }
}