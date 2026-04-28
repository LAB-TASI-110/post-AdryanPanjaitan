package driver;

import java.util.Scanner;
import model.Model2;

public class Driver2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = Integer.parseInt(input.nextLine());

        Model2[] daftarGudang = new Model2[N];

        for (int i = 0; i < N; i++) {
            String nama = input.nextLine();
            int stok = Integer.parseInt(input.nextLine());
            String kategori = input.nextLine();

            daftarGudang[i] = new Model2(nama, stok, kategori);
        }

        String kategoriDicari = input.nextLine();

        int totalStok = 0;

        for (int i = 0; i < daftarGudang.length; i++) {
            if (daftarGudang[i].getKategori().equalsIgnoreCase(kategoriDicari)) {
                totalStok += daftarGudang[i].getStok();
            }
        }

        System.out.println("Kategori: " + kategoriDicari);
        System.out.println("Total Stok: " + totalStok + " pcs");

        input.close();
    }
}