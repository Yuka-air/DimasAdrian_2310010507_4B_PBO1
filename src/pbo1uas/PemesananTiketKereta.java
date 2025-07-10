/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo1uas;

/**
 *
 * @author acer3
 */

import java.util.Scanner;

public class PemesananTiketKereta {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Daftar tiket kereta menggunakan array
        Tiket[] daftarTiket = {
            new TiketEkonomi("Jakarta", "Bandung", 150000),
            new TiketEkonomi("Jakarta", "Yogyakarta", 350000),
            new TiketEksekutif("Bandung", "Surabaya", 400000),
            new TiketEksekutif("Surabaya", "Malang", 200000)
        };

        // Menampilkan daftar tiket
        System.out.println("Selamat datang di aplikasi pemesanan tiket kereta!");
        System.out.println("Daftar tiket yang tersedia:");
        for (int i = 0; i < daftarTiket.length; i++) {
            System.out.println((i + 1) + ". Dari: " + daftarTiket[i].getDari() + " ke " + daftarTiket[i].getKe() +
                    " - Harga: Rp" + daftarTiket[i].getHarga() + 
                    " (" + daftarTiket[i].getClass().getSimpleName() + ")");
        }

        
        System.out.print("\nPilih tiket (masukkan nomor tiket): ");
        int pilihan = scanner.nextInt();
        if (pilihan < 1 || pilihan > daftarTiket.length) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        Tiket tiketDipilih = daftarTiket[pilihan - 1];

        
        scanner.nextLine();
        System.out.print("Masukkan nama pemesan: ");
        String namaPemesan = scanner.nextLine();

        System.out.print("Masukkan jumlah tiket yang ingin dipesan: ");
        int jumlahTiket = scanner.nextInt();

        
        Pemesanan pemesanan = new Pemesanan(tiketDipilih, namaPemesan, jumlahTiket);

        
        pemesanan.tampilkanRincian();

        // Menutup scanner
        scanner.close();
    }
}

// Class Tiket (Parent Class)
class Tiket {
    private String dari;
    private String ke;
    private int harga;

    // Constructor
    public Tiket(String dari, String ke, int harga) {
        this.dari = dari;
        this.ke = ke;
        this.harga = harga;
    }

    // Getter
    public String getDari() {
        return dari;
    }

    public String getKe() {
        return ke;
    }

    public int getHarga() {
        return harga;
    }

    
    public int hitungHarga(int jumlahTiket) {
        return jumlahTiket * harga;
    }
}

// Class TiketEkonomi (Subclass)
class TiketEkonomi extends Tiket {

    // Constructor
    public TiketEkonomi(String dari, String ke, int harga) {
        super(dari, ke, harga);
    }

    @Override
    public int hitungHarga(int jumlahTiket) {
        // Diskon 10% untuk Tiket Ekonomi
        int totalHarga = super.hitungHarga(jumlahTiket);
        return totalHarga - (totalHarga * 10 / 100);
    }
}

// Class TiketEksekutif (Subclass)
class TiketEksekutif extends Tiket {

    // Constructor
    public TiketEksekutif(String dari, String ke, int harga) {
        super(dari, ke, harga);
    }

    @Override
    public int hitungHarga(int jumlahTiket) {
        // Tambahan biaya 20% untuk Tiket Eksekutif
        int totalHarga = super.hitungHarga(jumlahTiket);
        return totalHarga + (totalHarga * 20 / 100);
    }
}

// Class Pemesanan
class Pemesanan {
    private Tiket tiket;
    private String namaPemesan;
    private int jumlahTiket;

    // Constructor
    public Pemesanan(Tiket tiket, String namaPemesan, int jumlahTiket) {
        this.tiket = tiket;
        this.namaPemesan = namaPemesan;
        setJumlahTiket(jumlahTiket);
    }

    // Getter
    public int getJumlahTiket() {
        return jumlahTiket;
    }

    // Setter
    public void setJumlahTiket(int jumlahTiket) {
        if (jumlahTiket <= 0) {
            throw new IllegalArgumentException("Jumlah tiket harus lebih dari 0.");
        }
        this.jumlahTiket = jumlahTiket;
    }

    // Menampilkan rincian pemesanan
    public void tampilkanRincian() {
        System.out.println("\nRincian Pemesanan:");
        System.out.println("Nama Pemesan: " + namaPemesan);
        System.out.println("Dari: " + tiket.getDari());
        System.out.println("Ke: " + tiket.getKe());
        System.out.println("Jumlah Tiket: " + jumlahTiket);
        System.out.println("Total Harga: Rp" + tiket.hitungHarga(jumlahTiket));
    }
}
