package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String thongTinSinhVien(Model model) {

        model.addAttribute("mssv", "65131563");
        model.addAttribute("hoten", "Nguyen Anh Kiet");
        model.addAttribute("namsinh", "2005");
        model.addAttribute("gioitinh", "Nam");

        return "sinhvien";
    }
}