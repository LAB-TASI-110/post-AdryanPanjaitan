package model;

public class Model3 {
    private String[] makanan = {
        "Bakwan Goreng", "Tempe Krispi", "Sosis",
        "Nugget", "Kentang Goreng", "Piscok"
    };

    private String[] minuman = {
        "Teh Manis Dingin", "Matcha Dingin",
        "Chocolatos Dingin", "Cappucino Dingin"
    };

    private int[] stokMakanan = new int[6];
    private int[] stokMinuman = new int[4];

    private final int HARGA = 10000;

    // Constructor
    public Model3() {
        for (int i = 0; i < stokMakanan.length; i++) {
            stokMakanan[i] = 50;
        }
        for (int i = 0; i < stokMinuman.length; i++) {
            stokMinuman[i] = 50;
        }
    }

    // Tampilkan menu
    public void tampilMenu() {
        System.out.println("=== MENU MAKANAN ===");
        for (int i = 0; i < makanan.length; i++) {
            System.out.println((i + 1) + ". " + makanan[i] + 
                " | Harga: Rp." + HARGA + 
                " | Stok: " + stokMakanan[i]);
        }

        System.out.println("\n=== MENU MINUMAN ===");
        for (int i = 0; i < minuman.length; i++) {
            System.out.println((i + 1) + ". " + minuman[i] + 
                " | Harga: Rp." + HARGA + 
                " | Stok: " + stokMinuman[i]);
        }
    }

    // Proses pemesanan
    public boolean pesan(int pilihanMakanan, int pilihanMinuman) {
        if (stokMakanan[pilihanMakanan] > 0 && stokMinuman[pilihanMinuman] > 0) {
            stokMakanan[pilihanMakanan]--;
            stokMinuman[pilihanMinuman]--;
            return true;
        }
        return false;
    }

    public String getMakanan(int index) {
        return makanan[index];
    }

    public String getMinuman(int index) {
        return minuman[index];
    }
}