package com.shop.manager.web.controller.daishu;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shop.data.mapper.daishu.Order;
import com.shop.manager.web.controller.AbstractController;
import com.shop.manager.web.model.ResponseData;
import com.shop.service.AbstractService;
import com.shop.service.daishu.OrderService;

@Controller
@RequestMapping("daishu/order")
public class OrderController extends AbstractController<Order> {

	@Autowired
	private OrderService orderService;
	
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
	@RequestMapping(value = "copy", method = RequestMethod.GET)
	public ModelAndView copyPage(int id) {
		ModelAndView mav = new ModelAndView("daishu/order/copy");
		Order order = this.getAbstractService().selectById(id);
		mav.addObject("order", order);
		return mav;
	}
	@RequestMapping(value = "copy", method = RequestMethod.POST)
	public ResponseData copy(int id) {
		Order order = this.getAbstractService().selectById(id);
		order.setCreateTime(new Date());
		order.setOrderNo(Order.createOrderNo(order.getCustomerId()));
		order.setPayStatus(Order.PAY_STATUS_WAIT_PAY);
		order.setPayType(Order.PAY_TYPE_CASH);
		order.setAuditStatus(Order.AUDIT_STATUS_PASS);
		this.getAbstractService().insert(order);
		return this.response("修改单位成功", ResponseData.ACTION_TOAST);
	}
	@ResponseBody
	@RequestMapping(value = "changePrice", method = RequestMethod.POST)
	public String changePrice(int pk,String name,String value) {
		try {
			this.orderService.changeProperty(pk,name, Double.valueOf(value));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseData add(Order order) {
		order.setAuditStatus(Order.AUDIT_STATUS_NOT_PASS);
		order.setPayStatus(Order.PAY_STATUS_WAIT_PAY);
		order.setOrderNo(Order.createOrderNo(order.getCustomerId()));
		this.getAbstractService().insert(order);
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
