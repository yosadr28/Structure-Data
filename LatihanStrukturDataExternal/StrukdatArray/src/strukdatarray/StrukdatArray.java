/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strukdatarray;

import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class StrukdatArray {
        
    static ArrayList<String> wheels = new ArrayList<String>();
    static Truk truk = new Truk();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //truk.printWheelsCond();
        wheels.add("Good");
        wheels.add("Very Good");
        wheels.add("Not Good");
        wheels.add("Good");
        wheels.add("Missing");
        wheels.set(1, "Available");
        printWheelsCond();
    }
    
    public static void printWheelsCond(){
        System.out.println("Panjang Ban : " + wheels.size());
        for(int i = 0; i<wheels.size(); i++){
            int wheelNum = i+1;
            System.out.println("wheel " + wheelNum + " Kondisi ban : " + wheels.get(i));
                    }
    }
    
}
