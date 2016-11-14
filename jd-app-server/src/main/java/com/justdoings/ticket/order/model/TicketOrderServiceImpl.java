package com.justdoings.ticket.order.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.justdoings.ticket.info.model.TicketInfo;
import com.justdoings.ticket.info.model.TicketInfoDao;
import com.justdoings.ticket.model.Ticket;
import com.justdoings.ticket.model.TicketDao;

@Service("ticketOrderService")
public class TicketOrderServiceImpl implements TicketOrderService {
	@Autowired
	private TicketOrderDao ticketOrderDao;
	
	@Autowired
	private TicketInfoDao ticketInfoDao;
	
	@Autowired
	private TicketDao ticketDao;

	@Override
	@Transactional
	public void save(TicketOrder order, List<TicketInfo> ticketInfos) {
		//TODO:此方法還會修正，等畫面的model做出來傳入參數會不同
		ticketOrderDao.save(order);
		for(TicketInfo ticInfo : ticketInfos){
			Ticket ticket = new Ticket();
			ticket.setTicOrd(order);
			ticket.setTicInfo(ticInfo);
			ticketDao.save(ticket);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public TicketOrder findOne(Integer ordSeq) {
		return ticketOrderDao.findOne(ordSeq);
	}

	@Override
	@Transactional
	public void delete(TicketOrder order) {
		ticketOrderDao.delete(order);
	}

	@Override
	@Transactional
	public void delete(Integer ordSeq) {
		ticketOrderDao.delete(ordSeq);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TicketOrder> findByMemSeq(Integer memSeq) {
		return ticketOrderDao.findByMemSeq(memSeq);
	}
}
