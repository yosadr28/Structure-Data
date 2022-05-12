/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strukdatpriorityqueu;
import java.util.Iterator;
import java.util.PriorityQueue;
/**
 *
 * @author asus
 */
public class StrukDatPriorityQueu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PriorityQueue<Integer> susunanbaris = new PriorityQueue<>();
        susunanbaris.add(10);
        susunanbaris.add(2);
        susunanbaris.add(4);
        susunanbaris.add(8);
        susunanbaris.add(4);
        susunanbaris.add(8);
        susunanbaris.add(15);
        
        System.out.println(susunanbaris.peek());
        Iterator<Integer> barisan = susunanbaris.iterator();
        
         while(barisan.hasNext()){
             System.out.println("Barisan Utama : " + barisan.next());
        }
           System.out.println("============================");
        while(!susunanbaris.isEmpty()){
             System.out.println("Barisan Utama : " + susunanbaris.poll());
        }
           
        
    }
    
}
