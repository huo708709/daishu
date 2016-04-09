package com.shop.manager.web.controller.daishu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shop.data.mapper.daishu.Recharge;
import com.shop.manager.web.controller.AbstractController;
import com.shop.manager.web.model.ResponseData;
import com.shop.service.AbstractService;
import com.shop.service.daishu.RechargeService;

@Controller
@RequestMapping("recharge")
public class RechargeController extends AbstractController<Recharge> {

	@Autowired
	private RechargeService rechargeService;
	
	@RequestMapping
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("recharge");
		mav.addObject("show", 0);
		return mav;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView("recharge");
		mav.addObject("show", 1);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseData add(Recharge recharge) {
		this.getAbstractService().insert(recharge);
		return this.response("充值成功", ResponseData.ACTION_TOAST);
	}
	
	@Override
	public AbstractService<Recharge> getAbstractService() {
		return this.rechargeService;
	}

}
