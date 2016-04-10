package com.shop.manager.web.controller.daishu;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shop.data.mapper.daishu.Schedule;
import com.shop.manager.web.controller.AbstractController;
import com.shop.manager.web.model.ResponseData;
import com.shop.service.AbstractService;
import com.shop.service.daishu.ScheduleService;

@Controller
@RequestMapping("schedule")
public class ScheduleController extends AbstractController<Schedule> {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@RequestMapping
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("daishu/schedule/schedule");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "getAvailableAyiCountMap")
	public ResponseData getAvailableAyiCountMap(int baoJieType, String serviceDate) {
		Map<Integer, Integer> map = this.scheduleService.getAvailableAyiCountMap(baoJieType, serviceDate);
		return this.response("", map);
	}
	
	@Override
	public AbstractService<Schedule> getAbstractService() {
		return null;
	}

}