/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dll1;

import java.util.Scanner;

/**
 *
 * @author asus
 */
public class DLL1 {

     static Buku head = new Buku("d", "depan", "", "", 0, null, null);
     static Buku tail = new Buku("b", "belakang", "", "", 0, null, head);
     static Scanner scn = new Scanner(System.in);

    /* Buku(String a, String b, String c, String d, int e, Buku f, Buku g) {
        kodebuku = a;
        judul = b;
        pengarang = c;
        penerbit = d;
        tahun = e;
        next = f;
        prev = g;
    }*/
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        head.setNext(tail);
        int pilih = 0;
        do {
            System.out.println("Menu Utama");
            System.out.println("1. Tambah Data Depan");
            System.out.println("2. Tambah Data Belakang");
            System.out.println("3. Lihat Data");
            System.out.println("4. Hapus Data");
            System.out.println("5. Exit");
            pilih = scn.nextInt();
            switch (pilih) {
                case 1:
                    Inputdatadepan();
                    break;
                case 2:
                    Inputdatabelakang();
                    break;
                case 3:
                    lihatdata();
                    break;
                case 4:
                    String k = scn.next();
                    hapusdata(k);
                    break;
            }

        } while (pilih != 5);
    }

    static void tambahdatadepan(String a, String b, String c, String d, int e) {
        Buku baru = new Buku(a, b, c, d, e, head.getNext(), head);
        head.getNext().setPrev(baru);
        head.setNext(baru);
    }

    static void tambahdataakhir(String a, String b, String c, String d, int e) {
        Buku baru = new Buku(a, b, c, d, e, tail, tail.getPrev());
        tail.getPrev().setNext(baru);
        tail.setPrev(baru);
    }

    static void lihatdata() {
        Buku baru = head.getNext();
        while (baru != tail) {
            System.out.println(baru.getKodebuku() + " " +
                    " " + baru.getJudul() + " " + 
                    baru.getPengarang() + " " + baru.getPenerbit() + " " + baru.getTahun());
            baru = baru.getNext();
        }
    }

    static void hapusdata(String k) {
        Buku cek = head.getNext();
        while (cek != tail && !cek.getKodebuku().equalsIgnoreCase(k)) {
            cek = cek.getNext();
            if (cek != tail) {
                cek.getPrev().setNext(cek.getNext());
                cek.getNext().setPrev(cek.getPrev());
            }
        }
    }

    static int caridata(String k) {
        Buku cek = head.getNext();
        int i = 0;
        while (cek != tail && !cek.getKodebuku().equalsIgnoreCase(k)) {
            cek = cek.getNext();
        }
        if (cek != tail) {
            return (i);
        } else {
            return (-1);
        }
    }

    static void Inputdatadepan() {
        String kodebuku, judul, pengarang, penerbit;
        int tahun;
        System.out.println("Kode Buku : ");
        kodebuku = scn.next();
        System.out.println("Judul : ");
        judul = scn.next();
        System.out.println("Pengarang : ");
        pengarang = scn.next();
        System.out.println("Penerbit : ");
        penerbit = scn.next();
        System.out.println("Tahun : ");
        tahun = scn.nextInt();
        tambahdatadepan(kodebuku, judul, pengarang, penerbit, tahun);
    }

    static void Inputdatabelakang() {
        String kodebuku, judul, pengarang, penerbit;
        int tahun;
        System.out.println("Kode Buku : ");
        kodebuku = scn.next();
        System.out.println("Judul : ");
        judul = scn.next();
        System.out.println("Pengarang : ");
        pengarang = scn.next();
        System.out.println("Penerbit : ");
        penerbit = scn.next();
        System.out.println("Tahun : ");
        tahun = scn.nextInt();
        tambahdataakhir(kodebuku, judul, pengarang, penerbit, tahun);

    }
}
