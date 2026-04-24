package thigk2.nguyenanhkiet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import thigk2.nguyenanhkiet.repository.TheLoaiRepository;
import thigk2.nguyenanhkiet.repository.TinRepository;

@Controller
public class WebController {

    @Autowired
    private TinRepository tinRepository;

    @Autowired
    private TheLoaiRepository theLoaiRepository;

    // 1. Hiển thị danh sách tất cả các Tin
    @GetMapping("/tin-tuc")
    public String danhSachTin(Model model) {
        model.addAttribute("dsTin", tinRepository.findAll());
        model.addAttribute("dsTheLoai", theLoaiRepository.findAll()); // Truyền thêm thể loại để làm Menu
        return "danh-sach"; 
    }

    // 2. Hiển thị danh sách Tin theo thể loại
    @GetMapping("/the-loai/{id}")
    public String tinTheoTheLoai(@PathVariable Integer id, Model model) {
        model.addAttribute("dsTin", tinRepository.findByTheLoaiId(id));
        model.addAttribute("dsTheLoai", theLoaiRepository.findAll());
        return "danh-sach"; // Tái sử dụng lại file HTML danh-sach
    }

    // 3. Xem chi tiết tin
    @GetMapping("/chi-tiet/{id}")
    public String chiTietTin(@PathVariable Integer id, Model model) {
        model.addAttribute("tin", tinRepository.findById(id).orElse(null));
        return "chi-tiet";
    }
}