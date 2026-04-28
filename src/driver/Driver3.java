package driver;

import java.util.Scanner;
import model.Model3;

public class Driver3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Model3 kafetaria = new Model3();

        // Tampilkan menu
        kafetaria.tampilMenu();

        // Input pilihan
        System.out.print("\nPilih makanan (1-6): ");
        int makanan = input.nextInt() - 1;

        System.out.print("Pilih minuman (1-4): ");
        int minuman = input.nextInt() - 1;

        // Validasi sederhana
        if (makanan < 0 || makanan >= 6 || minuman < 0 || minuman >= 4) {
            System.out.println("Pilihan tidak valid.");
        } else {
            boolean sukses = kafetaria.pesan(makanan, minuman);

            if (sukses) {
                System.out.println("\nAnda memesan: ");
                System.out.println("Makanan: " + kafetaria.getMakanan(makanan));
                System.out.println("Minuman: " + kafetaria.getMinuman(minuman));
                System.out.println("Pesanan anda akan kami proses");
            } else {
                System.out.println("Stok habis, silakan pilih menu lain.");
            }
        }

        input.close();
    }
}
