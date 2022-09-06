package com.example.demo.service;

import com.example.demo.bean.UserRegisterBean;
import com.example.demo.mappers.RegisterMapper;
import com.example.demo.redis.CodeRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/8/17- 1:23
 */
@Service
public class RegisterService {

	@Autowired
	RegisterMapper registerMapper;



	@Autowired
	CodeRedis codeRedis;

	//注册用户，先通过CodeRedis.verifyCode方法判断验证码是否正确且有效
	public void register(UserRegisterBean registinfo) throws Exception{
		codeRedis.VerifyCode(registinfo.getPhone(),registinfo.getCode());
		registerMapper.registerUser(registinfo);
	}



	public String getPhoneCode(String phoneNumber) throws Exception{
		return codeRedis.registerGetCode(phoneNumber);
//		//通过手机验证码工具类获取验证码
//		String phoneCode = phoneCodeUtil.getPhoneCode();
//		//设置值到redis
//		redisTemplate.opsForValue().set("phoneCode",phoneCode);
//		//从redis获取值
//		phoneCode = (String)redisTemplate.opsForValue().get("phoneCode");
//		return phoneCode;
	}
}
