package com.example.demo.mappers;

import com.example.demo.bean.TicketBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/9/14- 21:17
 */
@Mapper
public interface TicketsMapper {
	//添加新的旅游票对象
	public void createTicket(@Param("ticketBean")TicketBean ticketBean);
	//删除旅游票对象
	public void removeTicket(@Param("good_id") String good_id);
	//获取所有的旅游票对象
	public List<TicketBean> getAllTickets();
	//修改旅游票对象
	public void updateTicket(@Param("good_id") String good_id,@Param("ticketBean") Map<String,Object> ticketBean);
}
