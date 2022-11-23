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
	public void removeTicket(@Param("goods_id") String goods_id);
	//获取所有的旅游票对象
	public List<TicketBean> getAllTickets();
	//修改旅游票对象
	public void updateTicket(@Param("goods_id") String good_id,@Param("ticketBean") Map<String,Object> ticketBean);
	//获取所有景点类型的集合
	public List<String> getScenic_spot_type();
	//按景点名称搜索
	public List<TicketBean> getTicketsByName(@Param("name") Map<String,Object> name);
	//按地名搜索
	public List<TicketBean> getTicketsByZone(@Param("zone") String zone);
	//按类型搜索
	public List<TicketBean> getTicketsByType(@Param("ticketType") String type);
}
