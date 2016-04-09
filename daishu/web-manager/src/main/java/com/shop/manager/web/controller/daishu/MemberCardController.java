package com.shop.manager.web.controller.daishu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shop.data.mapper.daishu.MemberCard;
import com.shop.manager.web.controller.AbstractController;
import com.shop.service.AbstractService;
import com.shop.service.daishu.MemberCardService;

@Controller
@RequestMapping("daishu/member_card")
public class MemberCardController extends AbstractController<MemberCard> {
	
	@Autowired
	private MemberCardService memberCardService;
	@RequestMapping
	public ModelAndView page() {
		ModelAndView mav = new ModelAndView("daishu/member_card/member_card");
		List<MemberCard> memberCards = memberCardService.listAll();
		mav.addObject("memberCards",memberCards);
		return mav;
	}
	@ResponseBody
	@RequestMapping(value = "update")
	public String update(String pk,String name, String value) {
		try {
			this.memberCardService.update(pk,name, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	@Override
	public AbstractService<MemberCard> getAbstractService() {
		return null;
	}

}
