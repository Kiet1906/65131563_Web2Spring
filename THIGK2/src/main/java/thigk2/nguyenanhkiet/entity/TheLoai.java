package thigk2.nguyenanhkiet.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenTheLoai;

    @OneToMany(mappedBy = "theLoai")
    private List<Tin> dsTin;
}