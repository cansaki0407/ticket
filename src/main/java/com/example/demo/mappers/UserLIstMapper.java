package com.example.demo.mappers;

import com.example.demo.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/8/27- 18:31
 */
@Mapper
public interface UserLIstMapper {
	public List<UserBean> getUserList();
}
