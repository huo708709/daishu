package com.shop.manager.web.controller.daishu;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shop.data.mapper.daishu.Consume;
import com.shop.data.mapper.daishu.Order;
import com.shop.manager.web.controller.AbstractController;
import com.shop.manager.web.model.ResponseData;
import com.shop.service.AbstractService;
import com.shop.service.daishu.ConsumeService;
import com.shop.service.daishu.CustomerService;
import com.shop.service.daishu.OrderService;

@Controller
@RequestMapping("consume")
public class ConsumeController extends AbstractController<Consume> {

	@Autowired
	private ConsumeService consumeService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private OrderService orderService;
	
	@RequestMapping
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("consume");
		mav.addObject("show", 0);
		return mav;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("consume");
		mav.addObject("show", 1);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseData add(int orderId, String orderNo) {
		Order order = this.orderService.selectByIdAndNo(orderId, orderNo);
		double balance = this.customerService.getBalance(order.getCustomerId());
		if (balance > order.getPrice()) {
			this.customerService.updateBalance(order.getCustomerId(), order.getPrice() * -1.0);
			Consume consume = new Consume();
			consume.setOrderId(orderId);
			consume.setMoney(order.getPrice());
			consume.setTime(new Date());
			consume.setCustomerId(order.getCustomerId());
			this.getAbstractService().insert(consume);
			this.orderService.updatePayStatusAndPayTypeByIds(new int[]{orderId}, Order.PAY_STATUS_SERVICE, Order.PAY_TYPE_MEMBER);
			return this.response("消费成功", ResponseData.ACTION_TOAST);
		} else {
			return this.response(ResponseData.CODE_ERROR, "余额不足，当前余额" + order.getPrice(), ResponseData.ACTION_ALERT);
		}
	}
	
	@Override
	public AbstractService<Consume> getAbstractService() {
		return this.consumeService;
	}

}
