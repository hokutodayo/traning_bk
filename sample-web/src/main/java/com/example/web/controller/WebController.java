package com.example.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Web Controller
 */
@Controller
public class WebController {

	/** ログ出力 */
	Logger logger = LoggerFactory.getLogger(WebController.class);

	/**
	 * Index画面を表示
	 * @param model Model
	 * @return Index画面
	 */
	@GetMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("message", "ようこそ");
		return "index";
	}
}
