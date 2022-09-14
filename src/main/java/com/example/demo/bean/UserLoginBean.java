package com.example.demo.bean;

import lombok.Data;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/9/11- 14:20
 */
@Data
public class UserLoginBean{
	private String username;
	private String password;
	private String userCode;
	//Redis中的验证码的key,用来获取redis中验证码的值同用户输入的userCode进行比较
	private String redisCodeKey;
}

