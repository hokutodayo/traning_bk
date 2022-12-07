package com.example.web.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * ユーザー情報 Entity
 */
@Entity
@Data
@Table(name = "user")
public class User implements Serializable {

	/**
	 * ID
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 名前
	 */
	@NotBlank(message="名前を入力してください")
	@Size(max=50, message="名前は50文字以内で入力してください")
	@Column(name = "name")
	private String name;

	/**
	 * 住所
	 */
	@Size(max=100, message="住所は100文字以内で入力してください")
	@Column(name = "address")
	private String address;

	/**
	 * 電話番号
	 */
	@Pattern(regexp="|\\d{1,4}-\\d{1,4}-\\d{4}", message="電話番号の形式（xxxx-xxxx-xxxx）で入力してください")
	@Column(name = "phone")
	private String phone;

	/**
	 * 更新日時
	 */
	@Column(name = "update_date")
	private Date updateDate;

	/**
	 * 登録日時
	 */
	@Column(name = "create_date")
	private Date createDate;

	/**
	 * 削除日時
	 */
	@Column(name = "delete_date")
	private Date deleteDate;
}