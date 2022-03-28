/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanqueue2;

/**
 *
 * @author asus
 */
class DataBayar {

    int nomor;
    String nama;
    int bayar;
    
    public DataBayar(int no, String nam, int byr){
        nomor = no;
        nama = nam;
        bayar = byr;
    }

    public int getNomor() {
        return nomor;
    }

    public void setNomor(int nomor) {
        this.nomor = nomor;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getBayar() {
        return bayar;
    }

    public void setBayar(int bayar) {
        this.bayar = bayar;
    }
    
}
