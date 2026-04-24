package thigk2.nguyenanhkiet.entity;

import jakarta.persistence.*;

@Entity
public class Tin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tieuDe;
    private String noiDung;

    @ManyToOne
    @JoinColumn(name = "id_the_loai")
    private TheLoai theLoai;

    // Constructors
    public Tin() {}

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTieuDe() { return tieuDe; }
    public void setTieuDe(String tieuDe) { this.tieuDe = tieuDe; }
    public String getNoiDung() { return noiDung; }
    public void setNoiDung(String noiDung) { this.noiDung = noiDung; }
    public TheLoai getTheLoai() { return theLoai; }
    public void setTheLoai(TheLoai theLoai) { this.theLoai = theLoai; }
}