package com.example.demo.redis;

import com.example.demo.utils.PhoneCodeUtil;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/8/27- 23:41
 */
@Component
public class CodeRedis {
	@Autowired
	RedisTemplate<String,Object> redisTemplate;


	/**
	 * 获取用户注册时的手机验证码手机验证码
	 * （同一手机号24小时内最多获取三次验证码，设置验证码的过期时间为60s，验证码存入redis，且发送给前端路由）
	 * */
	public String registerGetCode(String phone) throws Exception{
		//拼接手机号发送次数的Key
		String codeCountKey = "VerifyCode"+phone+":count";

		//每个手机每天只能接收三次验证码
		//设置每个手机号只能收到三次验证码，验证码放入redis中,
		Integer count = (Integer) redisTemplate.opsForValue().get(codeCountKey);

		if(count==null){
			redisTemplate.opsForValue().set(codeCountKey,1,1, TimeUnit.DAYS);
		}
		else if(count <= 2){
			redisTemplate.opsForValue().increment(codeCountKey);
		}else{
			throw new Exception("验证码接收已达上限,24小时之后重试");
		}
		String code = PhoneCodeUtil.createPhoneCode();
		//拼接手机验证码的key
		String phoneCodeKey = "VerifyCode"+phone+":code";
		//设置过期时间为1minutes
		redisTemplate.opsForValue().set(phoneCodeKey,code,1,TimeUnit.MINUTES);
		System.out.println(codeCountKey);
		return code;
	}

	//校验注册时填写的验证码是否正确,是否过期
	public void VerifyCode(String phone,String Code) throws Exception{
		String phoneCodeKey = "VerifyCode"+phone+":code";
		String redisCode = (String) redisTemplate.opsForValue().get(phoneCodeKey);
		if(redisCode==null){
			System.out.println("验证码已经过期或者不存在,请重新获取");
			throw new Exception("验证码已经过期者不存在,请重新获取");
		}else if(!redisCode.equals(Code)){
			System.out.println("验证码输入错误请重新输入");
			throw new Exception("验证码输入错误,请重新输入");
		}
	}


}
