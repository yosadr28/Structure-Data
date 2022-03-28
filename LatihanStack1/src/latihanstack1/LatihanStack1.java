/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanstack1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import javafx.beans.property.SimpleStringProperty;
import javax.print.DocFlavor;

/**
 *
 * @author asus
 */
public class LatihanStack1 {

    //static Stack<ArrayList<hotel>> undo, redo = new Stack<>();
    static DateTimeFormatter tanggal = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static Scanner scn = new Scanner(System.in);
    static Stack<jenistransaksi> undo = new Stack<>();
    static Stack<jenistransaksi> redo = new Stack<>();
    static Stack<jenistransaksi> temp = new Stack<>();
    static List<hotel> dt = new ArrayList<>();
    static int jenis =0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here

        int pilih = 0;

        do {
            System.out.println("~~Selamat Datang DI Hotel Berlian Bandung~~");
            System.out.println("Silahkan Pilih Menu Pelaksanaan : ");
            System.out.println("1. Tambah Data Cek In");
            System.out.println("2. Lihat Data Cek In");
            System.out.println("3. Cari Data Cek In");
            System.out.println("4. Ubah Data Cek In");
            System.out.println("5. Hapus Data Cek In");
            System.out.println("6. Sisip Data Cek In");
            System.out.println("7. Tampil Data Undo-Redo");
            System.out.println("8. Undo Data Cek In");
            System.out.println("9. Redo Data Cek In");
            System.out.println("0. Keluar");
            System.out.println("Masukkan Pilihan Menu : ");
            pilih = scn.nextInt();
            switch (pilih) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    lihatdata();
                    break;
                case 3:
                    cari();
                    break;
                case 4:
                    Ubahdata();
                    break;
                case 5:
                    hapusdata();
                    break;
                case 6:
                    Sisipdata();
                    break;
                case 7:
                    tampilData();
                    break;
                case 8:
                    undoData();
                    break;
                case 9:
                    redoData();
                    break;
            }
        } while (pilih != 0);

    }

    static void tambahData() throws ParseException {
        String nama, alamat, nokamar, telepon, cekin;
        Date cnvert = null;
        System.out.print("No Kamar : ");
        nokamar = scn.next();
        System.out.print("Nama Pemesan : ");
        nama = scn.next();
        System.out.print("Alamat Pemesan : ");
        alamat = scn.next();
        System.out.print("Nomor Telephone : ");
        telepon = scn.next();
        System.out.print("Tanggal Cek-In (Contoh : 20/12/2020) : ");
        cekin = scn.next();
        LocalDate date = LocalDate.parse(cekin, tanggal);
        undo.push(new jenistransaksi(jenis, nokamar, nama, alamat, telepon, date));
        dt.add(new hotel(nokamar, nama, alamat, telepon, date));
        jenis++;
    }

    static void lihatdata() throws ParseException {
        Iterator tmp = dt.iterator();
        while (tmp.hasNext()) {
            System.out.println("No Kamar -- Nama -- Alamat -- No.Telp -- Tgl. Cekin");
            hotel d = (hotel) tmp.next();
            System.out.println(d.getNokamar() + " " + d.getNama() + " "
                    + d.getAlamat() + " " + d.getNotelp() + " " + d.getCekin());
        }
    }

    static int caridata(String a) {
        int i = 0;
        for (i = 0; i < dt.size() - 1 && !dt.get(i).getNokamar().equalsIgnoreCase(a); i++);
        if ((!dt.isEmpty()) && (dt.get(i).getNokamar().equalsIgnoreCase(a))) {
            return (i);
        } else {
            return (-1);
        }
    }

    static void cari() {
        String x = scn.next();
        hotel p = dt.get(caridata(x));
        System.out.println("Data Ditemukan : " + "\n"
                + "No Kamar : " + p.getNokamar() + " "
                + "      Nama : "  + p.getNama()
                + "      ALamat : " + p.getAlamat()
                + "      No Telephone : " + p.getNotelp() +
                  "      Tanggal Memesan : " + p.getCekin());
    }

    static void hapusdata() {
        String h;
        System.out.print("Kode No Faktur untuk Data yang Ingin Dihapus");
        h = scn.next();
        int x = caridata(h);
        if (x > -1) {
            dt.remove(x);
            redo.push(undo.remove(x));
        } else {
            System.out.print("Gak Ketemu!");
        }
    }

    static void Ubahdata() throws ParseException {
        String nama, alamat, nokamar, telepon, cekin;
        Date cnvert;
        System.out.print("nokamar Untuk Data yang Akan Diubah : ");
        nokamar = scn.next();
        int p = caridata(nokamar);
        if (p > -1) {
            System.out.print("No Kamar : ");
            nokamar = scn.next();
            System.out.print("Nama Pemesan : ");
            nama = scn.next();
            System.out.print("Alamat Pemesan : ");
            alamat = scn.next();
            System.out.print("Nomor Telephone : ");
            telepon = scn.next();
            System.out.print("Tanggal Cek-In (Contoh : 20/12/2020) : ");
            cekin = scn.next();
            LocalDate date = LocalDate.parse(cekin, tanggal);
            dt.set(p, new hotel(nokamar, nama, alamat, telepon, date));
            //temporaryData(nokamar, dt.set(p, new hotel(nokamar, nama, alamat, telepon, date)));
            undo.set(p, new jenistransaksi(p, nokamar, nama, alamat, telepon, date));
        } else {
            System.out.println(nokamar + " Tidak Ditemukan, TIdak Dapat Menyisip Data");
        }
    }

    static void Sisipdata() throws ParseException {
        String nama, alamat, nokamar, telepon, cekin;
        Date cnvert;
        System.out.print("Masukkan No kamar Sebelumnya Untuk Menyisipkan Data : ");
        nokamar = scn.next();
        int p = caridata(nokamar);
        if (p > -1) {
            System.out.print("No Kamar : ");
            nokamar = scn.next();
            System.out.print("Nama Pemesan : ");
            nama = scn.next();
            System.out.print("Alamat Pemesan : ");
            alamat = scn.next();
            System.out.print("Nomor Telephone : ");
            telepon = scn.next();
            System.out.print("Tanggal Cek-In (Contoh : 20/12/2020) : ");
            cekin = scn.next();
            LocalDate date = LocalDate.parse(cekin, tanggal);
            undo.add(p + 1, new jenistransaksi(p+1, nokamar, nama, alamat, telepon, date));
            dt.add(p + 1, new hotel(nokamar, nama, alamat, telepon, date));
        } else {
            System.out.println(nokamar + " Tidak Ditemukan, Tidak Dapat Menyisip Data");
        }
    }

    static void undoData() throws ParseException {
        if (!undo.empty()) {
            redo.push(undo.pop());
        }
        Iterator tundo = undo.iterator();
        Iterator tredo = redo.iterator();
        int i = dt.size() - 1;
        System.out.print("undo : ");
        while (tredo.hasNext()) {
            jenistransaksi d = (jenistransaksi) tredo.next();
            System.out.println("( " + d.getNokamar() + " " + d.getNama()
                    + " " + d.getAlamat() + " " + d.getNotelp() + " " + d.getCekin() + " )");
        }
        if (i > -1) {
            dt.remove(i);
        }
        lihatdata();
    }

    static void redoData() throws ParseException {
        Iterator tundo = undo.iterator();
        Iterator tredo = redo.iterator();
        int i = -1;
        System.out.print("redo : ");
        while (tredo.hasNext()) {
            jenistransaksi d = (jenistransaksi) tredo.next();
            //dt.add(new hotel(d.getNokamar(), d.getNama(), d.getAlamat(), d.getNotelp(), d.getCekin()));
            i++;
            if (i == redo.size() - 1) {
                dt.add(new hotel(d.getNokamar(), d.getNama(), d.getAlamat(), d.getNotelp(), d.getCekin()));
            }
        }

        if (!redo.empty()) {
            undo.push(redo.pop());
        }
        lihatdata();
    }

    static void tampilData() {
        Iterator tundo = undo.iterator();
        Iterator tredo = redo.iterator();
         System.out.print("undo : ");
        while (tundo.hasNext()) {
            jenistransaksi d = (jenistransaksi) tundo.next();
            System.out.println("( " + d.getNokamar() + " " + d.getNama()
                    + " " + d.getAlamat() + " " + d.getNotelp() + " " + d.getCekin() + " )");
            
        }
        System.out.print("redo : ");
        while (tredo.hasNext()) {
            jenistransaksi d = (jenistransaksi) tredo.next();
            System.out.println("( " + d.getNokamar() + " " + d.getNama()
                    + " " + d.getAlamat() + " " + d.getNotelp() + " " + d.getCekin() + " )");
        }

    }

    /* static void temporaryData(String a, hotel x) {
        Iterator tundo = undo.iterator();
        Iterator ttemp = temp.iterator();
        int i = -1;
        while (tundo.hasNext()) {
            hotel d = (hotel) tundo.next();
            if (d.getNokamar().equalsIgnoreCase(a)) {
                undo.;
                temp.push(x);
            } else {
                temp.push(undo.peek());
            }
            i++;
        }
        while (ttemp.hasNext()) {
            undo.push(temp.pop());
        }
    }
     */
}
