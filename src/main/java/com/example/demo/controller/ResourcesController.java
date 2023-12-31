package com.example.demo.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/9/16- 14:35
 */
@CrossOrigin
@RestController
@RequestMapping("/resources")
public class ResourcesController {
	@GetMapping(value = "/picture/**",produces = { MediaType.IMAGE_JPEG_VALUE })
	public byte[] getPicture(HttpServletRequest request) throws IOException {
		//String imagePath =new String(request.getRequestURI().substring(18).getBytes("ISO-8859-1"),"utf-8");

		String imagePath = request.getRequestURI().substring(18);
//		String property = System.getProperty("user.dir");
//		String path = property+"/src/main/resources";


//		File file = new File(path+imagePath);
//		FileInputStream inputStream = null;
		ClassPathResource resource = null;
		InputStream inputStream = null;
		byte[] bytes = null;
		try {
			resource = new ClassPathResource(imagePath);
			inputStream = resource.getInputStream();
//			inputStream = new FileInputStream(file);
			bytes = new byte[inputStream.available()];
			inputStream.read(bytes, 0, inputStream.available());
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
		return bytes;
	}

}
