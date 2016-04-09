package com.shop.manager.web.controller.daishu;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shop.data.mapper.daishu.Ayi;
import com.shop.manager.web.controller.AbstractController;
import com.shop.manager.web.model.ResponseData;
import com.shop.service.AbstractService;
import com.shop.service.daishu.AyiService;

@Controller
@RequestMapping("daishu/ayi")
public class AyiController extends AbstractController<Ayi> {

	@Autowired
	private AyiService ayiService;
	
	@RequestMapping
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("daishu/ayi/ayi");
		return mav;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("daishu/ayi/add");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseData add(Ayi ayi) {
		this.getAbstractService().insert(ayi);
		return this.response("添加阿姨成功", ResponseData.ACTION_TOAST);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(int id) {
		Ayi ayi = this.getAbstractService().selectById(id);
		ModelAndView mav = new ModelAndView("daishu/ayi/update");
		mav.addObject("ayi", ayi);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseData update(Ayi ayi) {
		this.getAbstractService().update(ayi);
		return this.response("修改阿姨成功", ResponseData.ACTION_TOAST);
	}
	@RequestMapping(value = "choice")
	public ModelAndView chooseRole(int orderId) {
		ModelAndView mav = new ModelAndView("daishu/ayi/choose_ayi");
		List<Map<String, Object>> ayis = this.ayiService.selectWithOrderId(orderId);
		mav.addObject("ayis", ayis);
		return mav;
	}
	@ResponseBody
	@RequestMapping(value = "assign_ayi")
	public ResponseData assignRoles(int orderId, int ayiId) {
		this.ayiService.assignAyi(orderId, ayiId);
		return this.response("指派阿姨成功", ResponseData.ACTION_TOAST);
	}
	@Override
	public AbstractService<Ayi> getAbstractService() {
		return this.ayiService;
	}

}
