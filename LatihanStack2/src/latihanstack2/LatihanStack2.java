/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanstack2;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author asus
 */
public class LatihanStack2 {

    static Scanner scn = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Stack<String> undo = new Stack<>();
        Stack<String> redo = new Stack<>();
        int pilih = 0;

        do {
            System.out.println("Pilihan Operasi : ");
            System.out.println("0. Titik");
            System.out.println("1. Garis");
            System.out.println("2. Kotak");
            System.out.println("3. Lingkaran");
            System.out.println("4. Tulisan");
            System.out.println("5. Warna");
            System.out.println("6. Hapus");
            System.out.println("7. Menampilkan Undo-Redo");
            System.out.println("8. Menampilkan Undo");
            System.out.println("9. Menampikan Redo");
            System.out.println("Pilihan (-1 keluar) : ");
            pilih = scn.nextInt();
            switch (pilih) {
                case 0:
                    undo.push("titik");
                    break;
                case 1:
                    undo.push("garis");
                    break;
                case 2:
                    undo.push("kotak");
                    break;
                case 3:
                    undo.push("lingkaran");
                    break;
                case 4:
                    undo.push("tulisan");
                    break;
                case 5:
                    undo.push("warna");
                    break;
                case 6:
                    undo.push("hapus");
                    break;
                case 7:
                    System.out.println("undo : " + undo);
                    System.out.println("redo : " + redo);
                    break;
                case 8:
                    redo.push(undo.pop());
                    break;
                case 9:
                    undo.push(redo.pop());
                    break;
            }
        } while (pilih > -1);

    }

}
