package com.shop.manager.web.controller.website;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shop.data.mapper.daishu.Unit;
import com.shop.data.mapper.website.Business;
import com.shop.manager.web.controller.AbstractController;
import com.shop.manager.web.model.ResponseData;
import com.shop.service.AbstractService;
import com.shop.service.daishu.UnitService;
import com.shop.service.website.BusinessService;

@Controller
@RequestMapping("website/business")
public class BusinessController extends AbstractController<Business> {

	@Autowired
	private BusinessService businessService;
	@Autowired
	private UnitService unitService;
	
	@RequestMapping
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("website/business/business");
		return mav;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("website/business/add");
		List<Unit> units = unitService.listAll();
		mav.addObject("units", units);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseData add(Business business) {
		this.getAbstractService().insert(business);
		return this.response("添加业务类型成功", ResponseData.ACTION_TOAST);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(int id) {
		Business business = this.getAbstractService().selectById(id);
		ModelAndView mav = new ModelAndView("website/business/update");
		mav.addObject("business", business);
		List<Unit> units = unitService.listAll();
		mav.addObject("units", units);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseData update(Business business) {
		this.getAbstractService().update(business);
		return this.response("修改业务类型成功", ResponseData.ACTION_TOAST);
	}
	
	@Override
	public AbstractService<Business> getAbstractService() {
		return this.businessService;
	}

}
