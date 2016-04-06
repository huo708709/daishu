package com.shop.manager.web.controller.daishu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shop.data.mapper.daishu.Address;
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
		return mav;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("daishu/address/add");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseData add(Address address) {
		this.getAbstractService().insert(address);
		return this.response("添加地址成功", ResponseData.ACTION_TOAST);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(int id) {
		Address address = this.getAbstractService().selectById(id);
		ModelAndView mav = new ModelAndView("daishu/address/update");
		mav.addObject("address", address);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseData update(Address address) {
		this.getAbstractService().update(address);
		return this.response("修改地址成功", ResponseData.ACTION_TOAST);
	}
	
	@Override
	public AbstractService<Address> getAbstractService() {
		return this.addressService;
	}

}
