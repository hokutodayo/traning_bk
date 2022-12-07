package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Web Controller
 */
@Controller
public class WebController {

	/**
	 * Index画面を表示
	 * @param model Model
	 * @return Index画面
	 */
	@GetMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("screenName", "Index");
		model.addAttribute("message", "ようこそ");
		return "index";
	}
}
