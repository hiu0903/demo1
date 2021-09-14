//package com.pairlearning.expensetracker.repositories;
//
//import java.util.List;
//
//import com.pairlearning.expensetracker.domain.Service;
//import com.pairlearning.expensetracker.exceptions.EtBadRequestException;
//import com.pairlearning.expensetracker.exceptions.EtResourceNotFoundException;
//
//public interface ServiceRepository {
//	 List<Service> findAll(Integer id ,  String name, Double money, String unit, Integer piority, String description ) throws EtResourceNotFoundException;
//
//	    Service findById(Integer id) throws EtResourceNotFoundException;
//
//	    Integer create(Integer id, String name,  Double money, String unit, Integer piority, String description) throws EtBadRequestException;
//
//	    void update(Integer id, String name,  Double money, String unit, Integer piority, String description ,Service service) throws EtBadRequestException;
//
//	     void removeById(Integer id);
//}
