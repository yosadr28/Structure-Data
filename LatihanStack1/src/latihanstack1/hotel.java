/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanstack1;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author asus
 */
public class hotel {
    String nokamar, nama, alamat, notelp;
    LocalDate cekin;

    hotel(String a, String b, String c, String d, LocalDate f){
        nokamar = a;
        nama = b;
        alamat = c;
        notelp = d;
        cekin = f;
    }
    
    public String getNokamar() {
        return nokamar;
    }

    public void setNokamar(String nokamar) {
        this.nokamar = nokamar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public LocalDate getCekin() {
        return cekin;
    }

    public void setCekin(LocalDate cekin) {
        this.cekin = cekin;
    }
}
