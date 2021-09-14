//package com.pairlearning.expensetracker.services;
//
//
//import java.sql.Timestamp;
//
//import com.pairlearning.expensetracker.domain.Order;
//import com.pairlearning.expensetracker.exceptions.EtBadRequestException;
//import com.pairlearning.expensetracker.exceptions.EtResourceNotFoundException;
//
//public interface OrderService {
//
//	Order fetchOrderById(Integer id, Integer uId) throws EtResourceNotFoundException;
//
//    Order addOrder(Integer id, Integer uId, String address, Timestamp created, Timestamp updated) throws EtBadRequestException;
//
//    void updatOrder(Integer id, Integer uId, String address, Timestamp created, Timestamp updated, Order order) throws EtBadRequestException;
//
//}
