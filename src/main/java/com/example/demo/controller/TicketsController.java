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

	//获取景点类型选择器下拉框的数据
	//localhost:8080/tickets/getScenic_spot_type
	@GetMapping("/getScenic_spot_type")
	public List<String> getScenic_spot_type(){
		return ticketsService.getScenic_spot_type();
	}

	//按景点名称搜索
	@PostMapping("/getTicketsByName")
	//http://localhost:8080/tickets/getTicketsByName
	public List<TicketBean> getTicketsByName(@RequestBody Map<String,Object> name){
		return ticketsService.getTicketsByName(name);
	}

	//按地名搜索
	//http://localhost:8080/tickets/getTicketsByZone
	@PostMapping("/getTicketsByZone")
	public List<TicketBean> getTicketsByZone(@RequestBody String zone){
		return ticketsService.getTicketsByZone(zone);
	}

	//按类型搜索
	@GetMapping("/getTicketsByType")
	public List<TicketBean> getTicketsByType(@RequestParam(value = "type") String type){
		return ticketsService.getTicketsByType(type);
	}

}
