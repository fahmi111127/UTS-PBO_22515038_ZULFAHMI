public class Tiket {
    private String idTiket;
    private String namaPemesan;
    private String nomorKursi;
    private boolean statusAktif;

    public Tiket() {}

    public Tiket(String idTiket, String namaPemesan, String nomorKursi) {
        this.idTiket = idTiket;
        this.namaPemesan = namaPemesan;
        this.nomorKursi = nomorKursi;
        this.statusAktif = true;
    }

    public String getIdTiket() { return idTiket; }
    public void setIdTiket(String idTiket) { this.idTiket = idTiket; }

    public String getNamaPemesan() { return namaPemesan; }
    public void setNamaPemesan(String namaPemesan) { this.namaPemesan = namaPemesan; }

    public String getNomorKursi() { return nomorKursi; }
    public void setNomorKursi(String nomorKursi) { this.nomorKursi = nomorKursi; }

    public boolean isStatusAktif() { return statusAktif; }
    public void setStatusAktif(boolean statusAktif) { this.statusAktif = statusAktif; }

    public void batalkanTiket() {
        if (this.statusAktif) {
            this.statusAktif = false;
            System.out.println("Tiket dengan nomor kursi " + nomorKursi + " berhasil dibatalkan.");
        } else {
            System.out.println("Tiket ini sudah berstatus non-aktif/batal.");
        }
    }

    public void tampilkanInfoTiket() {
        String status = statusAktif ? "Aktif" : "Dibatalkan";
        System.out.println("ID Tiket: " + idTiket + " | Pemesan: " + namaPemesan + " | Kursi: " + nomorKursi + " | Status: " + status);
    }
}