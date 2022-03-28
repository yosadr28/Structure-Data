/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queu;

/**
 *
 * @author asus
 */
public class Queu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayQueue<String> q = new ArrayQueue<String>(3);
        q.offer("tas");
        q.offer("pulpen");
        q.offer("baju");
        System.out.println(q.toString());
        q.poll();
        q.offer("selendang");
        System.out.println(q.toString());
    }

}
