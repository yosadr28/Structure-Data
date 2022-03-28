/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanqueue2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class LatihanQueue2 {

    public final static int MAXDATA = 2;
    static Scanner scn = new Scanner(System.in);
    static ArrayQueue<DataBayar> a[] = new ArrayQueue[3];
    static ArrayList<DataBayar> k[] = new ArrayList[2];
    static Random ack = new Random();
    static int urutan = 0;

    public static void main(String[] args) {
        // TODO code application logic here
        for (int i = 0; i < 3; i++) {
            a[i] = new ArrayQueue<DataBayar>(MAXDATA);
        }
        for (int i = 0; i < 2; i++) {
            k[i] = new ArrayList<DataBayar>();
        }
        int pilih = 0;
        do {
            System.out.println("MENU UTAMA");
            System.out.println("1. Input Data Antrian");
            System.out.println("2. Lihat Data");
            System.out.println("3. Proses Antrian Ke Kasir 1");
            System.out.println("3. Proses Antrian Ke Kasir 2");
            System.out.println("0. Keluar");
            pilih = scn.nextInt();
            switch (pilih) {
                case 1:
                    inputdata();
                    break;
                case 2:
                    lihatData();
                    break;
                case 3:
                    prosesData(1);
                    break;
                case 4:
                    prosesData(2);
                    break;
            }
        } while (pilih > 0);

    }

    static boolean penuh() {
        boolean tmp = true;
        for (int i = 0; i < 3; i++) {
            if ((a[i].size() < MAXDATA)) {
                tmp = false;
            }
        }
        return tmp;
    }

    static boolean kosong() {
        boolean tmp = true;
        for (int i = 0; i < 3; i++) {
            if (!(a[i].isEmpty())) {
                tmp = false;
            }
        }
        return tmp;
    }

    static void inputdata() {
        String nama;
        int r, bayar;
        if (!penuh()) {
            System.out.println("Masukan Nama X Untuk Keluar");
            System.out.println("Nama Pengantri");
            nama = scn.next();
            while (!nama.equalsIgnoreCase("X") && !penuh()) {
                System.out.println("Masukkan Jumlah Bayar : ");
                bayar = scn.nextInt();
                do {
                    r = ack.nextInt(3);
                } while (a[r].size() >= MAXDATA);
                a[r].offer(new DataBayar(urutan, nama, bayar));
                urutan++;
                System.out.println("Masukkan Nama : ");
                nama = scn.next();
            }

        }
    }

    static void lihatData() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Data Antrian " + (i + 1));
            if (!a[i].isEmpty()) {
                for (int j = 0; j < a[i].size(); j++) {
                    DataBayar t = a[i].get(j);
                    System.out.println(t.getNomor() + " " + t.getNama() + " " + t.getBayar());
                }
                System.out.println("");
            }
        }
        for (int i = 0; i < 2; i++) {
            System.out.println("Data Kasir " + (i + 1));
            if (!k[i].isEmpty()) {
                for (int j = 0; j < k[i].size(); j++) {
                    DataBayar t = k[i].get(j);
                    if (t != null) {
                        System.out.println(t.getNomor() + " " + t.getNama() + " " + t.getBayar());
                    }
                    System.out.println("");
                }
            }
        }
    }

    static void prosesData(int nok) {
        if (!kosong()) {
            int t = 0;
            for (int i = 1; i < 3; i++) {
                if (!a[i].isEmpty()) {
                    if (a[t].isEmpty()) {
                        t = i;
                    }
                } else {
                    if (a[t].peek().getNomor() > a[i].peek().getNomor()) {
                        t = i;
                    }
                }
                k[nok - 1].add(a[t].poll());
            }
        }
    }

}
