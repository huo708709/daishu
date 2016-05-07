package com.shop.manager.web.controller.daishu;

import java.util.List;

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
@RequestMapping("ds/schedule")
public class ScheduleController extends AbstractController<Schedule> {
	
	@Autowired
	private ScheduleService scheduleService;
	@RequestMapping
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("daishu/schedule/schedule");
		List<Schedule> schedules = scheduleService.listAll();
		mav.addObject("schedules",schedules);
		return mav;
	}
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(int pk,String name, String value) {
		try {
			this.scheduleService.update(pk, name, value);
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
