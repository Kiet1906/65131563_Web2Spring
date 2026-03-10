package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BMIController {

    @GetMapping("/")
    public String formBMI() {
        return "bmi_form";
    }

    @GetMapping("/tinhbmi")
    public String tinhBMI(
            @RequestParam("chieucao") double chieucao,
            @RequestParam("cannang") double cannang,
            Model model) {

        double bmi = cannang / (chieucao * chieucao);

        model.addAttribute("bmi", bmi);

        return "ketqua";
    }
}