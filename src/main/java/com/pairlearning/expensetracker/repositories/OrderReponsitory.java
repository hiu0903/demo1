//package com.pairlearning.expensetracker.repositories;
//
//import java.sql.Timestamp;
//
//import com.pairlearning.expensetracker.domain.Order;
//import com.pairlearning.expensetracker.exceptions.EtAuthException;
//import com.pairlearning.expensetracker.exceptions.EtBadRequestException;
//
//public interface OrderReponsitory {
//
//	Integer create(Integer id, Integer uId, String address, Timestamp created, Timestamp updated) throws EtAuthException;
//
//    Order findById(Integer id, Integer uId) throws EtAuthException;
//
//    void update(Integer id, Integer uId, String address, Timestamp created, Timestamp updated, Order order) throws EtBadRequestException;
//}
