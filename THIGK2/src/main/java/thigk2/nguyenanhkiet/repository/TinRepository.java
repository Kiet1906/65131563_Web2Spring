package thigk2.nguyenanhkiet.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import thigk2.nguyenanhkiet.entity.Tin;
import java.util.List;

public interface TinRepository extends JpaRepository<Tin, Integer> {
    // Hàm này hỗ trợ lấy danh sách tin theo mã thể loại
    List<Tin> findByTheLoaiId(Integer idTheLoai); 
}