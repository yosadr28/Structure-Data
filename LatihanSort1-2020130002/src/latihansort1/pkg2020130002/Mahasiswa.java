/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihansort1.pkg2020130002;

/**
 *
 * @author asus
 */
public class Mahasiswa {

    String npm, kodemk;
    int nilaitugas, nilaiuts, nilaiuas;

    Mahasiswa() {
        npm = "";
        kodemk = "";
        nilaitugas = 0;
        nilaiuas = 0;
        nilaiuts = 0;
    }

    Mahasiswa(String a, String b, int c, int d, int e) {
        npm = a;
        kodemk = b;
        nilaitugas = c;
        nilaiuas = e;
        nilaiuts = d;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getKodemk() {
        return kodemk;
    }

    public void setKodemk(String kodemk) {
        this.kodemk = kodemk;
    }

    public int getNilaitugas() {
        return nilaitugas;
    }

    public void setNilaitugas(int nilaitugas) {
        this.nilaitugas = nilaitugas;
    }

    public int getNilaiuts() {
        return nilaiuts;
    }

    public void setNilaiuts(int nilaiuts) {
        this.nilaiuts = nilaiuts;
    }

    public int getNilaiuas() {
        return nilaiuas;
    }

    public void setNilaiuas(int nilaiuas) {
        this.nilaiuas = nilaiuas;
    }

}
