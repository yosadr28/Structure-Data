/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dlllatcontoh;

/**
 *
 * @author asus
 */
public class DLLLatContoh {
    
    static Node head = new Node("depan" , null, null);
    static Node tail = new Node("belakang", head, null);
    
    static class Node{
        Node prev;
        String data;
        Node next;
        
        public Node(String d, Node pr, Node nx){
            data=d; prev = pr; next = nx;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
        
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        head.setNext(tail);
        tambahdata();
        hapusdata();
        lihatdata();
        System.out.println(head);
        System.out.println(tail);
    }
    
    static void lihatdata(){
        Node baru = head.getNext();
        while(baru!=tail){
            System.out.println(baru.getData());
            baru=baru.getNext();
        }
    }
    
    static void tambahdata(){
        Node baru = new Node("Budi Santoso", head,head.getNext());
        head.getNext().setPrev(baru);head.setNext(baru);
        while (baru!=tail) {            
            System.out.println(baru.getData());
            baru=baru.getNext();
        }
        
    }
    
    static void hapusdata(){
        Node cek = head.getNext();
        while(cek!=tail&!cek.getData().equalsIgnoreCase("Budi Santoso")){
            cek = cek.getNext();
        }
        if(cek!=tail){
            cek.getPrev().setNext(cek.getNext());
            cek.getNext().setPrev(cek.getPrev());
        }
    }
    
    static void ubahdata(String o, String k){
        Node cek = head.getNext();
        while(cek!=tail&&!cek.getData().equalsIgnoreCase(o)){
            cek = cek.getNext();
        }
        if(cek!=tail){
            cek.setData(k);
        }
        
    }
    
}
