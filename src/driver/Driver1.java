package driver;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import model.Model1;

public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Inisialisasi Database Kota berdasarkan tabel gambar
        Map<String, Model1.City> daftarKota = new HashMap<>();
        daftarKota.put("MDN", new Model1.City("Medan", 8000, "Dalam Pulau"));
        daftarKota.put("BLG", new Model1.City("Balige", 5000, "Dalam Pulau"));
        daftarKota.put("JKT", new Model1.City("Jakarta", 12000, "Luar Pulau"));
        daftarKota.put("SBY", new Model1.City("Surabaya", 13000, "Luar Pulau"));

        System.out.println("Selamat Datang di Sistem Otomasi Del-Express");
        
        while (true) {
            // 1. Input Kode Kota
            System.out.print("Masukkan Kode Kota (MDN/BLG/JKT/SBY) atau 'END': ");
            String inputKode = scanner.next().toUpperCase();

            if (inputKode.equals("END")) {
                System.out.println("Sistem dimatikan. Terima kasih!");
                break;
            }

            // Validasi Kota
            if (!daftarKota.containsKey(inputKode)) {
                System.out.println(">> Error: Kode kota tidak valid. Silakan coba lagi.");
                continue;
            }

            // 2. Input Berat Butet
            System.out.print("Masukkan Berat Paket Butet (kg): ");
            if (!scanner.hasNextDouble()) {
                System.out.println(">> Error: Masukkan angka untuk berat paket!");
                scanner.next(); // Clear invalid input
                continue;
            }

            double beratInput = scanner.nextDouble();
            if (beratInput <= 0) {
                System.out.println(">> Error: Berat paket harus lebih dari 0!");
                continue;
            }

            // 3. Proses dan Output
            Model1.City kotaPilihan = daftarKota.get(inputKode);
            Model1.Shipment transaksi = new Model1.Shipment(kotaPilihan, beratInput);
            transaksi.tampilkanStruk();
        }

        scanner.close();
    }
}

