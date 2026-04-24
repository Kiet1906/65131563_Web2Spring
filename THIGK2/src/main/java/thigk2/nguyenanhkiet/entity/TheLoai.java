package thigk2.nguyenanhkiet.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenTheLoai;

    @JsonIgnore
    @OneToMany(mappedBy = "theLoai")
    private List<Tin> dsTin;

    // Constructors
    public TheLoai() {}

    // Getters and Setters (Bắt buộc phải có để hiện JSON)
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTenTheLoai() { return tenTheLoai; }
    public void setTenTheLoai(String tenTheLoai) { this.tenTheLoai = tenTheLoai; }
    public List<Tin> getDsTin() { return dsTin; }
    public void setDsTin(List<Tin> dsTin) { this.dsTin = dsTin; }
}