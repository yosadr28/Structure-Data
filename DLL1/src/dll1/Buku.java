/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dll1;

/**
 *
 * @author asus
 */
public class Buku {

    Buku next, prev;
    String kodebuku, judul, pengarang, penerbit;
    int tahun;

    Buku() {
        kodebuku = "";
        judul = "";
        pengarang = "";
        penerbit = "";
        tahun = 0;
        next = null;
        prev = null;
    }

    Buku(String a, String b, String c, String d, int e, Buku f, Buku g) {
        kodebuku = a;
        judul = b;
        pengarang = c;
        penerbit = d;
        tahun = e;
        next = f;
        prev = g;
    }

    public Buku getNext() {
        return next;
    }

    public void setNext(Buku next) {
        this.next = next;
    }

    public Buku getPrev() {
        return prev;
    }

    public void setPrev(Buku prev) {
        this.prev = prev;
    }

    public String getKodebuku() {
        return kodebuku;
    }

    public void setKodebuku(String kodebuku) {
        this.kodebuku = kodebuku;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

}
