package thigk2.nguyenanhkiet.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import thigk2.nguyenanhkiet.entity.NguoiDung;

public interface NguoiDungRepository extends JpaRepository<NguoiDung, String> {
}