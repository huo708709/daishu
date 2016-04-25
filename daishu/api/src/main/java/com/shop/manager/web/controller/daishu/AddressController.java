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

	@RequestMapping(value = "addressList")
	public ModelAndView addressList(HttpServletRequest request) {
		Customer customer = this.getLoginCustomer(request);
		List<Address> addressList = addressService.getAddressListByCustomerId(customer.getId());
		ModelAndView mav = new ModelAndView("addressList");
		mav.addObject("addressList", addressList);
		return mav;
	}

	@RequestMapping(value = "addressEdit")
	public ModelAndView addressEdit(int id) {
		ModelAndView mav = new ModelAndView("addressEdit");
		if (id > 0) {
			Address address = this.addressService.selectById(id);
			mav.addObject("address", address);
		}
		return mav;
	}

	@RequestMapping(value = "addressDel")
	public ModelAndView addressDel(HttpServletRequest request, int id) {
		this.addressService.updateStatus(id, Address.STATUS_HIDE);
		ModelAndView mav = new ModelAndView("redirect:/address/addressList");
		return mav;
	}
	
	@RequestMapping
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("address");
		mav.addObject("show", 0);
		return mav;
	}
	
	@RequestMapping(value = "editAddress", method = RequestMethod.POST)
	public ModelAndView editAddress(HttpServletRequest request, Address address) {
		Customer customer = this.getLoginCustomer(request);
		address.setCustomerId(customer.getId());
		if (0 < address.getId()) {
			this.addressService.update(address);
		} else {
			address.setStatus(Address.STATUS_SHOW);
			this.addressService.insert(address);
		}
		ModelAndView mav = new ModelAndView("redirect:/address/addressList");
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

	@RequestMapping(value = "getAddressListByCustomerId")
	public ModelAndView getAddressListByCustomerId(HttpServletRequest request) {
		Customer customer = this.getLoginCustomer(request);
		List<Address> list = this.addressService.getAddressListByCustomerId(customer.getId());
		ModelAndView mav = new ModelAndView("addressListByCustomer");
		mav.addObject("list", list);
		return mav;
	}
	
	@Override
	public AbstractService<Address> getAbstractService() {
		return this.addressService;
	}

}
