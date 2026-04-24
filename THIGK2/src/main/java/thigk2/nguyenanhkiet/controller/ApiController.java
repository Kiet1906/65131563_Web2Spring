package thigk2.nguyenanhkiet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thigk2.nguyenanhkiet.entity.TheLoai;
import thigk2.nguyenanhkiet.entity.Tin;
import thigk2.nguyenanhkiet.repository.TheLoaiRepository;
import thigk2.nguyenanhkiet.repository.TinRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private TheLoaiRepository theLoaiRepository;

    @Autowired
    private TinRepository tinRepository;

    // 1. API Lấy danh sách thể loại
    @GetMapping("/the-loai")
    public List<TheLoai> getDanhSachTheLoai() {
        return theLoaiRepository.findAll();
    }

    // 2. API Lấy danh sách tin theo mã thể loại
    @GetMapping("/tin-theo-the-loai/{id}")
    public List<Tin> getTinTheoTheLoai(@PathVariable Integer id) {
        return tinRepository.findByTheLoaiId(id);
    }
    
    // API Lấy tất cả tin (Thêm cho chắc ăn)
    @GetMapping("/tin")
    public List<Tin> getTatCaTin() {
        return tinRepository.findAll();
    }
}