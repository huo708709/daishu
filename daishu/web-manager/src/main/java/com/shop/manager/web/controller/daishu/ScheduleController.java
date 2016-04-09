package com.shop.manager.web.controller.daishu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shop.data.mapper.daishu.Schedule;
import com.shop.manager.web.controller.AbstractController;
import com.shop.service.AbstractService;
import com.shop.service.daishu.ScheduleService;

@Controller
@RequestMapping("daishu/schedule")
public class ScheduleController extends AbstractController<Schedule> {
	
	@Autowired
	private ScheduleService scheduleService;
	@RequestMapping
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("daishu/schedule/schedule");
		Schedule schedule = scheduleService.selectById(1);
		mav.addObject("schedule",schedule);
		return mav;
	}
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(String name, String value) {
		try {
			this.scheduleService.update(name, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	@Override
	public AbstractService<Schedule> getAbstractService() {
		return null;
	}

}
