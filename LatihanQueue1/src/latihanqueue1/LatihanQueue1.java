/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanqueue1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class LatihanQueue1 {

    static final int MAXDATA = 10;
    static Scanner scn = new Scanner(System.in);
    static int nourut = 0;

    static ArrayQueue<dataBayar> antrian = new ArrayQueue<dataBayar>(MAXDATA);
    static ArrayList<dataBayar> kasir = new ArrayList<dataBayar>();

    static class dataBayar {

        int nomor, bayar;
        String nama;

        dataBayar(int a, String b, int c) {
            nomor = a;
            nama = b;
            bayar = c;
        }

        public int getNomor() {
            return nomor;
        }

        public void setNomor(int nomor) {
            this.nomor = nomor;
        }

        public int getBayar() {
            return bayar;
        }

        public void setBayar(int bayar) {
            this.bayar = bayar;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        int pilih = 0;
        do {
            System.out.println("MENU");
            System.out.println("1. Masuk Antrian");
            System.out.println("2. Lihat Data ANtrian");
            System.out.println("2. Bayar atau Proses");
            System.out.println("Masukkan Menu Tujuan : ");
            pilih = scn.nextInt();
            switch (pilih) {
                case 1:
                    inputantrian();
                    break;
                case 2:
                    lihatdata();
                    break;
                case 3:
                    proses();
                    break;
            }
        } while (pilih > 0);

    }

    static void inputantrian() {
        int bayar;
        String nama;
        System.out.println("1. Masukkan Nama Pembeli : ");
        nama = scn.next();
        System.out.println("2. Masukkan Bayar : ");
        bayar = scn.nextInt();
        antrian.offer(new dataBayar(nourut, nama, bayar));
        nourut++;

    }

    static void lihatdata() {
        for(int i=0; i<antrian.size();i++){
            System.out.println(antrian.get(i).getNomor() + " " + 
                    antrian.get(i).getNama()+ " " +
                    antrian.get(i).getBayar()+ " ");
        }
        for(int i=0; i<kasir.size();i++){
            System.out.println(kasir.get(i).getNomor() + " " + 
                    kasir.get(i).getNama()+ " " +
                    kasir.get(i).getBayar()+ " ");
        }
    }

    static void proses() {
        if(!antrian.isEmpty()){
            kasir.add(antrian.poll());
            System.out.println("Berhasil DIproses");
        }
        System.out.println("Antrian Kosong");
    }

}
