/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanutsstrukdat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class LatihanUTSStrukdat {


    static Scanner scn = new Scanner(System.in);
    static int nourut = 0;
    static ArrayList<dataBaju> dt = new ArrayList<>();
    static ArrayQueue<dataBaju> dtproses = new ArrayQueue<dataBaju>();
    static ArrayQueue<dataBaju> antrian[] = new ArrayQueue[3];

    public static void main(String[] args) {
        //no urut//nopesanan//jumlah kain (kain dianggap sama semua)
        //Class data hanya 3 no urut, jumlah kain, no pesanan (diinput) ke berapa
        /*Proses Produksi 
        1. Potong
        2. Celup
        3. Jahit
        
        ada 3 antrian (potong, celup, jahit);
        proses celup : (cek dlu antrian sebelumnya)
        potong sudah selesai maka antriancelup.offer(antrianpotong.poll);
        proses jahit : (cek dlu antrian sebelumnya)
        antrianjahit.offer(antriancelup.poll()); 
        dataBajuJadi : (cek dlu antrian sebelumnya)
        databaju.add(antrianjahit.poll());    
         */
        // TODO code application logic here 
        for (int i = 0; i < 3; i++) {
            antrian[i] = new ArrayQueue<dataBaju>();
        }
        int pilih = 0;
        do {
            System.out.println("MENU UTAMA");
            System.out.println("1. Input Data Antrian");
            System.out.println("2. Lihat Data");
            System.out.println("3. Proses Baju Potong");
            System.out.println("4. Proses Baju Celup");
            System.out.println("5. Proses Baju Jahit");
            System.out.println("6. Proses Produksi Sekaligus");
            System.out.println("7. Cari Data Dengan No Urut");
            System.out.println("8. Ubah Data Dengan Jadi No Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Masukkan Pilihan Anda : ");
            pilih = scn.nextInt();
            switch (pilih) {
                case 1:
                    tambahPesanan();
                    break;
                case 2:
                    lihatData();
                    break;
                case 3:
                    prosesProduksi(1);
                    break;
                case 4:
                    prosesProduksi(2);
                    break;
                case 5:
                    prosesProduksi(3);
                    break;
                case 6:
                    prosesProduksiSekaligus();
                    break;
                case 7:
                    cariData();
                    break;
                case 8:
                    ubahdata();
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

    static boolean penuh(int i) {
        boolean tmp = true;
        if (antrian[i].size() < 100) {
            tmp = false;
        }
        return tmp;
    }

    static void tambahPesanan() {
        int nopesanan, jumlahpesanan;
        if (!penuh(0)) {
            System.out.println("Nomor Pesanan : ");
            nopesanan = scn.nextInt();
            while (!((nopesanan == 0))) {
                System.out.println("Jumlah Pesanan : ");
                jumlahpesanan = scn.nextInt();
                antrian[0].offer(new dataBaju(nourut, jumlahpesanan, nopesanan));
                nourut++;
                if (!penuh(0)) {
                    System.out.println("Nomor Pesanan : ");
                    nopesanan = scn.nextInt();
                } else {
                    nopesanan = 0;
                    System.out.println("Antrian Jahit Penuh!");
                }
            }
        } else {
            System.out.println("Antrian Jahit Penuh!");
        }
    }

    static void lihatData() {
        System.out.println("Data Antrian Potong : ");
        if (!antrian[0].isEmpty()) {
            for (int j = 0; j < antrian[0].size(); j++) {
                dataBaju t = antrian[0].get(j);
                System.out.println(t.getNourut() + " " + t.getNopesanan() + " " + t.getJumlahkain());
            }
            System.out.println("");
        }

        System.out.println("Data Antrian Celup : ");
        if (!antrian[1].isEmpty()) {
            for (int j = 0; j < antrian[1].size(); j++) {
                dataBaju t = antrian[1].get(j);
                System.out.println(t.getNourut() + " " + t.getNopesanan() + " " + t.getJumlahkain());
            }
            System.out.println("");

        }
        System.out.println("Data Antrian Jahit : ");
        if (!antrian[2].isEmpty()) {
            for (int j = 0; j < antrian[2].size(); j++) {
                dataBaju t = antrian[2].get(j);
                System.out.println(t.getNourut() + " " + t.getNopesanan() + " " + t.getJumlahkain());
            }
            System.out.println("");
        }

        System.out.println("Data Baju Jadi : ");
        if (!dt.isEmpty()) {
            for (int j = 0; j < dt.size(); j++) {
                dataBaju t = dt.get(j);
                System.out.println(t.getNourut() + " " + t.getNopesanan() + " " + t.getJumlahkain());
            }
            System.out.println("");

        }
    }

    static void prosesProduksi(int x) {
        // proses celup : (cek dlu antrian sebelumnya)
        //potong sudah selesai maka antriancelup.offer(antrianpotong.poll);
        switch (x) {
            case 1:
                if (!kosong(0) && (!penuh(1))) {
                    antrian[x].offer(antrian[x - 1].poll());
                } else {
                    System.out.println("Antrian Celup Penuh!");
                }
                break;
            case 2:
                if (!kosong(1) && (!penuh(2))) {
                    antrian[x].offer(antrian[x - 1].poll());
                } else {
                    System.out.println("Antrian Jahit Penuh!");
                }
                break;
            case 3:
                if (!kosong(2)) {
                    dt.add(antrian[x - 1].poll());
                }
                break;
        }
    }

    static void prosesProduksiSekaligus() {
        int x = 1;
        if (!kosong(2)) {
            do {
                dt.add(antrian[x + 1].poll());
            } while (!kosong(2));
        } else {
            System.out.println("Tidak Dapat Memproduksi Apapun");
        }
        if (!kosong(1) && (!penuh(2))) {
            do {
                antrian[x + 1].offer(antrian[x].poll());
            } while (!penuh(2) && !kosong(1));
        } else {
            if (kosong(1)) {
                System.out.println("Tidak Dapat Memproduksi Apapun");
            } else {
                System.out.println("Antrian Jahit Penuh!");
            }
        }
        if (!kosong(0) && (!penuh(1))) {
            do {
                antrian[x].offer(antrian[x - 1].poll());
            } while (!penuh(1) && !kosong(0));
        } else {
            if (kosong(0)) {
                System.out.println("Tidak Dapat Memproduksi Apapun");
            } else {
                System.out.println("Antrian Celup Penuh!");
            }
        }

    }

    static void hapusData() {
        int nomor = 0;
        nomor = scn.nextInt();

    }

    static void cariData() {
        int nomor = 0;
        boolean ketemu = false;
        nomor = scn.nextInt();
        for (int i = 0; i < 3; i++) {
            int b = 0, a = antrian[i].size() - 1;
            int t = (b + a) / 2;
            if (!antrian[i].isEmpty()) {
                while (!(antrian[i].get(t).getNourut() == nomor) && b <= a) {
                    if (antrian[i].get(t).getNourut() < nomor) {
                        b = t + 1;
                    } else {
                        a = t - 1;
                    }
                    t = (b + a) / 2;
                }
                if (antrian[i].get(t).getNourut() == nomor) {
                    String antr = "";
                    switch (i) {
                        case 0:
                            antr = "Proses Potong";
                            break;
                        case 1:
                            antr = "Proses Celup";
                            break;
                        case 2:
                            antr = "Proses Jahit";
                            break;
                    }
                    System.out.println("Antrian ke-" + nomor + " Berada di " + antr);
                    i = 3;
                    ketemu = true;
                } else if (!(antrian[i].get(t).getNourut() == nomor) && i >= 2) {
                    System.out.println("Antrian ke-" + nomor + " Tidak Ketemu");
                }
            } else {
                System.out.println("Belom Ada Data");
            }
        }
        if (!ketemu) {
            int x = cariJadi(nomor);
            if (x > -1) {
                dataBaju f = dt.get(x);
                System.out.println("Data Baju Sudah Jadi" + "\n" + "No Urut : " + f.getNourut()
                        + "\n" + "No Pesanan : " + f.getNopesanan()
                        + "\n" + "Jumlah : " + f.getJumlahkain());
            }
        }
    }

    static int caridiAntrian(int nomor) {
        int o = 0;
        for (int i = 0; i < 3; i++) {
            int b = 0, a = antrian[i].size() - 1;
            int t = (b + a) / 2;
            if (!antrian[i].isEmpty()) {
                while (!(antrian[i].get(t).getNourut() == nomor) && b <= a) {
                    if (antrian[i].get(t).getNourut() < nomor) {
                        b = t + 1;
                    } else {
                        a = t - 1;
                    }
                    t = (b + a) / 2;
                }
                if (antrian[i].get(t).getNourut() == nomor) {
                    String antr = "";
                    switch (i) {
                        case 0:
                            antr = "Proses Potong";
                            break;
                        case 1:
                            antr = "Proses Celup";
                            break;
                        case 2:
                            antr = "Proses Jahit";
                            break;
                    }
                    i = 3;
                } else if (!(antrian[i].get(t).getNourut() == nomor) && i >= 2) {
                    System.out.println("Antrian ke-" + nomor + " Tidak Ketemu");
                }
            } else {
                System.out.println("Belom Ada Data");
            }
        }
        return o;
    }

    //insertionSort
    static void Sorting(int[] d, int m) {
        int tmp, j;
        for (int i = 2; i <= m; i++) {
            for (j = 1; d[j - 1] < d[i - 1] && j < i; j++);
            if (j < i) {
                tmp = d[i - 1];
                for (int k = i; k > j; k--) {
                    d[k - 1] = d[k - 2];
                }
                d[j - 1] = tmp;
            }
            System.out.printf("Pengurutan : %d\n", i - 1);
        }
    }

    static int cariJadi(int nop) {
        int caridata = -1;
        int i = 0;
        Iterator t = dt.iterator();
        while (t.hasNext() && caridata == -1) {
            dataBaju tmp = (dataBaju) t.next();
            if (tmp.getNopesanan() == nop) {
                caridata = i;
            }
            i++;
        }
        return (caridata);
    }

    static void ubahdata() {
        int nou, nop, jum;
        System.out.printf("No Pesanan yang akan diubah : ");
        nop = scn.nextInt();
        int c = cariJadi(nop);
        if (c > -1) {
            System.out.printf("Jumlah : ");
            jum = scn.nextInt();
            nou = dt.get(c).getNourut();
            nop = dt.get(c).getNopesanan();
            dt.set(nou, new dataBaju(nou, jum, nop));
        } else if (c < 0) {

        } else {
            System.out.println("Data Not Found!");
        }
    }

    /*static void prosesPotong(int b) {
        int x =0;
        int besar = 0;
        String bahan = "";
        String ukuran = "";
        String warna = "";
        if (!antrian[2].isEmpty()) {
            do {
                antrian[2].offer(antrian[1].poll());
                x++;
            } while (x<=(antrian[1].size()-1)-b);
            System.out.println("baju berhasil memasuki proses potong\n");
        }
        System.out.println("antrian kosong\n");
    }*/
}
