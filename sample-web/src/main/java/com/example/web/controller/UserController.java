package com.example.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.web.entity.User;
import com.example.web.service.UserService;

/**
 * ユーザー Controller
 */
@Controller
public class UserController {

	/**ユーザー情報 Service */
	@Autowired
	private UserService userService;

	/**
	 * ユーザー情報一覧画面を表示
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@GetMapping(value = "/user/list")
	public String displayList(Model model) {
		List<User> userlist = userService.searchAll();
		model.addAttribute("userlist", userlist);
		model.addAttribute("screenName", "ユーザー情報: 一覧");
		return "user/list";
	}

	/**
	 * ユーザー新規登録画面を表示
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@GetMapping(value = "/user/add")
	public String displayAdd(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("type", "add");
		model.addAttribute("screenName", "ユーザー情報： 登録画面");
		return "user/entry";
	}
	
	/**
	 * ユーザー情報を登録する
	 * @param id ユーザーID
	 * @param model Model
	 * @return ユーザー情報の編集画面
	 */
	@PostMapping("/user/add")
	public String entryUser(@Validated @ModelAttribute User requestUser, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("user", requestUser);
			model.addAttribute("type", "add");
			model.addAttribute("screenName", "ユーザー情報： 登録画面");
			return "user/entry";
		}

		// ユーザー情報の登録
		userService.createUser(requestUser);

		return "redirect:/user/list";
	}

	/**
	 * ユーザー情報詳細画面を表示
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
	@GetMapping("/user/{id}")
	public String displayDetail(@PathVariable Long id, Model model) {
		User user = userService.getUser(id);
		model.addAttribute("user", user);
		model.addAttribute("screenName", "ユーザー情報： 詳細画面");
		return "user/detail";
	}

	/**
	 * ユーザー情報の編集画面を表示
	 * @param id ユーザーID
	 * @param model Model
	 * @return ユーザー情報の編集画面
	 */
	@GetMapping("/user/{id}/edit")
	public String displayEdit(@PathVariable Long id, Model model) {
		User user = userService.getUser(id);
		model.addAttribute("user", user);
		model.addAttribute("type", "edit");
		model.addAttribute("screenName", "ユーザー情報: 変更画面");
		return "user/entry";
	}

	/**
	 * ユーザー情報を変更する
	 * @param id ユーザーID
	 * @param model Model
	 * @return ユーザー情報の編集画面
	 */
	@PostMapping("/user/edit")
	public String editUser(@Valid @ModelAttribute User requestUser, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("user", requestUser);
			model.addAttribute("type", "edit");
			model.addAttribute("screenName", "ユーザー情報: 変更画面");
			return "user/entry";
		}

		// ユーザー情報の更新
		userService.updateUser(requestUser);

		return "redirect:/user/list";
	}

	/**
	 * ユーザー情報を削除する
	 * @param id ユーザーID
	 * @param model Model
	 * @return ユーザー情報の編集画面
	 */
	@GetMapping("/user/{id}/delete")
	public String deleteUser(@PathVariable Long id) {
		// ユーザー情報の削除
		userService.deleteUser(id);
		return "redirect:/user/list";
	}
}
