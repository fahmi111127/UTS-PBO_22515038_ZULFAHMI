import java.util.ArrayList;

public class Bioskop {
    private String namaBioskop;
    private ArrayList<Film> daftarFilm;
    private ArrayList<Studio> daftarStudio;
    private ArrayList<Tiket> daftarTiket;
    private StackRiwayat riwayatAktivitas;

    public Bioskop(String namaBioskop, int kapasitasStack) {
        this.namaBioskop = namaBioskop;
        this.daftarFilm = new ArrayList<>();
        this.daftarStudio = new ArrayList<>();
        this.daftarTiket = new ArrayList<>();
        this.riwayatAktivitas = new StackRiwayat(kapasitasStack);
    }

    public void tambahFilm(Film film) {
        daftarFilm.add(film);
        riwayatAktivitas.push("Tambah Film: " + film.getJudul());
    }

    public void tambahStudio(Studio studio) {
        daftarStudio.add(studio);
        riwayatAktivitas.push("Tambah Studio: " + studio.getNamaStudio());
    }

    public int hitungTiketAktif() {
        int aktif = 0;
        for (Tiket t : daftarTiket) {
            if (t.isStatusAktif()) aktif++;
        }
        return aktif;
    }

    public boolean pesanTiket(String idTiket, String namaPemesan, String nomorKursi, Studio studioTujuan) {
        if (studioTujuan == null) {
            System.out.println("Error: Studio tidak ditemukan!");
            return false;
        }
        if (hitungTiketAktif() >= studioTujuan.getKapasitas()) {
            System.out.println("Aturan Bisnis Gagal: Kapasitas studio sudah penuh (" + studioTujuan.getKapasitas() + " kursi)!");
            return false;
        }
        for (Tiket t : daftarTiket) {
            if (t.getNomorKursi().equalsIgnoreCase(nomorKursi) && t.isStatusAktif()) {
                System.out.println("Aturan Bisnis Gagal: Kursi " + nomorKursi + " sudah dipesan!");
                return false;
            }
        }

        Tiket tiketBaru = new Tiket(idTiket, namaPemesan, nomorKursi);
        daftarTiket.add(tiketBaru);
        riwayatAktivitas.push("Pesan Tiket [" + idTiket + "] Kursi " + nomorKursi + " a.n. " + namaPemesan);
        System.out.println("Pemesanan tiket berhasil!");
        return true;
    }

    public void batalkanTransaksiTerakhir() {
        if (!daftarTiket.isEmpty() && !riwayatAktivitas.isEmpty()) {
            Tiket tiketTerakhir = daftarTiket.get(daftarTiket.size() - 1);
            tiketTerakhir.batalkanTiket();
            daftarTiket.remove(tiketTerakhir);
            String logBatal = riwayatAktivitas.pop();
            System.out.println("Berhasil membatalkan aktivitas terakhir dari Stack: " + logBatal);
        } else {
            System.out.println("Tidak ada transaksi tiket yang bisa dibatalkan.");
        }
    }

    public void cariData(String kataKunci) {
        boolean ditemukan = false;
        System.out.println("--- Hasil Pencarian untuk '" + kataKunci + "' ---");
        for (Film f : daftarFilm) {
            if (f.getIdFilm().equalsIgnoreCase(kataKunci) || f.getJudul().toLowerCase().contains(kataKunci.toLowerCase())) {
                f.tampilkanInfoFilm();
                ditemukan = true;
            }
        }
        for (Tiket t : daftarTiket) {
            if (t.getIdTiket().equalsIgnoreCase(kataKunci) || t.getNomorKursi().equalsIgnoreCase(kataKunci)) {
                t.tampilkanInfoTiket();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Data tidak ditemukan.");
        }
    }

    public void tampilkanRingkasan() {
        double totalPendapatan = 0;
        double hargaDefault = daftarStudio.isEmpty() ? 0 : daftarStudio.get(0).getHargaTiket();
        totalPendapatan = hitungTiketAktif() * hargaDefault;

        System.out.println("\n=== RINGKASAN LAPORAN " + namaBioskop.toUpperCase() + " ===");
        System.out.println("Total Film Terdaftar   : " + daftarFilm.size());
        System.out.println("Total Studio Terdaftar : " + daftarStudio.size());
        System.out.println("Total Tiket Aktif      : " + hitungTiketAktif());
        System.out.println("Estimasi Pendapatan    : Rp " + totalPendapatan);
        System.out.println("Jumlah Riwayat (Stack) : " + riwayatAktivitas.size());
    }

    public ArrayList<Studio> getDaftarStudio() {
        return daftarStudio;
    }

    public void tampilkanSemuaFilm() {
        if (daftarFilm.isEmpty()) System.out.println("Belum ada data film.");
        for (Film f : daftarFilm) f.tampilkanInfoFilm();
    }

    public void tampilkanSemuaStudio() {
        if (daftarStudio.isEmpty()) System.out.println("Belum ada data studio.");
        for (Studio s : daftarStudio) s.tampilkanInfoStudio();
    }

    public StackRiwayat getRiwayatAktivitas() {
        return riwayatAktivitas;
    }
}