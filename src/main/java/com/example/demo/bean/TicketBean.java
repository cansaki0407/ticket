package com.example.demo.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 皮皮瑶
 * @proname
 * @data 2022/9/14- 16:54
 */
@Data
public class TicketBean {
	private Integer id;
	private String goods_id;
	//image为图片的路径
	private String image;
	private String title;
	private BigDecimal price;
	private String province;
	private String city;
	private String type;
	private int stocks;
}
