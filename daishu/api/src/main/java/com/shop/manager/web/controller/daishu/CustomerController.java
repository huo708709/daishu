package com.shop.manager.web.controller.daishu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shop.manager.mapper.daishu.Customer;
import com.shop.manager.service.AbstractService;
import com.shop.manager.service.daishu.CustomerService;
import com.shop.manager.web.controller.AbstractController;
import com.shop.manager.web.model.ResponseData;

@Controller
@RequestMapping("daishu/customer")
public class CustomerController extends AbstractController<Customer> {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("daishu/customer/customer");
		return mav;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("daishu/customer/add");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseData add(Customer customer) {
		customer.setStatus(Customer.STATUS_NORMAL);
		this.getAbstractService().insert(customer);
		return this.response("添加顾客成功", ResponseData.ACTION_TOAST);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(int id) {
		Customer customer = this.getAbstractService().selectById(id);
		ModelAndView mav = new ModelAndView("daishu/customer/update");
		mav.addObject("customer", customer);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseData update(Customer customer) {
		this.getAbstractService().update(customer);
		return this.response("修改顾客成功", ResponseData.ACTION_TOAST);
	}
	
	@Override
	public AbstractService<Customer> getAbstractService() {
		return this.customerService;
	}

}
