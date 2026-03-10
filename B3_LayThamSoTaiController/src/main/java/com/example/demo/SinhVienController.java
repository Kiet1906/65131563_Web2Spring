package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class SinhVienController {

    @GetMapping("/")
    public String formSinhVien() {
        return "form";
    }

    @GetMapping("/hienthi")
    public String hienThi(
            @RequestParam("mssv") String mssv,
            @RequestParam("hoten") String hoten,
            @RequestParam("namsinh") String namsinh,
            @RequestParam("gioitinh") String gioitinh,
            Model model) {

        model.addAttribute("mssv", mssv);
        model.addAttribute("hoten", hoten);
        model.addAttribute("namsinh", namsinh);
        model.addAttribute("gioitinh", gioitinh);

        return "ketqua";
    }
}