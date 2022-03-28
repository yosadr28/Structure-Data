/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraymd1;

import java.util.Scanner;

/**
 *
 * @author asus
 */
public class ArrayMD1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scn=new Scanner(System.in);
        int matrixA[][]=new int[9][9];
        int B,K;
        System.out.printf("Baris : ");B=scn.nextInt();
        System.out.printf("Kolom : ");K=scn.nextInt();
        for(int Y=0;Y<B;Y++){
            for(int X=0;X<K;X++){
              System.out.printf("Matrix A [%d,%d] : ",Y+1,X+1);matrixA[Y][X]=scn.nextInt();                
            }
        }

        System.out.printf("Matrix A : \n");
        for(int Y=0;Y<B;Y++){
            for(int X=0;X<K;X++){
              System.out.printf("%d ",matrixA[Y][X]);             
            }
            System.out.printf("\n");
        }

    }
    
}
