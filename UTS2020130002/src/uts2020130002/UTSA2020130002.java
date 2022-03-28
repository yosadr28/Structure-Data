/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts2020130002;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author asus
 */
//Yosef Adrian - 2020130002
//UTS STRUKTUR DATA SOAL TYPE A
/*
Sebuah rumah sakit, memiliki urutan proses dalam perawatan pasien yang sakit organ dalam dengan tahapan sebagai
berikut :

A, Periksa darah->radiologi->dokter->rawat jalan => ArrayQueue//ArrayList
*Pemeriksaan darah dilakukan paling awal, setelah selesai akan dilakukan radiologi. Setelah radiologi selesai, maka akan
dilakukan pemeriksaan lanjut oleh dokter dan tahapan terakhir setelah diperiksa dokter adalah rawat jalan.

B, Setelah rawat jalan selesai, maka data pasien akan disimpan ke struktur data list dengan isi data : nama pasien
-> ArrayList (List Java yang Saya Pakai)

C, Program harus dapat melihat isi antrian, data transaksi yang sudah diproses, input antrian dan proses antrian
(4 Perintah Utama)

**Asumsi : semua pasien di dalam tahapan perawatan tidak ada kendala apapun dan dianggap pasien sembuh 100%
sesudah rawat jalan selesai. 

Antrian tidak ada batas => ArrayQueu terbatas, Jadinya Pakai ArrayList agar datanya dinamis
 */
public class UTSA2020130002 {

    public static class pasien {

        String nama;
        int noantri, transaksi;

        pasien(String a, int b, int c) {
            nama = a;
            noantri = b;
            transaksi = c;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public int getNoantri() {
            return noantri;
        }

        public void setNoantri(int noantri) {
            this.noantri = noantri;
        }

        public int getTransaksi() {
            return transaksi;
        }

        public void setTransaksi(int transaksi) {
            this.transaksi = transaksi;
        }

    }

    static Scanner scn = new Scanner(System.in);
    static int nourut = 0;
    static ArrayList<pasien> antrian[] = new ArrayList[4];//Periksa darah->radiologi->dokter->rawat jalan
    static ArrayList<pasien> dt = new ArrayList<>();
    static ArrayList<pasien> tmp = new ArrayList<>();

    public static void main(String[] args) {
        //isi antrian, data transaksi yang sudah diproses, input antrian dan proses antrian
        for (int i = 0; i < 4; i++) {
            antrian[i] = new ArrayList<pasien>();
        }
        int pilih = 0;
        do {
            System.out.println("~SELAMAT DATANG DI RUMAH SAKIT YOSEF~");
            System.out.println("MENU UTAMA");
            System.out.println("1. Input Data Antrian Pasien");
            System.out.println("2. Lihat Data Antrian");
            System.out.println("3. Proses Data Antrian");
            System.out.println("4. Lihat Data Transaksi Selesai");
            System.out.println("5. Cari Data Transaksi dengan Nama");
            System.out.println("0. Keluar");
            System.out.print("Masukkan Pilihan Anda : ");
            pilih = scn.nextInt();
            switch (pilih) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    lihatDataAntrian();
                    break;
                case 3:
                    prosesData();
                    break;
                case 4:
                    lihatDataSelesai();
                    break;
                case 5:
                    cariData();
                    break;
            }
        } while (pilih > 0);
    }

    static boolean kosong(int i) {
        boolean tmp = true;
        if (!antrian[i].isEmpty()) {
            tmp = false;
        }
        //System.out.println(tmp);
        return tmp;
    }

    static int cari(String nam) {
        int caridata = -1;
        int i = 0;
        Iterator t = dt.iterator();
        while (t.hasNext() && caridata == -1) {
            pasien tmp = (pasien) t.next();
            if (tmp.getNama().equalsIgnoreCase(nam)) {
                caridata = i;
            }
            i++;
        }
        return (caridata);
    }

