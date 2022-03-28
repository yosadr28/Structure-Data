/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysatu;

import java.util.Random;

/**
 *
 * @author asus
 */
public class ArraySatu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Random ack = new Random();
        String mobil[]={"Minibus","Sedan","Pickup"};
        int pilih = ack.nextInt(3);
        for(int i=0; i<10; i++){
            System.out.println((i+1)+" hasil pilihan acak :" + mobil[pilih]);
            pilih = ack.nextInt(3);        }
        
    }
    
}
