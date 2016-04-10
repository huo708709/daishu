package com.shop.service.daishu;

import java.util.HashMap;
import java.util.Map;

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
	/**
	 * @param baoJieType 保洁类型 
	 * @param serviceDate 服务日期 "2014-01-01"
	 */
	public Map<Integer,Integer> getAvailableAyiCountMap(int baoJieType,String serviceDate){
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		int c1 = this.availableAyiCount(baoJieType, serviceDate, 1);
		int c2 = this.availableAyiCount(baoJieType, serviceDate, 2);
		int c3 = this.availableAyiCount(baoJieType, serviceDate, 3);
		int c4 = this.availableAyiCount(baoJieType, serviceDate, 4);
		map.put(1, c1);
		map.put(2, c2);
		map.put(3, c3);
		map.put(4, c4);
		return map;
	}
}
