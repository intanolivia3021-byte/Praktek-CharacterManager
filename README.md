
# Character Manager - Sprint #2

## 1. Deskripsi Proyek

Character Manager adalah program berbasis Java yang digunakan untuk mengelola data karakter. Proyek ini dibuat untuk memenuhi tugas praktikum Character Manager Sprint #2.

Program ini menerapkan konsep Object-Oriented Programming (OOP), seperti class, object, encapsulation, method overriding, reference object, static variable, dan penggunaan ArrayList.

## 2. Tujuan Proyek

Tujuan pembuatan proyek ini adalah:
- Memahami penggunaan class dan object dalam Java.
- Mengelola data karakter menggunakan ArrayList.
- Menerapkan method equals() untuk membandingkan nama karakter.
- Mencegah penambahan karakter dengan nama duplikat.
- Memahami konsep enkapsulasi dan defensive copy.
- Menghitung statistik karakter berdasarkan level dan tipe.

## 3. Fitur Program

### A. Pengelolaan Karakter
- Menambahkan karakter baru.
- Mencari karakter berdasarkan nama.
- Menghapus karakter berdasarkan nama.
- Menghitung jumlah karakter.
- Menampilkan seluruh karakter.
- Menolak nama karakter yang duplikat.

### B. Analisis Karakter
- Menghitung rata-rata level menggunakan getAverageLevel().
- Mencari karakter berdasarkan tipe menggunakan findByType().
- Menghitung jumlah karakter berdasarkan tipe menggunakan countByType().
- Mengembalikan nilai 0 jika rata-rata dihitung pada daftar kosong.

### C. Defensive Copy
Method getAllCharacters() mengembalikan salinan daftar karakter menggunakan ArrayList baru. Dengan cara ini, perubahan pada daftar hasil salinan tidak mengubah daftar internal CharacterManager.

### D. Object Reference
Program menguji dua variabel yang menunjuk objek Character yang sama. Jika level objek diubah melalui salah satu variabel, perubahan tersebut dapat dilihat melalui variabel lainnya.

### E. Static Counter
Variabel totalCharacterCreated menggunakan keyword static untuk menghitung jumlah objek Character yang dibuat selama program berjalan.

## 4. Tipe Karakter

Program menggunakan enum CharacterType yang terdiri dari:
- WARRIOR
- MAGE
- ARCHER
- HEALER

Setiap karakter mempunyai nama, level, dan tipe karakter.

## 5. Struktur Folder

```text
CharacterManager/
└── src/
    └── com/
        └── unpri/
            └── charactermanager/
                └── model/
                    ├── Character.java
                    ├── CharacterManager.java
                    ├── CharacterType.java
                    └── Main.java
```

