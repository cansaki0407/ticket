package com.example.demo.mappers;

import com.example.demo.bean.UserLoginBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/9/11- 15:20
 */
@Mapper
public interface LoginMapper {
	public Integer userLogin(@Param("loginInfo") UserLoginBean userLoginBean);
}


