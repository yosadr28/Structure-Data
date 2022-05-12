/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strukdatarray;

/**
 *
 * @author asus
 */
public class Truk {
    String[] wheels = {"Good","Very Good","Good","Good","Good","Very Good","Good","Missing"};
    
    public void printWheelsCond(){
        wheels[0] = "Ban Pertama";
        wheels[7] = "Ban Terakhir";     
        System.out.println("Panjang Ban : " + wheels.length);
        for(int i = 0; i<wheels.length; i++){
            int wheelNum = i+1;
            System.out.println("wheel " + wheelNum + " Kondisi ban : " + wheels[i]);
                    }
    }
    
}
