package com.pairlearning.expensetracker.services;

import com.pairlearning.expensetracker.domain.Product;
import com.pairlearning.expensetracker.exceptions.EtBadRequestException;
import com.pairlearning.expensetracker.exceptions.EtResourceNotFoundException;
import com.pairlearning.expensetracker.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> fetchAllTransactions(Integer id, Integer catId) {
        return productRepository.findAll(id, catId);
    }

    @Override
    public Product fetchTransactionById(Integer id, Integer catId) throws EtResourceNotFoundException {
        return productRepository.findById(id, catId);
    }

    @Override
    public Product addTransaction(Integer catId, String name, String brand, String discription,Double price, Integer discount) throws EtBadRequestException {
        int id = productRepository.create(catId,name, brand, discription, price, discount);
        return productRepository.findById(id, catId);
    }

    @Override
    public void updateTransaction(Integer id, Integer catId, Product product) throws EtBadRequestException {
    	productRepository.update(id, catId, product);
    }

    @Override
    public void removeTransaction(Integer id, Integer catId) throws EtResourceNotFoundException {
    	productRepository.removeById(id, catId);
    }



}