## 6.Screenshot 
(<![alt text](<Screenshot 2026-10-16 043425.png>)

## 7. Contoh Pengujian

Program melakukan pengujian terhadap:
1. Penambahan karakter baru.
2. Penolakan nama duplikat, termasuk perbedaan huruf besar dan kecil.
3. Pencarian karakter berdasarkan nama.
4. Penghapusan karakter.
5. Perhitungan rata-rata level.
6. Pencarian karakter berdasarkan tipe.
7. Perhitungan jumlah karakter berdasarkan tipe.
8. Defensive copy untuk melindungi daftar internal.
9. Penggunaan reference object.
10. Penghitungan total objek yang dibuat.

## 8. Fitur Analitik Tambahan

Fitur tambahan yang dibuat adalah countByType(CharacterType type).

Method ini digunakan untuk menghitung jumlah karakter berdasarkan tipe tertentu. Contohnya, pengguna dapat mengetahui jumlah karakter bertipe MAGE tanpa menghitungnya secara manual.

Method ini juga menangani parameter null dengan mengembalikan nilai 0.

## 9. Analisis Teori

Analisis teori proyek membahas:
- Perbedaan variabel primitif dan reference object.
- Perilaku dua variabel yang merujuk objek yang sama.
- Fungsi keyword static.
- Alasan method equals() perlu di-override.
- Risiko mengembalikan ArrayList internal secara langsung.
- Pentingnya enkapsulasi dan defensive copy.

### Link Google Docs
https://docs.google.com/document/d/1IHTC13s3mpiGbU52oTX7Gs4FpFVkYvFcBfjUYw1UGnk/edit?usp=sharing



# Character Manager Sprint #3 - TP8

**Mata Kuliah:** Java Visual (SIH-6406)

## 1. Deskripsi

Character Manager adalah aplikasi Java Swing yang menampilkan
daftar karakter secara dinamis. Setiap karakter mempunyai nama,
level, dan tipe. Aplikasi juga menghitung jumlah karakter dan
rata-rata level secara otomatis.

## 2. Struktur Project

- `Main.java` - membuat data awal dan menjalankan GUI.
- `model/Character.java` - menyimpan data satu karakter.
- `model/CharacterType.java` - mendefinisikan tipe karakter.
- `model/CharacterManager.java` - mengelola daftar karakter.
- `view/MainWindow.java` - menampilkan data dan statistik.

## 3. Fitur

- Menampilkan daftar karakter dengan loop.
- Menghitung jumlah karakter.
- Menghitung rata-rata level secara dinamis.
- Menggunakan JFrame dan JLabel.
- Menjalankan GUI menggunakan SwingUtilities.invokeLater().
- Menggunakan konsep Model dan View dalam MVC.

## 4. Data Karakter

| Nama | Level | Tipe |
|---|---:|---|
| Arden | 10 | WARRIOR |
| Lyra | 15 | MAGE |
| Robin | 8 | ARCHER |
| Selena | 12 | HEALER |
| Darius | 20 | WARRIOR |

Rata-rata level setelah lima karakter ditambahkan adalah 13.00.

## 5. Screenshot

### Sebelum Perubahan

![Sebelum perubahan](![alt text](<Screenshot 2026-10-24 020800.png>)

### Sesudah Perubahan

![Sesudah perubahan](![alt text](<Screenshot 2026-10-24 021421.png>)

## 6. Aliran Data dan MVC

Main membuat CharacterManager dan menambahkan data karakter.
CharacterManager menyimpan serta mengelola daftar karakter.
MainWindow menerima objek CharacterManager, mengambil daftar
karakter, dan menampilkan setiap karakter menggunakan JLabel
melalui loop. Character dan CharacterManager bertindak sebagai
Model, sedangkan MainWindow berperan sebagai View. Main bertindak
sebagai titik awal program yang menghubungkan Model dengan View.

## 7. Analisis GUI dan MVC

Dokumen Google Docs:
https://docs.google.com/document/d/1ni4NK3k44BPRvJeJjvFviUdxoB0oqmEfYXMjW9lfDCc/edit?usp=sharing

## 8. Cara Menjalankan

1. Buka project melalui VS Code.
2. Pastikan Java dan Java Extension Pack tersedia.
3. Buka `Main.java`.
4. Klik Run.
5. Periksa daftar karakter dan statistik rata-rata level.


## TP10 — Character Manager Sprint #4

### A. Implementasi Tema

TP10 mengembangkan Character Manager v0.3 menjadi v0.4
dengan memisahkan pengaturan tampilan ke dalam AppTheme.
Warna kartu dan border disesuaikan dengan role karakter.
Level 5 atau lebih ditampilkan menggunakan teks emas dan tebal.
Jendela menggunakan pack() agar ukuran mengikuti komponen.

### B. Screenshot Sebelum dan Sesudah

#### Sebelum — v0.3

![Screenshot Character Manager v0.3]![alt text](<Screenshot 2026-10-24 021421-1.png>)

#### Sesudah — v0.4

![Screenshot Character Manager v0.4](![alt text](<Screenshot 2026-10-30 024545.png>))

### C. Analisis MVC

Warna disimpan di AppTheme karena warna merupakan bagian dari
presentasi aplikasi, bukan identitas atau aturan bisnis karakter.
Character pada layer Model menyimpan data karakter seperti nama,
level, dan role. AppTheme pada layer View menerjemahkan role menjadi
warna tanpa membuat Model bergantung pada Swing atau tampilan grafis.
Pemisahan ini membuat Model dapat digunakan kembali pada tampilan lain
tanpa harus mengubah kode warna.

### D. Dua Properti Tambahan

1. **ToolTipText:** kartu karakter memiliki tooltip yang berisi
   nama, HP, ATK, dan role. Ini membantu pengguna melihat informasi
   tambahan tanpa memenuhi layar dengan teks penjelasan.

2. **setEnabled(false):** karakter level 1 dan label di dalam kartunya
   dinonaktifkan. Properti ini menunjukkan penggunaan status komponen
   Swing secara programatis. Dalam aplikasi nyata, alasan penonaktifan
   sebaiknya dijelaskan kepada pengguna.

### E. Google Docs — Analisis Properti & MVC

https://docs.google.com/document/d/17EJiQUqYiMShUtL-EQUEj8LJuBsanNE5AzbmOW40o1s/edit?usp=sharing

