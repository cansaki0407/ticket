package com.example.demo.mappers;

import com.example.demo.bean.UserRegisterBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/8/17- 1:21
 */
@Mapper
public interface RegisterMapper {
	public void registerUser(@Param("registerinfo") UserRegisterBean registinfo);
}
