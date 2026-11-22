public class Film {
    private String idFilm;
    private String judul;
    private String genre;
    private int durasiMenit;

    public Film() {}

    public Film(String idFilm, String judul, String genre, int durasiMenit) {
        this.idFilm = idFilm;
        this.judul = judul;
        this.genre = genre;
        setDurasiMenit(durasiMenit);
    }

    public String getIdFilm() { return idFilm; }
    public void setIdFilm(String idFilm) { this.idFilm = idFilm; }

    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getDurasiMenit() { return durasiMenit; }
    public void setDurasiMenit(int durasiMenit) {
        if (durasiMenit > 0) {
            this.durasiMenit = durasiMenit;
        } else {
            System.out.println("Error: Durasi film harus lebih dari 0!");
        }
    }

    public void tampilkanInfoFilm() {
        System.out.println("ID: " + idFilm + " | Judul: " + judul + " | Genre: " + genre + " | Durasi: " + durasiMenit + " menit");
    }
}