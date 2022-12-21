    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package VaoRaFile;

    import java.io.File;
    import java.io.FileNotFoundException;
    import java.util.Scanner;

    /**
     *
     * @author Dell E7440
     */
    public class TimViTriXauCon {

        public static void main(String[] args) throws FileNotFoundException {
            Scanner sc = new Scanner(new File("src/VaoRaFile/STRING.in"));
            int t = Integer.parseInt(sc.nextLine());
            while (t-- > 0) {
                String s1 = sc.nextLine().trim();
                String s2 = sc.nextLine().trim();
                int i = 0;
                while (s1.indexOf(s2, i) != -1) {
                    int x = s1.indexOf(s2, i);
                    System.out.print(x + 1 + " ");
                    i = x + 1;
                    if (i >= s1.length()) {
                        break;
                    }
                }
                System.out.println("");
            }
        }

    }
