package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/8/17- 1:02
 * user_info 实体类
 */
@Data
public class UserBean {
	private String username;
	private String password;
//	@JsonProperty("mPhone")
	private String phone;
	private String email;
}
