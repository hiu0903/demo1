package com.pairlearning.expensetracker.services;

import com.pairlearning.expensetracker.domain.Product;
import com.pairlearning.expensetracker.exceptions.EtBadRequestException;
import com.pairlearning.expensetracker.exceptions.EtResourceNotFoundException;

import java.util.List;

public interface ProductService {

    List<Product> fetchAllTransactions(Integer id, Integer catId);

    Product fetchTransactionById(Integer Id, Integer catId) throws EtResourceNotFoundException;

    Product addTransaction(Integer catId, String name, String brand, String discription,Double price, Integer discount) throws EtBadRequestException;

    void updateTransaction(Integer id, Integer catId, Product product) throws EtBadRequestException;

    void removeTransaction(Integer id, Integer catId) throws EtResourceNotFoundException;

	
}
