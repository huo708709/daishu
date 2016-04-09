package com.shop.service.daishu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.data.mapper.AbstractMapper;
import com.shop.data.mapper.daishu.Schedule;
import com.shop.data.mapper.daishu.ScheduleMapper;
import com.shop.service.AbstractService;
import com.shop.util.DateUtils;

@Service
public class ScheduleService extends AbstractService<Schedule> {

	@Autowired
	private ScheduleMapper scheduleMapper;
	
	public ScheduleService() {
		super(Schedule.class);
	}
	public void update(String name, String value) {
		this.scheduleMapper.update(name, value);
	}
	@Override
	public AbstractMapper getAbstractMapper() {
		return this.scheduleMapper;
	}
	public int countOrderByServiceDateAndTimeTypeAndBaoJieType(int baoJieType,String serviceDate,int serviceTimeType){
		return this.scheduleMapper.countOrderByServiceDateAndTimeTypeAndBaoJieType(baoJieType,serviceDate,serviceTimeType);
	}
	public int countAyiByServiceDateAndBaoJieType(String serviceDate,int baoJieType){
		int dayOfWeek = DateUtils.dayForWeek(serviceDate);
		return 0;
//		return this.scheduleMapper.countAyiByServiceDateAndBaoJieType(serviceDate,baoJieType);
	}
}
