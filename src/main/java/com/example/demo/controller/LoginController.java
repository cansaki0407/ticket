package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/8/29- 9:28
 */
@RestController
@RequestMapping("/travel")
public class LoginController {


}

@GetMapping("/kaptcha")
@ApiOperation("登录获取验证码")
public Map<String,String>
