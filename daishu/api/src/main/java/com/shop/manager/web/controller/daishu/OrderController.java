package com.shop.manager.web.controller.daishu;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shop.data.mapper.daishu.Customer;
import com.shop.data.mapper.daishu.Order;
import com.shop.manager.web.controller.AbstractController;
import com.shop.manager.web.model.ResponseData;
import com.shop.service.AbstractService;
import com.shop.service.daishu.OrderService;
import com.shop.service.daishu.ScheduleService;

@Controller
@RequestMapping("order")
public class OrderController extends AbstractController<Order> {

	@Autowired
	private OrderService orderService;
	@Autowired
	private ScheduleService scheduleService;
	
	@RequestMapping
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("daishu/order/order");
		return mav;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("daishu/order/add");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseData add(HttpServletRequest request, Order order) {
		// TODO 判断排期是否已满
		int count = scheduleService.availableAyiCount(order.getBaojieType(), order.getServiceDate(), order.getServiceTimeType());
		if (count > 0) {
			Customer customer = this.getLoginCustomer(request);
			// TODO 新增订单
			order.setOrderNo(System.currentTimeMillis() + "" + customer.getId());
			order.setAuditStatus(Order.AUDIT_STATUS_WAIT);
			order.setPayStatus(Order.PAY_STATUS_WAIT_PAY);
			this.getAbstractService().insert(order);
		}
		return this.response("添加订单成功", ResponseData.ACTION_TOAST);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(int id) {
		Order order = this.getAbstractService().selectById(id);
		ModelAndView mav = new ModelAndView("daishu/order/update");
		mav.addObject("order", order);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseData update(Order order) {
		this.getAbstractService().update(order);
		return this.response("修改订单成功", ResponseData.ACTION_TOAST);
	}
	
	@Override
	public AbstractService<Order> getAbstractService() {
		return this.orderService;
	}

}
