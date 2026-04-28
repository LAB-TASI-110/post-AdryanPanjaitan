package model;

public class Model1 {

    // Class untuk menyimpan data master tarif kota
    public static class City {
        String name;
        int costPerKg;
        String status; // "Dalam Pulau" atau "Luar Pulau"

        public City(String name, int costPerKg, String status) {
            this.name = name;
            this.costPerKg = costPerKg;
            this.status = status;
        }
    }

    // Class untuk menangani transaksi pengiriman
    public static class Shipment {
        private City city;
        private double beratButet;
        private double beratUcok;
        private double totalBerat;
        private double totalOngkir;
        private String promoDiskon = "-";
        private String promoAsuransi = "-";

        public Shipment(City city, double beratButet) {
            this.city = city;
            this.beratButet = beratButet;
            hitungTransaksi();
        }

        private void hitungTransaksi() {
            // Aturan Gambar: Berat Ucok = 3/2 * Berat Butet
            this.beratUcok = 1.5 * beratButet;
            this.totalBerat = beratButet + beratUcok;

            // Hitung biaya awal
            double biayaAwal = totalBerat * city.costPerKg;

            // Aturan Promo: Diskon 10% jika berat > 10kg
            if (totalBerat > 10) {
                double diskon = biayaAwal * 0.10;
                this.totalOngkir = biayaAwal - diskon;
                this.promoDiskon = "Diskon 10%";
            } else {
                this.totalOngkir = biayaAwal;
            }

            // Aturan Promo: Asuransi gratis jika Luar Pulau
            if (city.status.equalsIgnoreCase("Luar Pulau")) {
                this.promoAsuransi = "Gratis Asuransi";
            }
        }

        public void tampilkanStruk() {
            System.out.println("\n------- STRUK LAYANAN DEL-EXPRESS -------");
            System.out.println("Kota Tujuan     : " + city.name + " (" + city.status + ")");
            System.out.println("Berat Butet     : " + beratButet + " kg");
            System.out.println("Berat Ucok      : " + beratUcok + " kg");
            System.out.println("Total Berat     : " + totalBerat + " kg");
            System.out.println("------------------------------------------");
            System.out.println("Promo Diskon    : " + promoDiskon);
            System.out.println("Promo Tambahan  : " + promoAsuransi);
            System.out.println("TOTAL BAYAR     : Rp " + (int)totalOngkir);
            System.out.println("------------------------------------------\n");
        }
    }
}

