/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strukdatlinkedlist;
import java.util.LinkedList;
import java.util.ListIterator;
/**
 *
 * @author asus
 */
public class StrukDatLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList<String> stories = new LinkedList<String>();
        stories.add("Ada Anak Bernama Juan");
        stories.add("Juan pergi ke rumah");
        stories.add("Juan bertemu dengan ayah ibunya");
        stories.add("Juan hidup bahagia di dalam rumahnya");
        
        stories.add(1, "Juan Membeli makanan untuk di rumah");
        
        stories.addFirst("Cerita Mengenai Juan yang Menyayangi Keluarganya");
        stories.addLast("Mereka Makan Bersama di dalam rumah tersebut");
        
        stories.pop();
        stories.remove(2);
        
        ListIterator<String> book = stories.listIterator();
        
        while(book.hasNext()){
            System.out.println(book.next());
        }
    }
    
}
