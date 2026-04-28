package model;

public class Model2 {
    private String namaBarang;
    private int stok;
    private String kategori;

    public Model2(String namaBarang, int stok, String kategori) {
        this.namaBarang = namaBarang;
        this.stok = stok;
        this.kategori = kategori;
    }

    public int getStok() {
        return stok;
    }

    public String getKategori() {
        return kategori;
    }

    public String getNamaBarang() {
        return namaBarang;
    }
}