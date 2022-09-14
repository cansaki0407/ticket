package com.example.demo.controller;

import com.example.demo.bean.UserRegisterBean;
import com.example.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/8/16- 23:00
 */
@CrossOrigin
@RestController
@RequestMapping("/travel")
public class RegisterController {

	@Autowired
	RegisterService registerService;

	@GetMapping("/aaa")
	public String aaa(){
		return "皮皮";
	}

	//注册用户
	@PostMapping ("/register")
	public Object registUser(@RequestBody UserRegisterBean registinfo) throws Exception{
		registerService.register(registinfo);
		return "添加成功";
	}

	//注册时获取手机验证码
	//http://localhost:8080/travel/phonecode46546465
	//http://localhost:8080/travel/phonecode/
	@GetMapping("phonecode/{phone}")
	public String getPhoneCode(@PathVariable("phone") String phoneNumber) throws Exception{
		return  registerService.getPhoneCode(phoneNumber);
	}
}
