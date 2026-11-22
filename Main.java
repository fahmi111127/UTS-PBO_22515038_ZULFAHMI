import java.util.Scanner;

/**
 * Class utama untuk menjalankan antarmuka menu konsol sistem Bioskop.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bioskop bioskop = new Bioskop("Cinema Kendari", 10); // Kapasitas Stack = 10

        // Data awal (seed data) agar program siap diuji
        bioskop.tambahFilm(new Film("F01", "Interstellar", "Sci-Fi", 169));
        bioskop.tambahStudio(new Studio("S01", "Studio Reguler 1", 3, 45000));

        int pilihan = 0;
        do {
            System.out.println("\n==========================================");
            System.out.println("   SISTEM MANAJEMEN BIOSKOP (NIM: 22515038)");
            System.out.println("==========================================");
            System.out.println("1. Tambah & Tampilkan Data Film");
            System.out.println("2. Tambah & Tampilkan Data Studio");
            System.out.println("3. Buat Transaksi Pemesanan Tiket");
            System.out.println("4. Cari Data (Film / Tiket / Kursi)");
            System.out.println("5. Operasi ADT Stack (Lihat Riwayat / Undo Transaksi)");
            System.out.println("6. Tampilkan Ringkasan Laporan");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu (1-7): ");

            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Harap masukkan angka 1 sampai 7.");
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan ID Film: ");
                    String idFilm = scanner.nextLine();
                    System.out.print("Masukkan Judul Film: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Masukkan Durasi (menit): ");
                    try {
                        int durasi = Integer.parseInt(scanner.nextLine());
                        if (durasi <= 0) {
                            System.out.println("Durasi harus lebih dari 0!");
                        } else {
                            bioskop.tambahFilm(new Film(idFilm, judul, genre, durasi));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Input durasi harus berupa angka!");
                    }
                    System.out.println("\n--- Daftar Film Saat Ini ---");
                    bioskop.tampilkanSemuaFilm();
                    break;

                case 2:
                    System.out.print("Masukkan ID Studio: ");
                    String idStudio = scanner.nextLine();
                    System.out.print("Masukkan Nama Studio: ");
                    String namaStudio = scanner.nextLine();
                    try {
                        System.out.print("Masukkan Kapasitas Kursi: ");
                        int kapasitas = Integer.parseInt(scanner.nextLine());
                        System.out.print("Masukkan Harga Tiket: ");
                        double harga = Double.parseDouble(scanner.nextLine());
                        if (kapasitas <= 0 || harga <= 0) {
                            System.out.println("Kapasitas dan harga harus lebih dari 0!");
                        } else {
                            bioskop.tambahStudio(new Studio(idStudio, namaStudio, kapasitas, harga));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Input kapasitas/harga harus berupa angka!");
                    }
                    System.out.println("\n--- Daftar Studio Saat Ini ---");
                    bioskop.tampilkanSemuaStudio();
                    break;

                case 3:
                    if (bioskop.getDaftarStudio().isEmpty()) {
                        System.out.println("Tambahkan studio terlebih dahulu sebelum memesan tiket.");
                        break;
                    }
                    System.out.print("Masukkan ID Tiket: ");
                    String idTiket = scanner.nextLine();
                    System.out.print("Masukkan Nama Pemesan: ");
                    String pemesan = scanner.nextLine();
                    System.out.print("Masukkan Nomor Kursi (misal A1): ");
                    String kursi = scanner.nextLine();
                    if (idTiket.isEmpty() || pemesan.isEmpty() || kursi.isEmpty()) {
                        System.out.println("Data pemesanan tidak boleh kosong!");
                    } else {
                        bioskop.pesanTiket(idTiket, pemesan, kursi, bioskop.getDaftarStudio().get(0));
                    }
                    break;

                case 4:
                    System.out.print("Masukkan kata kunci pencarian (ID/Judul/Kursi): ");
                    String keyword = scanner.nextLine();
                    bioskop.cariData(keyword);
                    break;

                case 5:
                    System.out.println("1. Tampilkan Isi Stack Riwayat");
                    System.out.println("2. Batalkan Transaksi Tiket Terakhir (Pop)");
                    System.out.print("Pilih sub-menu: ");
                    String sub = scanner.nextLine();
                    if (sub.equals("1")) {
                        bioskop.getRiwayatAktivitas().tampilkanStack();
                    } else if (sub.equals("2")) {
                        bioskop.batalkanTransaksiTerakhir();
                    } else {
                        System.out.println("Pilihan sub-menu tidak valid.");
                    }
                    break;

                case 6:
                    bioskop.tampilkanRingkasan();
                    break;

                case 7:
                    System.out.println("Terima kasih telah menggunakan sistem manajemen Bioskop.");
                    break;

                default:
                    System.out.println("Pilihan menu tidak tersedia (1-7).");
            }
        } while (pilihan != 7);

        scanner.close();
    }
}