/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latarraymdfull;

import java.util.Scanner;

/**
 *
 * @author asus
 */
public class LatArrayMDFull {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scn = new Scanner(System.in);
        int MatrixA[][] = new int[9][9];
        int MatrixB[][] = new int[9][9];
        int MatrixC[][] = new int[9][9];
        int MatrixD[][] = new int[9][9];
        int MatrixE[][] = new int[9][9];
        
        int Baris, Kolom;
        System.out.printf("Baris : "); Baris=scn.nextInt();
        System.out.printf("Kolom : "); Kolom=scn.nextInt();
        
        for(int a = 0; a<Baris;a++){
            for(int b=0;b<Kolom; b++){
                System.out.printf("Matrix A[%d,%d] : ",a+1,b+1);
                MatrixA[a][b] = scn.nextInt();
            }
        }
        
        for(int c = 0; c<Baris;c++){
            for(int d=0;d<Kolom; d++){
                System.out.printf("Matrix B[%d,%d] : ",c+1,d+1);
                MatrixB[c][d] = scn.nextInt();
            }
            
        }
        
        System.out.printf("Matrix A : \n");
        for(int a=0;a<Baris;a++){
            for(int b=0;b<Kolom;b++){
                System.out.printf("%d  ", MatrixA[a][b]);
            }
            System.out.printf("\n");
        }
        
        System.out.printf("Matrix B : \n");
        for(int c=0;c<Baris;c++){
            for(int d=0;d<Kolom;d++){
                System.out.printf("%d  ", MatrixB[c][d]);
            }
            System.out.printf("\n");
        }
        
        
        //Matriks Pertambahan C
        for(int e = 0; e<Baris;e++){
            for(int f=0;f<Kolom; f++){
                MatrixC[e][f] = MatrixA[e][f] + MatrixB[e][f];
            }
        }
        
        System.out.printf("Matrix C : \n");
        for(int c=0;c<Baris;c++){
            for(int d=0;d<Kolom;d++){
                System.out.printf("%d  ", MatrixC[c][d]);
            }
            System.out.printf("\n");
        }
        
     
        //Matriks Pengurangan D
        for(int e = 0; e<Baris;e++){
            for(int f=0;f<Kolom; f++){
                MatrixD[e][f] = MatrixA[e][f] - MatrixB[e][f];
            }
        }
        
        System.out.printf("Matrix D : \n");
        for(int c=0;c<Baris;c++){
            for(int d=0;d<Kolom;d++){
                System.out.printf("%d  ", MatrixD[c][d]);
            }
            System.out.printf("\n");
        }
        
        //Matriks Perkalian E
        System.out.printf("Matrix E : \n");
        for(int c=0;c<Baris;c++){
            for(int d=0;d<Kolom;d++){
               
            }
           
        }
        
        for(int e = 0; e<Baris;e++){
            for(int f=0;f<Kolom; f++){
                MatrixE[e][f]=0;
                for(int g=0; g<Kolom; g++){
                    MatrixE[e][f] += MatrixA[e][g] * MatrixB[g][f];
                }
                 System.out.printf("%d  ", MatrixE[e][f]);
            }
             System.out.printf("\n");
        }
        

        
        
    }

}
