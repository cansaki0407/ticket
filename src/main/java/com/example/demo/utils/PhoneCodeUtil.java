package com.example.demo.utils;

import java.util.Random;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/9/6- 14:48
 */
public class PhoneCodeUtil {
	public static void main(String[] args) {
		createPhoneCode();
	}

	public static String createPhoneCode(){
		Random random = new Random();
		String code = "";
		for (int i = 0; i < 6; i++){
			code = code + random.nextInt(10);
		}
  		return code;
	}
}
