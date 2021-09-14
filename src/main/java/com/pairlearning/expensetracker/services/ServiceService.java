//package com.pairlearning.expensetracker.services;
//
//import java.util.List;
//
//import com.pairlearning.expensetracker.domain.Service;
//import com.pairlearning.expensetracker.exceptions.EtBadRequestException;
//import com.pairlearning.expensetracker.exceptions.EtResourceNotFoundException;
//
//public interface ServiceService {
//	 List<Service> fetchAllService(Integer id);
//      void fetchServiceById(Integer id) throws EtResourceNotFoundException;
//
//	    Service addCategory(Integer id, String name,  Double money, String unit, Integer piority, String description) throws EtBadRequestException;
//
//	    void updateCategory(Integer id, String name, Double money, String unit, Integer piority, String description, Service servicey) throws EtBadRequestException;
//
//	    void removeCategoryWithAllTransactions(Integer id) throws EtResourceNotFoundException;
//}
