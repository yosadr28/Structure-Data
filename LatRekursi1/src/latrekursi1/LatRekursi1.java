/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latrekursi1;

import java.util.Scanner;

/**
 *
 * @author asus
 */
public class LatRekursi1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scn = new Scanner(System.in);
        int x = 0, y = 0;
        x = scn.nextInt();
        y = scn.nextInt();
        System.out.println(perpangkatan(x, y));
    }

    public static int perpangkatan(int bil, int pkt) {
        if (pkt > 1) {
            return (bil * perpangkatan(bil, pkt - 1));
        } else {
            return (bil);
        }
    }

}
