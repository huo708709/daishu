package com.shop.manager.web.controller.daishu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shop.data.mapper.daishu.Unit;
import com.shop.manager.web.controller.AbstractController;
import com.shop.manager.web.model.ResponseData;
import com.shop.service.AbstractService;
import com.shop.service.daishu.UnitService;

@Controller
@RequestMapping("ds/unit")
public class UnitController extends AbstractController<Unit> {

	@Autowired
	private UnitService unitService;
	
	@RequestMapping
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("daishu/unit/unit");
		return mav;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("daishu/unit/add");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseData add(Unit unit) {
		this.getAbstractService().insert(unit);
		return this.response("添加单位成功", ResponseData.ACTION_TOAST);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(int id) {
		Unit unit = this.getAbstractService().selectById(id);
		ModelAndView mav = new ModelAndView("daishu/unit/update");
		mav.addObject("unit", unit);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseData update(Unit unit) {
		this.getAbstractService().update(unit);
		return this.response("修改单位成功", ResponseData.ACTION_TOAST);
	}
	
	@Override
	public AbstractService<Unit> getAbstractService() {
		return this.unitService;
	}

}
