/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectionsortstrukdat;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class SelectionSortStrukdat {

    public static void AcakData(int[] d, int m) {
        Random acak = new Random();
        System.out.println("Isi data : ");
        for (int i = 0; i < m; i++) {
            d[i] = acak.nextInt(10);
        }
    }

    public final static void UrutMin(int[] d, int m) {
        int kecil;
        int tmp;
        for (int i = 1; i < m - 1; i++) {
            kecil = i;
            for (int j = i + 1; j <= m; j++) {
                if (d[j - 1] < d[kecil - 1]) {
                    kecil = j;
                }
            }
            if (kecil != i) {
                tmp = d[i - 1];
                d[i - 1] = d[kecil - 1];
                d[kecil - 1] = tmp;
            }
            System.out.printf("Pengurutan : %d\n", i);
            DisplayData(d, m);
        }
    }
    
    public final static void UrutMax(int []d,int m){
        int besar;
        int tmp;
        for(int i=m;i>1;i--){
            besar=i;
            for(int j=i-1;j>0;j--)
                if(d[j-1]>d[besar-1]) besar=j;
            if(besar!=i){
                tmp=d[i-1];
                d[i-1]=d[besar-1];
                d[besar-1]=tmp;
            }
            System.out.printf("Pengurutan : %d\n",m-i+1);
            DisplayData(d,m);            
        }        
    }

    
    public static void DisplayData(int[] d, int m) {
        for (int i = 0; i < m; i++) {
            if (i % 40 == 0) {
                System.out.println("");
            } else {
                System.out.printf("%d ", d[i]);
            }
        }
        System.out.println("");
    }

  
 public static void UrutGelembung(int []d,int m){
        int tmp;
        for(int i=m;i>1;i--){
            for(int j=m;j>1;j--)
                if(d[j-2]>d[j-1]) {
                tmp=d[j-2];
                d[j-2]=d[j-1];
                d[j-1]=tmp;
                }
            System.out.printf("Pengurutan : %d\n",m-i+1);
            DisplayData(d,m);            
        }        
    }

    
 public static void UrutSisip(int []d,int m){
        int tmp,j;
        for(int i=2;i<=m;i++){
            for(j=1;d[j-1]<d[i-1]&&j<i;j++);
            if(j<i){
                tmp=d[i-1];
                for(int k=i;k>j;k--)
                {
                    d[k-1]=d[k-2];
                }
                d[j-1]=tmp;
            }
            System.out.printf("Pengurutan : %d\n",i-1);
            DisplayData(d,m);            
        }        
    }

    public static void main(String[] args) {
        // TODO code application logic here
       
        int MAXDATA=40; int m=0;
        int[] dt=new int[MAXDATA];
        Scanner scn=new Scanner(System.in);
        do{  System.out.println("MENU UTAMA");
            System.out.println("------------");
            System.out.println("1. Acak Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Urut Metode gelembung");
            System.out.println("4. Urut Metode maksimum");
            System.out.println("5. Urut Metode minimum");
            System.out.println("6. Urut Metode sisip");
            System.out.println("7. Keluar");
            System.out.printf("Pilihan : ");m=scn.nextInt();
            switch(m){    case 1 : AcakData(dt,MAXDATA);break;
                case 2 : DisplayData(dt,MAXDATA);break;
                case 3 : UrutGelembung(dt, MAXDATA);break;
                case 4 : UrutMax(dt, MAXDATA);break;
                case 5 : UrutMin(dt, MAXDATA);break;
                case 6 : UrutSisip(dt, MAXDATA);break;
            }
        }while(m!=7);    }


}
