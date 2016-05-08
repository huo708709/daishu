package com.shop.manager.web.controller.data;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shop.data.mapper.daishu.Ayi;
import com.shop.data.mapper.daishu.Order;
import com.shop.data.model.TableData;
import com.shop.data.model.TableParameter;
import com.shop.manager.web.controller.AbstractController;
import com.shop.service.AbstractService;
import com.shop.service.daishu.AyiService;
import com.shop.service.daishu.OrderService;

/**
 * 数据管理-订单数据
 *
 */
@Controller
@RequestMapping("data/data_order")
public class DataOrderController extends AbstractController<Order> {

	@Autowired
	private OrderService orderService;
	@Autowired
	private AyiService ayiService;
	
	@RequestMapping
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("data/order/data_order");
		List<Ayi> ayis = ayiService.listAll();
		mav.addObject("ayis", ayis);
		return mav;
	}
	@ResponseBody
	@RequestMapping(value = "list_paged_order_data")
	public TableData listPagedOrderData(TableParameter parameter, String startTime, String endTime, int ayiId) {
		if(StringUtils.isNotBlank(startTime)){
			startTime = startTime + " 00:00:00";
		}
		if(StringUtils.isNotBlank(endTime)){
			endTime = endTime + " 23:59:59";
		}
		return orderService.listPagedOrderData(parameter, startTime, endTime, ayiId);
	}
	
	@Override
	public AbstractService<Order> getAbstractService() {
		return this.orderService;
	}

}
