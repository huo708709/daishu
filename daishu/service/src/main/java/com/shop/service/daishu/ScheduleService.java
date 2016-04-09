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
	public void update(int baojieType,String name, String value) {
		this.scheduleMapper.update(baojieType,name, value);
	}
	@Override
	public AbstractMapper getAbstractMapper() {
		return this.scheduleMapper;
	}
	public int countOrderByServiceDateAndTimeTypeAndBaoJieType(int baoJieType,String serviceDate,int serviceTimeType){
		return this.scheduleMapper.countOrderByServiceDateAndTimeTypeAndBaoJieType(baoJieType,serviceDate,serviceTimeType);
	}
	public int countAyiByServiceDateAndBaoJieType(int baoJieType,String serviceDate){
		int dayOfWeek = DateUtils.dayForWeek(serviceDate);
		String xingqiNum = "xingqi"+dayOfWeek;
		return this.scheduleMapper.countAyiByxingqiNumAndBaoJieType(xingqiNum,baoJieType);
	}
	/**
	 * @param baoJieType 保洁类型 
	 * @param serviceDate 服务日期 "2014-01-01"
	 * @param serviceTimeType 服务时间段类型
	 * @return
	 */
	public int availableAyiCount(int baoJieType,String serviceDate,int serviceTimeType){
		int total = this.countAyiByServiceDateAndBaoJieType(baoJieType,serviceDate);
		int used = this.countOrderByServiceDateAndTimeTypeAndBaoJieType(baoJieType,serviceDate,serviceTimeType);
		int available = total - used;
		if(available<0){
			available = 0;
		}
		return available;
	}
}
