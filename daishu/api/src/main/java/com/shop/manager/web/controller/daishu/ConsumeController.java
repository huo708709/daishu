package com.shop.manager.web.controller.daishu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shop.data.mapper.daishu.Consume;
import com.shop.manager.web.controller.AbstractController;
import com.shop.manager.web.model.ResponseData;
import com.shop.service.AbstractService;
import com.shop.service.daishu.ConsumeService;

@Controller
@RequestMapping("consume")
public class ConsumeController extends AbstractController<Consume> {

	@Autowired
	private ConsumeService consumeService;
	
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
	public ResponseData add(Consume consume) {
		this.getAbstractService().insert(consume);
		return this.response("消费成功", ResponseData.ACTION_TOAST);
	}
	
	@Override
	public AbstractService<Consume> getAbstractService() {
		return this.consumeService;
	}

}
