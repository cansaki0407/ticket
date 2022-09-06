package com.example.demo.controller;

import com.example.demo.bean.UserBean;
import com.example.demo.service.UserLIstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/8/27- 18:33
 */
@RestController
@RequestMapping("travel")
public class UserListController {

	@Autowired
	UserLIstService userLIstService;
	//获取全部用户列表
	@GetMapping("/userList")
	public List<UserBean> showUsers(){
		return userLIstService.getUserList();
	}
}
