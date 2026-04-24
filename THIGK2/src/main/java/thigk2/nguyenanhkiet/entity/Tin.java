package thigk2.nguyenanhkiet.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Tin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tieuDe;
    private String noiDung;

    @ManyToOne
    @JoinColumn(name = "id_the_loai")
    private TheLoai theLoai;
}