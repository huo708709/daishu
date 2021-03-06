package com.shop.service.daishu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.data.mapper.AbstractMapper;
import com.shop.data.mapper.daishu.CustomerMapper;
import com.shop.data.mapper.daishu.MemberCard;
import com.shop.data.mapper.daishu.MemberCardMapper;
import com.shop.data.mapper.daishu.Recharge;
import com.shop.data.mapper.daishu.RechargeMapper;
import com.shop.service.AbstractService;

@Service
public class RechargeService extends AbstractService<Recharge> {

	@Autowired
	private RechargeMapper rechargeMapper;
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private MemberCardMapper memberCardMapper;
	
	public RechargeService() {
		super(Recharge.class);
	}
	
	public int paySuccess(Recharge recharge) {
		Recharge tmp = this.rechargeMapper.selectByNo(recharge.getOutTradeNo());
		if (tmp.getStatus() == Recharge.STATUS_NOT_PAY) {
			MemberCard memberCard = memberCardMapper.selectByType(recharge.getType());
			customerMapper.updateBalanceByOpenId(recharge.getOpenId(), recharge.getMoney() + memberCard.getGiveAmount() * 100);
			return this.rechargeMapper.paySuccess(recharge);
		}
		return 0;
	}
	
	@Override
	public AbstractMapper getAbstractMapper() {
		return this.rechargeMapper;
	}

}
