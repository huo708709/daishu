package com.shop.manager.web.controller.daishu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shop.data.mapper.daishu.Schedule;
import com.shop.manager.web.controller.AbstractController;
import com.shop.service.AbstractService;

@Controller
@RequestMapping("daishu/schedule")
public class ScheduleController extends AbstractController<Schedule> {
	
	@RequestMapping
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("daishu/schedule/schedule");
		return mav;
	}
	
	@Override
	public AbstractService<Schedule> getAbstractService() {
		return null;
	}

}
