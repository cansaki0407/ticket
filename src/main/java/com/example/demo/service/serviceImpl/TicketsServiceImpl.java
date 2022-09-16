package com.example.demo.service.serviceImpl;

import com.example.demo.bean.TicketBean;
import com.example.demo.mappers.TicketsMapper;
import com.example.demo.service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/9/14- 21:09
 */
@Component
public class TicketsServiceImpl implements TicketsService {

	@Autowired
	TicketsMapper ticketsMapper;

	@Override
	//添加新的旅游票对象
	public void createTicket(TicketBean ticketBean) {
		ticketsMapper.createTicket(ticketBean);
	}

	@Override
	//删除旅游票对象
	public void removeTicket(String goods_id) {
		ticketsMapper.removeTicket(goods_id);
	}

	@Override
	//获取所有的旅游票对象
	public List<TicketBean> getAllTickets() {
		return ticketsMapper.getAllTickets();
	}

	@Override
	//修改旅游票对象
	public void updateTicket(String goods_id, Map<String,Object> ticketBean) {
		ticketsMapper.updateTicket(goods_id,ticketBean);
	}
}
