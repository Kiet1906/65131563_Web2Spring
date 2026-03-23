package com.example.B5_TruyenDoiTuong2View.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class B5_Controllers {
	@GetMapping("/car")
	public String showCar(ModelMap m) {
		Car car = new Car ("001", "VF3", 2000.0);
		m.addAttribute("car", car);
		return "car-detail";
	}
}
