/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihansort1.pkg2020130002;

import java.util.Scanner;

/**
 *
 * @author asus
 */
public class LatihanSort12020130002 {

    static Mahasiswa dt[] = new Mahasiswa[100];
    static int d = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scn = new Scanner(System.in);
        int m = 0;
        do {
            System.out.println("SELAMAT DATANG DI PORTAL AKADEMIK MAHASISWA");
            System.out.println("-------------------------------------------");
            System.out.println("1. Tambah Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Urut Berdasarkan Nilai Tugas");
            System.out.println("4. Urut Berdasarkan Nilai UTS");
            System.out.println("5. Urut Berdasarkan Nilai UAS");
            System.out.println("6. Urut Berdasarkan NPM");
            System.out.println("7. Urutkan Mata Kuliah");
            System.out.println("8. Cari Data NPM (Sequence Sort)");
            System.out.println("9. Cari Data KodeMK (Binary Sort)");
            System.out.println("10. Keluar");
            System.out.print("Pilihan : ");
            m = scn.nextInt();
            switch (m) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    tampikanData();
                    break;
                case 3:
                    nilaiminsort(dt, d);
                    break;
                case 4:
                    utsmaxsort(dt, d);
                    break;
                case 5:
                    insertsort(dt, d);
                    break;
                case 6:
                    bubblesort(dt, d);
                    break;
                case 7:
                    sortMatkul(dt, d);
                    break;
                case 8:
                    caridata(dt, d);
                    break;
                case 9:
                    caribiner(dt, d);
                    break;
            }
        } while (m != 10);
    }

    public static void tambahData() {
        Scanner scn = new Scanner(System.in);
        String npm = null, kodemk;
        int nilaitugas, nilaiuts, nilaiuas;
        System.out.print("NPM Mahasiswa/i : ");
        npm = scn.next();
        System.out.print("Kode Mata Kuliah : ");
        kodemk = scn.next();
        System.out.print("Nilai Tugas (0-100) : ");
        nilaitugas = scn.nextInt();
        System.out.print("Nilai UTS (0-100) : ");
        nilaiuts = scn.nextInt();
        System.out.print("Nilai UAS (0-100) : ");
        nilaiuas = scn.nextInt();
        dt[d] = new Mahasiswa(npm, kodemk, nilaitugas, nilaiuts, nilaiuas);
        d++;
    }

    public static void nilaiminsort(Mahasiswa[] x, int m) {
        int kecil;
        for (int i = 1; i < m; i++) {
            kecil = i;
            for (int j = i + 1; j < m; j++) {
                if (x[j - 1].getNilaitugas() < x[kecil - 1].getNilaitugas()) {
                    kecil = j;
                }
            }
            if (kecil != i) {
                Mahasiswa temp = x[kecil - 1];
                x[kecil - 1] = x[i - 1];
                x[i - 1] = temp;
            }
        }
        tampikanData();
    }

    public static void utsmaxsort(Mahasiswa[] x, int m) {
        int besar;
        Mahasiswa temp;
        for (int i = m; i > 1; i--) {
            besar = i;
            for (int j = i - 1; j > 0; j--) {
                if (x[j - 1].getNilaiuts() > x[besar - 1].getNilaiuts()) {
                    besar = j;
                }
            }
            if (besar != i) {
                temp = x[i - 1];
                x[i - 1] = x[besar - 1];
                x[besar - 1] = temp;
            }
        }
        tampikanData();
    }

    public static void insertsort(Mahasiswa[] x, int m) {
        Mahasiswa temp;
        int j;
        for (int i = 2; i <= m; i++) {
            for (j = 1; x[j - 1].getNilaiuas() < x[i - 1].getNilaiuas() && j < i; j++);
            if (j < i) {
                temp = x[i - 1];
                for (int k = i; k > j; k--) {
                    x[k - 1] = x[k - 2];
                }
                x[j - 1] = temp;
            }
        }
        tampikanData();
    }

    public static void sortMatkul(Mahasiswa[] x, int m) {
        Mahasiswa temp;
        int j;
        for (int i = 2; i <= m; i++) {
            for (j = 1; (x[j - 1].getKodemk().compareToIgnoreCase(x[i - 1].getKodemk()) < 0) && j < i; j++);
            if (j < i) {
                temp = x[i - 1];
                for (int k = i; k > j; k--) {
                    x[k - 1] = x[k - 2];
                }
                x[j - 1] = temp;
            }
        }
        tampikanData();
    }

    public static void bubblesort(Mahasiswa[] x, int m) {
        Mahasiswa temp;
        for (int i = m; i > 1; i--) {
            for (int j = m; j > 1; j--) {
                if (x[j - 2].getNpm().compareTo(x[j - 1].getNpm()) > 0) {
                    temp = x[j - 2];
                    x[j - 2] = x[j - 1];
                    x[j - 1] = temp;
                }
            }
        }
        tampikanData();
    }

    public static void tampikanData() {
        int j = d - 1;
        System.out.println("NPM Mahasiswa - - Kode MataKuliah - - Nilai Tugas - - Nilai UTS - - Nilai UAS");
        for (int a = 0; a <= j; a++) {
            System.out.println("____________________________________________________________________");
            System.out.println(" | " + dt[a].getNpm() + " | - - | " + dt[a].getKodemk() + " | - - | " + dt[a].getNilaitugas() + " | - - | "
                    + dt[a].getNilaiuts() + " | - - | " + dt[a].getNilaiuas() + " | ");
        }
        System.out.println("____________________________________________________________________");
    }

    public static void caridata(Mahasiswa[] d, int m) {
        String cari = null;
        Scanner scn = new Scanner(System.in);
        System.out.print("Data NPM yang ingin dicari : ");
        cari = scn.next();
        int i = 0;
        while (i < m - 1 && !d[i].getNpm().equalsIgnoreCase(cari)) {
            System.out.println(i + " - " + cari);
            i++;

        }
        if (d[i].getNpm().equalsIgnoreCase(cari)) {
            System.out.println(cari + " NPM Ditemukan di posisi " + i);
        } else {
            System.out.println(cari + " tidak ditemukan");
        }
    }

    public static boolean terurut(Mahasiswa[] d, int m) {
        boolean temp = true;
        for (int i = 0; i < m - 1; i++) {
            if (d[i].getKodemk().compareToIgnoreCase(d[i + 1].getKodemk()) > 0) {
                temp = false;
            }

        }
        return (temp);
    }

    public static void caribiner(Mahasiswa[] d, int m) {
        if (!terurut(d, m)) {
            System.out.println("Data Kode Mata Kuliah Belum Terurut");
        } else {
            String cari = null;
            Scanner scn = new Scanner(System.in);
            System.out.print("Data Kode Mata Kuliah yang Dicari : ");
            cari = scn.next();
            int b = 0, a = m - 1;
            int t = (b + a) / 2;
            while (!d[t].getKodemk().equalsIgnoreCase(cari) && b <= a) {
                if (d[t].getKodemk().compareToIgnoreCase(cari)<0) {
                    b = t + 1;
                } else {
                    a = t - 1;
                }
                t = (b + a) / 2;
            }
            if (d[t].getKodemk().equalsIgnoreCase(cari)) {
                System.out.println(cari + " ketemu ");
            } else {
                System.out.println(cari + " tidak ketemu");
            }
        }

    }

}
