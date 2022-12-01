package com.example.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.web.entity.User;
import com.example.web.service.UserService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class UserController {

	/** ログ出力 */
	Logger logger = LoggerFactory.getLogger(UserController.class);

	/**ユーザー情報 Service */
	@Autowired
	private UserService userService;

	/**
	 * Index画面を表示
	 * @param model Model
	 * @return Index画面
	 */
	@GetMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("message", "hoge fuga");
		return "index";
	}

	/**
	 * ユーザー情報一覧画面を表示
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@GetMapping(value = "/user/list")
	public String displayList(Model model) {
		List<User> userlist = userService.searchAll();
		model.addAttribute("userlist", userlist);
		return "user/list";
	}

	/**
	 * ユーザー新規登録画面を表示
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@GetMapping(value = "/user/add")
	public String displayAdd(Model model) {
		return "user/add";
	}

	/**
	 * ユーザー情報詳細画面を表示
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
	@GetMapping("/user/{id}")
	public String displayView(@PathVariable Long id, Model model) {
		User user = userService.searchUser(id);
		model.addAttribute("user", user);
		return "user/view";
	}

	/**
	 * ユーザー情報詳細の編集画面を表示
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー情報詳細の編集画面
	 */
	@GetMapping("/user/{id}/edit")
	public String displayEdit(@PathVariable Long id, Model model) {
		User user = userService.searchUser(id);
		model.addAttribute("user", user);
		return "user/edit";
	}
}