    static void cariData() {
        System.out.print("Masukkan Nama Yang Ingin DIcari : ");
        String nama = "";
        boolean ketemu = false;
        nama = scn.next();
        for (int i = 0; i < 4; i++) {
            int b = 0, a = antrian[i].size() - 1;
            int t = (b + a) / 2;
            if (!antrian[i].isEmpty()) {
                while (!(antrian[i].get(t).getNama() == nama) && b <= a) {
                    if (antrian[i].get(t).getNama().compareTo(nama) < 1) {
                        b = t + 1;
                    } else {
                        a = t - 1;
                    }
                    t = (b + a) / 2;
                }
                if (antrian[i].get(t).getNama().compareTo(nama) == 0) {
                    String antr = "";
                    switch (i) {
                        case 0:
                            antr = "Proses Periksa Darah";
                            break;
                        case 1:
                            antr = "Proses Radiologi";
                            break;
                        case 2:
                            antr = "Proses Dokter";
                            break;
                        case 3:
                            antr = "Proses Rawat Jalan";
                            break;
                    }
                    System.out.println("Pasien Nama " + nama + " Berada di " + antr);
                    i = 4;
                    ketemu = true;
                } else if (!(antrian[i].get(t).getNama() == nama) && i >= 2) {
                    System.out.println("Pasien Nama " + nama + " Tidak Ketemu");
                }
            }
        }
        if (!ketemu) {
            int x = cari(nama);
            if (x > -1) {
                pasien f = dt.get(x);
                System.out.println("Pasien Sudah Selesai Bertransaksi" + "\n" + "No Antrian : " + f.getNoantri()
                        + "\n" + "Nama  : " + f.getNama()
                        + "\n" + "Jumlah Bayar : " + f.getTransaksi());
            }
        }
    }

    static void lihatDataSelesai() {
        if (!dt.isEmpty()) {
            System.out.println("No Antrian - - Nama Pasien - - Jumlah Pembayaran");
            for (int j = 0; j < dt.size(); j++) {
                pasien t = dt.get(j);
                System.out.println(t.getNoantri() + " " + t.getNama() + " " + t.getTransaksi());
            }
            System.out.println("");
        }
    }

    static void tambahData() {
        String nama;
        int transaksi;
        System.out.println("Nama Pasien : ");
        nama = scn.next();
        while (!((nama.equalsIgnoreCase("X")))) {
            System.out.println("Jumlah Bayar : ");
            transaksi = scn.nextInt();
            antrian[0].add(new pasien(nama, nourut, transaksi));
            nourut++;
            System.out.println("Nama Pasien : ");
            nama = scn.next();
        }
    }

    static void lihatDataAntrian() {
        System.out.println("-DATA ANTRIAN PASIEN-");
        System.out.println("DATA ANTRIAN PERIKSA DARAH :");
        System.out.println("No Antrian - - Nama Pasien - - Jumlah Pembayaran");
        if (!(antrian[0].isEmpty())) {
            for (int j = 0; j < antrian[0].size(); j++) {
                pasien t = antrian[0].get(j);
                System.out.println(t.getNoantri() + " " + t.getNama() + " " + t.getTransaksi());
            }
            System.out.println("");
        } else {
            System.out.println("-Antrian Kosong-");
        }
        System.out.println("No Antrian - - Nama Pasien - - Jumlah Pembayaran");
        System.out.println("DATA ANTRIAN RADIOLOGI :");
        if (!(antrian[1].isEmpty())) {
            for (int j = 0; j < antrian[1].size(); j++) {
                pasien t = antrian[1].get(j);
                System.out.println(t.getNoantri() + " " + t.getNama() + " " + t.getTransaksi());
            }
            System.out.println("");
        } else {
            System.out.println("-Antrian Kosong-");
        }
        System.out.println("No Antrian - - Nama Pasien - - Jumlah Pembayaran");
        System.out.println("DATA ANTRIAN DOKTER :");
        if (!(antrian[2].isEmpty())) {
            for (int j = 0; j < antrian[2].size(); j++) {
                pasien t = antrian[2].get(j);
                System.out.println(t.getNoantri() + " " + t.getNama() + " " + t.getTransaksi());
            }
            System.out.println("");
        } else {
            System.out.println("-Antrian Kosong-");
        }
        System.out.println("No Antrian - - Nama Pasien - - Jumlah Pembayaran");
        System.out.println("DATA ANTRIAN RAWAT JALAN :");
        if (!(antrian[3].isEmpty())) {
            for (int j = 0; j < antrian[3].size(); j++) {
                pasien t = antrian[3].get(j);
                System.out.println(t.getNoantri() + " " + t.getNama() + " " + t.getTransaksi());
            }
            System.out.println("");
        } else {
            System.out.println("-Antrian Kosong-");
        }
    }

    static void prosesData() {
        int x = 1;
        if (!kosong(3)) {
            for(int p = 0; p<antrian[x+2].size(); p++){
                dt.add(antrian[x+2].get(p));
            }
            antrian[x+2].clear();
        }
        if (!kosong(2)) {
            antrian[x+2]=(ArrayList<pasien>) antrian[x+1].clone();
            antrian[x+1].clear();
        }
        if (!kosong(1)) {
            antrian[x+1] = (ArrayList<pasien>) antrian[x].clone();
            antrian[x].clear();
        }
        if (!kosong(0)) {
            antrian[x] = (ArrayList<pasien>) antrian[x - 1].clone();
            antrian[x - 1].clear();
        }
    }

}
