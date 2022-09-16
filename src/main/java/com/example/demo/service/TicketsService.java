package com.example.demo.service;


import com.example.demo.bean.TicketBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/9/14- 17:47
 */
@Service
public interface TicketsService {
	//添加新的旅游票对象
	public void createTicket(TicketBean ticketBean);

	//删除旅游票对象
	public void removeTicket(String goods_id);

	//获取所有的旅游票对象
	public List<TicketBean> getAllTickets();

	//修改旅游票对象
	public void updateTicket(String goods_id, Map<String,Object> ticketCondition);
}