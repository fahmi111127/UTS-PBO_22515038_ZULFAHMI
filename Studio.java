public class Studio {
    private String idStudio;
    private String namaStudio;
    private int kapasitas;
    private double hargaTiket;

    public Studio() {}

    public Studio(String idStudio, String namaStudio, int kapasitas, double hargaTiket) {
        this.idStudio = idStudio;
        this.namaStudio = namaStudio;
        setKapasitas(kapasitas);
        setHargaTiket(hargaTiket);
    }

    public String getIdStudio() { return idStudio; }
    public void setIdStudio(String idStudio) { this.idStudio = idStudio; }

    public String getNamaStudio() { return namaStudio; }
    public void setNamaStudio(String namaStudio) { this.namaStudio = namaStudio; }

    public int getKapasitas() { return kapasitas; }
    public void setKapasitas(int kapasitas) {
        if (kapasitas > 0) {
            this.kapasitas = kapasitas;
        } else {
            System.out.println("Error: Kapasitas studio harus lebih dari 0!");
        }
    }

    public double getHargaTiket() { return hargaTiket; }
    public void setHargaTiket(double hargaTiket) {
        if (hargaTiket > 0) {
            this.hargaTiket = hargaTiket;
        } else {
            System.out.println("Error: Harga tiket harus lebih dari 0!");
        }
    }

    public void tampilkanInfoStudio() {
        System.out.println("Studio ID: " + idStudio + " | Nama: " + namaStudio + " | Kapasitas: " + kapasitas + " kursi | Harga: Rp " + hargaTiket);
    }
}