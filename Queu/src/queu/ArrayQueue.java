/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queu;

/**
 *
 * @author asus
 */
public class ArrayQueue<E> {
    //atribut

    private E[] data;
    private int idx, jumlah, ukuran;
    //konstruktor

    public ArrayQueue() {
        this(100);
    }

    public ArrayQueue(int ukr) {
        idx = 0;
        jumlah = 0;
        ukuran = ukr;
        data = (E[]) new Object[ukr];
    }

    public int size() {
        return (jumlah);
    }

    public boolean isEmpty() {
        return (jumlah == 0);
    }

    public void offer(E e) {
        if (jumlah < ukuran) {
            data[jumlah] = e;
            jumlah++;
        }
    }

    public E poll() {
        if (!isEmpty()) {
            E tmp = data[idx];
            for (int i = 0; i < jumlah - 1; i++) {
                data[i] = data[i + 1];
            }
            jumlah--;
            return (tmp);
        }
        return (null);
    }

    public E peek() {
        return (data[idx]);
    }

    @Override
    public String toString() {
        String tmp = "[";
        for (int i = idx; i < jumlah; i++) {
            tmp += data[i] + " ";
        }
        tmp += "]";
        return (tmp);
    }
}
