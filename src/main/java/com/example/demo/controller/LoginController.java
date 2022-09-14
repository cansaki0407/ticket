package com.example.demo.controller;

import cn.hutool.core.util.RandomUtil;
import com.example.demo.bean.UserLoginBean;
import com.example.demo.service.LoginService;
import com.example.demo.utils.MD5Util;
import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.ChineseGifCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/8/29- 9:28
 */
@CrossOrigin
@RestController
@RequestMapping("/travel")
public class LoginController {

	@Autowired
	LoginService loginService;

	//获取图片验证码
	//return :  resultMap(key,Base64图片)
	@GetMapping("/captcha")
	public Map<String,String> captcha(HttpServletRequest request,HttpServletResponse response){
		return loginService.getCaptcha(request,response);
	}

	//用户登录
	//localhost:8080/travel/userlogin
	@PostMapping("/userLogin")
	public Integer userLogin(@RequestBody UserLoginBean userLoginBean) throws Exception{
		return loginService.userLogin(userLoginBean);
	}

}


