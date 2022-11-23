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

	//获取景点类型选择器下拉框的数据
	public List<String> getScenic_spot_type();

	//按景点名称搜索
	public List<TicketBean> getTicketsByName(Map<String,Object> name);

	//按地名搜索
	public List<TicketBean> getTicketsByZone(String name);

	//按类型搜索
	public List<TicketBean> getTicketsByType(String type);
}