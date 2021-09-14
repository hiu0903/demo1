//package com.pairlearning.expensetracker.services;
//
//import java.sql.Timestamp;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.pairlearning.expensetracker.domain.Order;
//import com.pairlearning.expensetracker.exceptions.EtBadRequestException;
//import com.pairlearning.expensetracker.exceptions.EtResourceNotFoundException;
//import com.pairlearning.expensetracker.repositories.OrderReponsitory;
//
//
//@Service
//@Transactional
//public class OrderServiceImpl implements OrderService{
//
//	@Autowired
//    OrderReponsitory orderRepository;
//	
//	@Override
//	public Order fetchOrderById(Integer id, Integer uId) throws EtResourceNotFoundException {
//        return orderRepository.findById(id,uId);
//	}
//
//	@Override
//	public Order addOrder(Integer id, Integer uId, String address, Timestamp created, Timestamp updated)
//			throws EtBadRequestException {
//		@SuppressWarnings("unused")
//		int categoryId  = orderRepository.create(id,uId,address,created,updated);
//        return orderRepository.findById(id,uId);
//	}
//
//	@Override
//	public void updatOrder(Integer id, Integer uId, String address, Timestamp created, Timestamp updated, Order order)
//			throws EtBadRequestException {
//		orderRepository.update(id, uId, address,created,updated);
//		
//	}
//
//}
