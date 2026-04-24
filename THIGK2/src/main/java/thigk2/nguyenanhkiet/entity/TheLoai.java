package thigk2.nguyenanhkiet.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenTheLoai;

    @JsonIgnore
    @OneToMany(mappedBy = "theLoai")
    private List<Tin> dsTin;
}