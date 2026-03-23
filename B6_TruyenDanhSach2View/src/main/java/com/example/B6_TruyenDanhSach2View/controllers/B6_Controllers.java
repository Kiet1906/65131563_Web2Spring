package com.example.B6_TruyenDanhSach2View.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.ModelMap;

@Controller
public class B6_Controllers {
	@GetMapping ("/")
	public String listCars (ModelMap m) {
		List<Car> cars = Arrays.asList(
				new Car ("001", "VF3", 2000.0),
				new Car ("002", "VF5", 3000.0),
				new Car ("003", "VF7", 5000.0)
		);
		m.addAttribute("cars", cars);
		return "car-list";
	}
}
