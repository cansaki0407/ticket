package com.example.demo.service;

import com.example.demo.bean.UserBean;
import com.example.demo.mappers.UserLIstMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/8/27- 18:29
 */
@Service
public class UserLIstService {
	@Autowired
	UserLIstMapper userLIstMapper;

	public List<UserBean> getUserList(){
		return userLIstMapper.getUserList();
	}
}
