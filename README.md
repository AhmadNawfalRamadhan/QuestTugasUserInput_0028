# QuestTugasUserInput_0028

Tugas **User Input** menggunakan **Jetpack Compose**: Form Biodata dengan tampilan neon laba-laba, input teks, pilihan tanggal, dropdown, checkbox, dan hasil input yang ditampilkan dalam card.

## Identitas

| | |
|---|---|
| Nama | Ahmad Nawfal Ramadhan |
| NIM | 20240140028 |
| Mata Kuliah | Pengembangan Aplikasi Mobile |
| Pertemuan | 5 |

## Hasil Running

| Form Belum Terisi | Form Sudah Terisi |
|:---:|:---:|
| ![Belum Terisi](<img width="369" height="814" alt="Screenshot 2026-10-17 160508" src="https://github.com/user-attachments/assets/5a7133b2-1fb2-4067-b961-96e87ba4801e" />
) | ![Sudah Terisi](<img width="359" height="801" alt="Screenshot 2026-10-17 160440" src="https://github.com/user-attachments/assets/40083cb1-9acf-4a5e-a1ec-3546ce4861c9" />
) |

## Fitur

- Input **Nama Depan**, **Nama Belakang**, dan **Email** dengan `OutlinedTextField`.
- **Tgl Lahir** dipilih lewat `DatePickerDialog` (ikon kalender).
- **Experience** dipilih lewat dropdown (`ExposedDropdownMenuBox`).
- **Skill** dipilih lewat checkbox (Android, UI/UX, Web), bisa lebih dari satu.
- Tombol **Proceed** nonaktif (abu-abu) sampai semua isian terisi.
- Setelah Proceed ditekan, data tampil di `ElevatedCard` hitam.

## Struktur Layout

- `Scaffold` sebagai bingkai halaman.
- `Box` di dalam Scaffold, berisi dua layer:
  1. `Image` laba-laba sebagai background.
  2. `Surface` putih dengan sudut atas membulat yang **mengapung** di atas gambar.
- Form di dalam `Column` dengan `verticalScroll`.

## Penerapan Rules

| Rule | Penerapan |
|---|---|
| Warna, gambar, kata di Resources | `colors.xml`, `strings.xml`, `dimens.xml`, dan `res/drawable/bg_spider.png` |
| Box mengapung di atas Scaffold | `Box` di dalam `Scaffold`, form berada di layer atas |
| Tanpa hardcode | Semua teks pakai `stringResource`, warna pakai `colorResource`, ukuran pakai `dimensionResource` |
| Jetpack Compose | Seluruh UI ditulis dengan Composable |

## Struktur File

- `app/src/main/java/com/example/pertemuan5/`
  - `MainActivity.kt`
  - `Act 4.kt` (berisi `FormBiodataScreen` dan `FormBiodata`)
- `app/src/main/res/`
  - `drawable/bg_spider.png`
  - `values/strings.xml`
  - `values/colors.xml`
  - `values/dimens.xml`

## Cara Menjalankan

1. Clone repository ini.
2. Buka di Android Studio.
3. Tunggu proses Gradle sync selesai.
4. Pilih emulator atau perangkat, lalu klik **Run**.

## Teknologi

- Kotlin
- Jetpack Compose
- Material 3

## Riwayat Commit

Project ini dikerjakan dengan minimal 25 commit. Riwayat lengkap bisa dilihat di tab **Commits** pada repository ini.
