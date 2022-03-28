/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minsortascending;

import java.util.Scanner;

/**
 *
 * @author asus
 */
public class MinSortAscending {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int size,i,j,temp;
        int arr[] = new int[10];
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Masukan Banyak Angka : ");
        size=scan.nextInt();
        
        System.out.println("Masukan Angka Sejumlah " + size + " : ");
        for(i=0;i<size;i++){
            arr[i] = scan.nextInt();
        }
        
        System.out.printf("\n");
        for(i=0;i<size;i++){
            for(j=i+1;j<size;j++){
                
                if(arr[i]>arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    
                    System.out.print("Hasil min sorting pada iterasi ke-" + i +" : \n");  
                    for(int x=0; x<size; x++)  
                    {            
                     System.out.print(arr[x]+ "  ");  
                    }  
        
                }
            }
        }
        
       System.out.print("-Hasil min sorting\n");  
       for(i=size; i<=0; i--)  
       {  
           System.out.print(arr[i]+ "  ");  
       }  
        
       System.out.printf("\n");
        for(i=size;i<=0;i--){
            for(j=i-1;j<=0;j--){
                
                if(arr[i]<arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    
                    System.out.print("Hasil max sorting pada iterasi ke-" + i +" : \n");  
                    for(int x=0; x<size; x++)  
                    {            
                     System.out.print(arr[x]+ "  ");  
                    }  
        
                }
            }
        }
        
        int arr2[] = new int[10];
        Scanner scan2 = new Scanner(System.in);
        
        System.out.print("Masukan Banyak Angka : ");
        size=scan.nextInt();
        
        System.out.println("Masukan Angka Sejumlah " + size + " : ");
        for(i=0;i<size;i++){
            arr2[i] = scan.nextInt();
        }
        
       System.out.print("Hasil max sorting :\n");  
       for(i=size; i<=0; i--)  
       {  
           System.out.print(arr2[i]+ "  ");  
       }  
        
       
    }
    
}
