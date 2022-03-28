/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latrekursi2;

import java.util.Scanner;

/**
 *
 * @author asus
 */
public class LatRekursi2 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scn = new Scanner(System.in);
        System.out.print("Jumlah Deret Bilangan Fibonacchi : ");
        int jml = scn.nextInt();

        for (int i = 0; i < jml; i++) {
            System.out.print("Hasil Bilangan Fibonacchi ke-" + i + " : " );
            System.out.println(fibo(i));
        }

    }

    public static int fibo(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return (fibo(n - 1) + fibo(n - 2));
        }
    }

}
