#  Proyek Akhir Pemrograman Berbasis Objek 1
Proyek ini adalah contoh sederhana aplikasi pemesanan tiket kereta menggunakan Java sebagai tugas akhir dari mata kuliah pemrograman berbasis objek 1.

## deskripsi
Aplikasi ini dirancang untuk memproses pemesanan tiket kereta. Pengguna dapat melihat daftar tiket yang tersedia (kelas ekonomi dan eksekutif), memilih tiket, memasukkan jumlah tiket yang ingin dibeli, dan mendapatkan rincian harga akhir. 
Program ini juga menerapkan diskon pada tiket ekonomi dan biaya tambahan pada tiket eksekutif. Program memanfaatkan konsep class, object, inheritance, polymorphism, encapsulation, serta pengendalian alur dengan seleksi, perulangan, dan error handling.

##penjelasan kode
Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:
1. **Class** adalah template atau blueprint dari object. Pada kode ini, `PemesananTiketKereta`, `Tiket`, `TiketEkonomi`, `TiketEksekutif`, `Pemesanan`, adalah contoh dari class.
```bash
public class PemesananTiketKereta {
...
}
class Tiket {
...
}
class TiketEkonomi extends Tiket {
...
}
class TiketEksekutif extends Tiket {
...
}
class Pemesanan{
...
}
```

2. **Object** adalah instance dari class. Pada kode ini, `Scanner scanner = new Scanner(System.in);`, `new TiketEkonomi(...)`, `new TiketEksekutif(...)`, `Pemesanan pemesanan = new Pemesanan(...);`, adalah contoh pembuatan object.
```bash
Scanner scanner = new Scanner(System.in);

new TiketEkonomi(...), 
new TiketEkonomi(...), 
new TiketEksekutif(...),
new TiketEksekutif(...); 

Pemesanan pemesanan = new Pemesanan(...);
```
3. **Atribut** adalah variabel yang ada dalam class. Pada kode ini, `dari`, `ke`, `harga`, `tiket`, `namaPemesan`, `jumlahTiket`, adalah contoh atribut.
```bash
private String dari;
private String ke;
private int harga;

private Tiket tiket;
private String namaPemesan;
private int jumlahTiket;
```

4. **Constructor** adalah method yang pertama kali dijalankan pada saat pembuatan object. Pada kode ini, constructor ada di dalam class `Tiket`, `TiketEkonomi`, `TiketEksekutif`, `Pemesanan`, 
```bash 
public Tiket(String dari, String ke, int harga) {
    this.dari = dari;
    this.ke = ke;
    this.harga = harga;
}

public TiketEkonomi(String dari, String ke, int harga) {
    super(dari, ke, harga);
}

public TiketEksekutif(String dari, String ke, int harga) {
    super(dari, ke, harga);
}

public Pemesanan(Tiket tiket, String namaPemesan, int jumlahTiket) {
    this.tiket = tiket;
    this.namaPemesan = namaPemesan;
    setJumlahTiket(jumlahTiket);
}
```

5. **Mutator** atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini, `setJumlahTiket` adalah contoh method mutator.
```bash
public void setJumlahTiket(int jumlahTiket) {
    if (jumlahTiket <= 0) {
        ...
    }
    this.jumlahTiket = jumlahTiket;
}
```

6. **Accessor** atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, `getDari`, `getKe`, `getHarga`, dan `getJumlahTiket`, adalah contoh method accessor.
```bash
public String getDari() {
        return dari;
    }

public String getKe() {
        return ke;
  }

public int getHarga() {
        return harga;
  }

public int getJumlahTiket() {
        return jumlahTiket;
  }
```

7. **Encapsulation** adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses melalui method. Pada kode ini, atribut `dari`, `ke`, `harga`, `tiket`, `namaPemesan`, dan `jumlahTiket` dienkapsulasi dan hanya bisa diakses melalui method getter dan setter.
```bash
private String dari;
private String ke;
private int harga;

private Tiket tiket;
private String namaPemesan;
private int jumlahTiket;
```

