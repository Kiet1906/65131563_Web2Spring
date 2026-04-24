package thigk2.nguyenanhkiet.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class NguoiDung {
    @Id
    private String username;
    private String password;
    private String hoTen;
}