package com.shop.manager.web.controller.daishu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shop.data.mapper.daishu.Order;
import com.shop.manager.web.controller.AbstractController;
import com.shop.service.AbstractService;
import com.shop.service.daishu.OrderService;

@Controller
@RequestMapping("daishu/order_statistic")
public class OrderStatisticController extends AbstractController<Order> {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("daishu/order/order_statistic");
		return mav;
	}
	
	@Override
	public AbstractService<Order> getAbstractService() {
		return this.orderService;
	}

}