8. **Inheritance** adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, `TiketEkonomi` dan `TiketEksekutif` mewarisi `Tiket`  dengan sintaks `extends`.
```bash
class TiketEkonomi extends Tiket {
...
}
class TiketEksekutif extends Tiket {
...
}
```

9. **Polymorphism** adalah konsep di mana sebuah nama dapat digunakan untuk merujuk ke beberapa tipe atau bentuk objek berbeda. Ini memungkinkan metode-metode dengan nama yang sama untuk berperilaku berbeda tergantung pada tipe objek yang mereka manipulasi, polymorphism bisa berbentuk Overloading ataupun Overriding. Pada kode ini,  Method `hitungHarga` di `TiketEkonomi` dan `TiketEksekutif` merupakan override method hitungHarga di `Tiket`.
```bash

 public int hitungHarga(int jumlahTiket) {
        return jumlahTiket * harga;
    }

public int hitungHarga(int jumlahTiket) {
    int totalHarga = super.hitungHarga(jumlahTiket);
    return totalHarga - (totalHarga * 10 / 100);
}

public int hitungHarga(int jumlahTiket) {
    int totalHarga = super.hitungHarga(jumlahTiket);
    return totalHarga + (totalHarga * 20 / 100);
}
```

10. **Seleksi** adalah statement kontrol yang digunakan untuk membuat keputusan berdasarkan kondisi. Pada kode ini, digunakan seleksi `if (pilihan < 1` dalam method `main()` dan seleksi `if (jumlahTiket <= 0)` dalam method `setJumlahTiket`.
```bash
if (pilihan < 1 || pilihan > daftarTiket.length) {
    System.out.println("Pilihan tidak valid.");
    return;
}

if (jumlahTiket <= 0) {
    throw new IllegalArgumentException("Jumlah tiket harus lebih dari 0.");
}
```


11. **Perulangan** adalah statement kontrol yang digunakan untuk menjalankan blok kode berulang kali. Pada kode ini, digunakan loop `for` untuk meminta input dan menampilkan data.
```bash
for (int i = 0; i < daftarTiket.length; i++) {
            ....
        }
```

12. **Input Output Sederhana** digunakan untuk menerima input dari user dan menampilkan output ke user. Pada kode ini, digunakan class `Scanner` untuk menerima input dan method `System.out.println` untuk menampilkan output.
```bash
 System.out.print("\nPilih tiket (masukkan nomor tiket): ");
        int pilihan = scanner.nextInt();

scanner.nextLine();
        System.out.print("Masukkan nama pemesan: ");
        String namaPemesan = scanner.nextLine();

System.out.print("Masukkan jumlah tiket yang ingin dipesan: ");
        int jumlahTiket = scanner.nextInt();


 System.out.println((i + 1) + ". Dari: " + daftarTiket[i].getDari() + " ke " + daftarTiket[i].getKe() +
                    " - Harga: Rp" + daftarTiket[i].getHarga() + 
                    " (" + daftarTiket[i].getClass().getSimpleName() + ")");
        }

System.out.println("\nRincian Pemesanan:");
System.out.println("Nama Pemesan: " + namaPemesan);
System.out.println("Dari: " + tiket.getDari());
System.out.println("Ke: " + tiket.getKe());
System.out.println("Jumlah Tiket: " + jumlahTiket);
System.out.println("Total Harga: Rp" + tiket.hitungHarga(jumlahTiket));

```

13. **Array** adalah struktur data yang digunakan untuk menyimpan beberapa nilai dalam satu variabel. Pada kode ini, `Tiket[] daftarTiket =` adalah contoh penggunaan array.
```bash
Tiket[] daftarTiket = {
            ...
};
```

14. **Error Handling** digunakan untuk menangani error yang mungkin terjadi saat runtime. Pada kode ini, digunakan `throw` untuk memvalidasi jumlah tiket yang dimasukkan.
```bash
 if (jumlahTiket <= 0) {
            throw new IllegalArgumentException("Jumlah tiket harus lebih dari 0.");
        }
```
## Usulan nilai

| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |

## Pembuat

Nama: Dimas Adrian
NPM: 2310010507
