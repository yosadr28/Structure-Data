/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ddl2;

import java.util.Scanner;

/**
 *
 * @author asus
 */
public class DDL2 {

    static Penjualan head = new Penjualan("", "", 0, 0, 0, null, null);
    static Penjualan tail = new Penjualan("", "", 0, 0, 0, null, head);
    static Scanner scn = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        head.setNext(tail);
        int pilih = 0;
        do {
            System.out.println("Portal Menu Penjualan HP");
            System.out.println("-------------------------");
            System.out.println("1. Tambah Data Penjualan Dari Atas");
            System.out.println("2. Tambah Data Penjualan Dari Bawah");
            System.out.println("3. Sisip Data Penjualan");
            System.out.println("4. Ubah Data Penjualan");
            System.out.println("5. Hapus Data Penjualan");
            System.out.println("6. Cari Data Penjualan");
            System.out.println("7. Lihat Data Penjualan Dari Atas");
            System.out.println("8. Lihat Data Penjualan Dari Bawah");
            System.out.println("0. Keluar");
            System.out.print("Silahkan Masukkan Menu yang Ingin Dituju : ");
            pilih = scn.nextInt();
            switch (pilih) {
                case 1:
                    Inputdatadepan();
                    break;
                case 2:
                    Inputdatabelakang();
                    break;
                case 3:
                    Inputsisipdata();
                    break;
                case 4:
                    Inputubahdata();
                    break;
                case 5:
                    hapusdata();
                    break;
                case 6:
                    inputcaridata();
                    break;
                case 7:
                    lihatdatadepan();
                    break;
                case 8:
                    lihatdatabelakang();
                    break;
            }
        } while (pilih > 0);
    }

    static void tambahdatadepan(String a, String b, int c, int d, int e) {
        Penjualan baru = new Penjualan(a, b, c, d, e, head.getNext(), head);
        head.getNext().setPrev(baru);
        head.setNext(baru);
    }

    static void tambahdatabelakang(String a, String b, int c, int d, int e) {
        Penjualan baru = new Penjualan(a, b, c, d, e, tail, tail.getPrev());
        tail.getPrev().setNext(baru);
        tail.setPrev(baru);
    }

    static void hapusdata() {
        String a = scn.next();
        Penjualan cek = head.getNext();
        while (cek != tail && !cek.getNofaktur().equalsIgnoreCase(a)) {
            cek = cek.getNext();
        }
        if (cek != tail) {
            cek.getPrev().setNext(cek.getNext());
            cek.getNext().setPrev(cek.getPrev());
        }
    }

    static void ubahdata(String a, String b, String c, int d, int e, int f) {
        Penjualan cek = head.getNext();
        while (cek != tail && !cek.getNofaktur().equalsIgnoreCase(a)) {
            cek = cek.getNext();
        }
        if (cek != tail) {
            cek.setNofaktur(b);
            cek.setHp(c);
            cek.setJumlah(d);
            cek.setHarga(e);
            cek.setBayar(f);
        }
    }

    static int caridata(String a) {
        Penjualan cek = head.getNext();
        int i = 0;
        while (cek != tail && !cek.getNofaktur().equalsIgnoreCase(a)) {
            cek = cek.getNext();
            i++;
        }
        if (cek != tail) {
            return (i);
        } else {
            return (-1);
        }
    }

    static void inputcaridata() {
        Penjualan cek = head.getNext();
        String a = scn.next();
        System.out.println("No Faktur -- Merk HP -- Jumlah Beli -- Harga/Pcs -- Total Bayar");
        if (caridata(a) >= 0) {
            for (int x = 0; x <= caridata(a) - 1; x++) {
                cek = cek.getNext();
            }
            System.out.println("Data Ditemukan : " + cek.getNofaktur() + " - " + cek.getHp()
                    + " - " + cek.getJumlah() + " - " + cek.getHarga() + " - " + cek.getBayar());
        } else {
            System.out.println("Data Tidak Ditemukan");
        }
    }

    static void sisipdata(String a, String b, String c, int d, int e, int f) {
        Penjualan cek = head.getNext();
        while (cek != tail && !cek.getNofaktur().equalsIgnoreCase(a)) {
            cek = cek.getNext();
        }
        if (cek != tail) {
            Penjualan baru = new Penjualan(b, c, d, e, f, cek.getNext(), cek);
            cek.getNext().setPrev(baru);
            cek.setNext(baru);
        }
    }

    static void lihatdatadepan() {
        Penjualan baru = head.getNext();
        System.out.println("No Faktur -- Merk HP -- Jumlah Beli -- Harga/Pcs -- Total Bayar");
        while (baru != tail) {
            System.out.println(baru.getNofaktur() + " - " +  baru.getHp()
                    +  " - " + baru.getJumlah() +  " - " +  baru.getHarga() + " - " +  baru.getBayar());
            baru = baru.getNext();
        }
    }

    static void lihatdatabelakang() {
        Penjualan baru = tail.getPrev();
        System.out.println("No Faktur -- Merk HP -- Jumlah Beli -- Harga/Pcs -- Total Bayar");
        while (baru != head) {
            System.out.println(baru.getNofaktur() +  " - " + baru.getHp()
                    +  " - " + baru.getJumlah() + " - " +  baru.getHarga() +  " - " + baru.getBayar());
            baru = baru.getPrev();
        }
    }

    static void Inputdatadepan() {
        String nofaktur, hp;
        int jumlah, harga, bayar;
        System.out.println("Masukkan Nomor Faktur Penjualan : ");
        nofaktur = scn.next();
        System.out.println("Masukkan Merek HP : ");
        hp = scn.next();
        System.out.println("Masukkan Jumlah Pembelian : ");
        jumlah = scn.nextInt();
        System.out.println("Masukkan Harga HP (per Item) : ");
        harga = scn.nextInt();
        bayar = jumlah * harga;
        tambahdatadepan(nofaktur, hp, jumlah, harga, bayar);
    }

    static void Inputdatabelakang() {
        String nofaktur, hp;
        int jumlah, harga, bayar;
        System.out.println("Masukkan Nomor Faktur Penjualan : ");
        nofaktur = scn.next();
        System.out.println("Masukkan Merek HP : ");
        hp = scn.next();
        System.out.println("Masukkan Jumlah Pembelian : ");
        jumlah = scn.nextInt();
        System.out.println("Masukkan Harga HP (per Item) : ");
        harga = scn.nextInt();
        bayar = jumlah * harga;
        tambahdatabelakang(nofaktur, hp, jumlah, harga, bayar);
    }

    static void Inputubahdata() {
        String nofakturawal, nofakturakhir, hp;
        int jumlah, harga, bayar;
        System.out.println("Masukkan No.Faktur Data Penjualan yang Kana Diubah: ");
        nofakturawal = scn.next();
        System.out.println("Masukkan Nomor Faktur Penjualan : ");
        nofakturakhir = scn.next();
        System.out.println("Masukkan Merek HP : ");
        hp = scn.next();
        System.out.println("Masukkan Jumlah Pembelian : ");
        jumlah = scn.nextInt();
        System.out.println("Masukkan Harga HP (per Item) : ");
        harga = scn.nextInt();
        bayar = jumlah * harga;
        ubahdata(nofakturawal, nofakturakhir, hp, jumlah, harga, bayar);
    }

    static void Inputsisipdata() {
        String nofakturawal, nofakturakhir, hp;
        int jumlah, harga, bayar;
        System.out.println("Masukkan No.Faktur Data Penjualan yang Ingin Disisip Bawahnya: ");
        nofakturawal = scn.next();
        System.out.println("Masukkan Nomor Faktur Penjualan : ");
        nofakturakhir = scn.next();
        System.out.println("Masukkan Merek HP : ");
        hp = scn.next();
        System.out.println("Masukkan Jumlah Pembelian : ");
        jumlah = scn.nextInt();
        System.out.println("Masukkan Harga HP (per Item) : ");
        harga = scn.nextInt();
        bayar = jumlah * harga;
        sisipdata(nofakturawal, nofakturakhir, hp, jumlah, harga, bayar);
    }

}
