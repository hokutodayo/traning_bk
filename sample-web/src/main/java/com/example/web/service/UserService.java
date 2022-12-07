package com.example.web.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web.entity.User;
import com.example.web.repository.UserRepository;

/**
 * ユーザー情報 Service
 */
@Service
public class UserService {
	/**
	 * ユーザー情報 Repository
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * ユーザー情報を全件取得する
	 * @return 全ユーザー情報のリスト
	 */
	public List<User> searchAll() {
		return userRepository.findAll();
	}

	/**
	 * ユーザー情報を取得する
	 * @param id 取得対象のユーザーID
	 * @return IDに紐づくユーザー情報
	 */
	public User getUser(long id) {
		return userRepository.findById(id).get();
	}
	
	/**
	 * 新規ユーザー作成
	 * @param requestUser 新規ユーザー情報
	 * @return 作成済みユーザー
	 */
	public User createUser(User requestUser) {
		// 日時をセット
		requestUser.setCreateDate(new Date());
		requestUser.setUpdateDate(new Date());
		
		return userRepository.save(requestUser);
	}
	
	/**
	 * ユーザー更新
	 * @param user 変更ユーザー情報
	 * @return 更新済みユーザー
	 */
	public User updateUser(User requestUser) {
		// 更新前のユーザー情報を取得する
		User user = userRepository.findById(requestUser.getId()).get();

		// 変更内容を反映する
		user.setName(requestUser.getName());
		user.setAddress(requestUser.getAddress());
		user.setPhone(requestUser.getPhone());
		// 更新日時をセット
		user.setUpdateDate(new Date());
		
		return userRepository.save(user);
	}

	/**
	 * ユーザー削除
	 * @param id 削除対象のユーザーID
	 */
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}
	
}
