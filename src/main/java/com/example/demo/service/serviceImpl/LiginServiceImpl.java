package com.example.demo.service.serviceImpl;

import com.example.demo.bean.UserLoginBean;
import com.example.demo.mappers.LoginMapper;
import com.example.demo.redis.CodeRedis;
import com.example.demo.service.LoginService;
import com.wf.captcha.ArithmeticCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/9/11- 15:14
 */
@Component
public class LiginServiceImpl implements LoginService {

	@Autowired
	LoginMapper loginMapper;

	@Autowired
	RedisTemplate redisTemplate;

	@Autowired
	CodeRedis codeRedis;

	//获取登录的图片验证码
	@Override
	public Map<String, String> getCaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Map<String,String> resultMap = new HashMap<>();
		//算术类型验证码
		ArithmeticCaptcha captcha = new ArithmeticCaptcha();
		//中文类型验证码
		//ChineseCaptcha captcha = new ChineseCaptcha();

		//英文与数字验证码
		//SpecCaptcha captcha = new SpecCaptcha();

		//中文动态验证码
		//ChineseGifCaptcha captcha = new ChineseGifCaptcha();

		//N位运算,默认两位,其他类型验证码时设置长度
		captcha.setLen(2);
		//获取计算的结果,进行储存
		String result = captcha.text();
		String key = UUID.randomUUID().toString();
		//对生成的key值进行MD5加密,MD5工具类应用,可自行处理
		//String realKey = MD5Util.MD5Encode(key,"utf-8");
		//log.info("获取验证码,Redis result = {}, key ={}",result,key);
		//此处为redis工具类封装,设置key,value,key有效期
		//redisUtil.set(key,result,60);
		redisTemplate.opsForValue().set(key,result,60, TimeUnit.SECONDS);
		//返回前端
		resultMap.put("verifyCodeKey",key);
		resultMap.put("verifyCode",captcha.toBase64());
		return resultMap;
	}

	//提交的登陆信息
	@Override
	public Integer userLogin(UserLoginBean userLoginBean) throws Exception{
		codeRedis.verifyLoginCode(userLoginBean.getRedisCodeKey(), userLoginBean.getUserCode());
		if(loginMapper.userLogin(userLoginBean) == 1){
			System.out.println("登录成功");
		}else{
			System.out.println("用户名或密码错误登录失败");
			throw new Exception("用户名或密码错误登录失败");
		} ;
		return loginMapper.userLogin(userLoginBean);
//		return loginMapper.userLogin(userLoginBean);
	}
}
