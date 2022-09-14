package com.example.demo.service;

import com.example.demo.bean.UserLoginBean;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/8/29- 9:31
 */
@Service
public interface LoginService {
	//图片验证码
	public Map<String,String> getCaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

	//登录信息
	public Integer userLogin(UserLoginBean userLoginBean) throws Exception;

}
