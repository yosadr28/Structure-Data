/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanutsstrukdat;

/**
 *
 * @author asus
 */
public class dataBaju {

    int nourut, jumlahkain, nopesanan;

    public dataBaju(int no, int jumlah, int nopes){
        nourut = no;
        jumlahkain = jumlah;
        nopesanan = nopes;
    }
    
    public int getNourut() {
        return nourut;
    }

    public void setNourut(int nourut) {
        this.nourut = nourut;
    }

    public int getJumlahkain() {
        return jumlahkain;
    }

    public void setJumlahkain(int jumlahkain) {
        this.jumlahkain = jumlahkain;
    }

    public int getNopesanan() {
        return nopesanan;
    }

    public void setNopesanan(int nopesanan) {
        this.nopesanan = nopesanan;
    }
}
