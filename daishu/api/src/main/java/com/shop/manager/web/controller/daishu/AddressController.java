package com.shop.manager.web.controller.daishu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shop.data.mapper.daishu.Address;
import com.shop.data.mapper.daishu.Customer;
import com.shop.manager.web.controller.AbstractController;
import com.shop.manager.web.model.ResponseData;
import com.shop.service.AbstractService;
import com.shop.service.daishu.AddressService;

@Controller
@RequestMapping("address")
public class AddressController extends AbstractController<Address> {

	@Autowired
	private AddressService addressService;
	
	@RequestMapping
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("address");
		mav.addObject("show", 0);
		return mav;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("address");
		mav.addObject("show", 1);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseData add(Address address) {
		this.getAbstractService().insert(address);
		return this.response("添加地址成功", ResponseData.ACTION_TOAST);
	}
	
	@ResponseBody
	@RequestMapping(value = "selectById", method = RequestMethod.GET)
	public ResponseData selectById(int id) {
		Address address = this.getAbstractService().selectById(id);
		return this.response("", address);
	}
	
	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseData update(Address address) {
		this.getAbstractService().update(address);
		return this.response("修改地址成功", ResponseData.ACTION_TOAST);
	}
	
	@ResponseBody
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public ResponseData delete(@RequestParam("ids[]") int[] ids) {
		this.addressService.deleteByIds(ids);
		return this.response("删除成功", ResponseData.ACTION_TOAST);
	}

	@ResponseBody
	@RequestMapping(value = "getAddressListByCustomerId", method = RequestMethod.POST)
	public ResponseData getAddressListByCustomerId(HttpServletRequest request) {
		Customer customer = this.getLoginCustomer(request);
		List<Address> list = this.addressService.getAddressListByCustomerId(customer.getId());
		return this.response("", list);
	}
	
	@Override
	public AbstractService<Address> getAbstractService() {
		return this.addressService;
	}

}
