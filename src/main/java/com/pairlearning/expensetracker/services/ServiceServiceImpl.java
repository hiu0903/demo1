//package com.pairlearning.expensetracker.services;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.pairlearning.expensetracker.exceptions.EtBadRequestException;
//import com.pairlearning.expensetracker.exceptions.EtResourceNotFoundException;
//import com.pairlearning.expensetracker.repositories.ServiceRepository;
//
//@Service
//@Transactional
//public class ServiceServiceImpl implements ServiceService {
//	
//	@Autowired
//	ServiceRepository serviceRepository;
//
//	public List<com.pairlearning.expensetracker.domain.Service> fetchAllService(Integer id,  String name,  Double money, String unit, Integer piority, String description) {
//		
//		return serviceRepository.findAll(id, name, money, unit, piority, description);
//	}
//
//	@Override
//	public  Service fetchServiceById(Integer id) throws EtResourceNotFoundException {
//		return serviceRepository.findById(id);
//		
//	}
//
//  
//
//	@Override
//	public void updateCategory(Integer id, String name, Double money, String unit, Integer piority, String description,
//			com.pairlearning.expensetracker.domain.Service servicey) throws EtBadRequestException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void removeCategoryWithAllTransactions(Integer id) throws EtResourceNotFoundException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public List<com.pairlearning.expensetracker.domain.Service> fetchAllService(Integer id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void fetchServiceById(Integer id) throws EtResourceNotFoundException {
//		// TODO Auto-generated method stub
//		
//	}

//}
