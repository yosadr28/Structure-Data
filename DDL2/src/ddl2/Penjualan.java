/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ddl2;

/**
 *
 * @author asus
 */
public class Penjualan {
    String nofaktur, hp;
    int jumlah, harga, bayar;
    Penjualan next, prev;

    Penjualan (String a, String b, int c, int d, int e, Penjualan nx, Penjualan pr){
        nofaktur = a;
        hp = b;
        jumlah = c;
        harga= d;
        bayar = e;
        next= nx;
        prev = pr;
    }
    
    public String getNofaktur() {
        return nofaktur;
    }

    public void setNofaktur(String nofaktur) {
        this.nofaktur = nofaktur;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getBayar() {
        return bayar;
    }

    public void setBayar(int bayar) {
        this.bayar = bayar;
    }

    public Penjualan getNext() {
        return next;
    }

    public void setNext(Penjualan next) {
        this.next = next;
    }

    public Penjualan getPrev() {
        return prev;
    }

    public void setPrev(Penjualan prev) {
        this.prev = prev;
    }
    
}
