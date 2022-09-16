package com.example.demo.controller;

import com.example.demo.bean.TicketBean;
import com.example.demo.service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/9/14- 17:34
 */
@CrossOrigin
@RestController
@RequestMapping("/tickets")
public class TicketsController {

	@Autowired
	TicketsService ticketsService;

	//添加新的旅游票对象
	@PostMapping ("/createTicket")
	public void createTicket(@RequestBody TicketBean ticketBean){
		ticketsService.createTicket(ticketBean);
	}

	//删除旅游票对象
	@DeleteMapping("/removeTicket/{goods_id}")
	public void removeTicket(@PathVariable("goods_id") String goods_id){
		ticketsService.removeTicket(goods_id);
	}

	//获取所有的旅游票对象\
	//localhost:8080/tickets/getAllTickets
	@GetMapping("/getAllTickets")
	public List<TicketBean> getAllTickets(){
		return ticketsService.getAllTickets();
	}

	//修改旅游票对象
	@PutMapping("/updateTicket/{goods_id}")
	public void updateTicket(@PathVariable String goods_id, @RequestBody Map<String,Object> ticketCondition) {
		ticketsService.updateTicket(goods_id,ticketCondition);
	}
}
