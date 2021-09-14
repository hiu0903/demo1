package com.pairlearning.expensetracker.repositories;

import com.pairlearning.expensetracker.domain.Product;
import com.pairlearning.expensetracker.exceptions.EtBadRequestException;
import com.pairlearning.expensetracker.exceptions.EtResourceNotFoundException;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll(Integer id, Integer catId);

    Product findById(Integer id, Integer catId) throws EtResourceNotFoundException;

    Integer create(Integer catId, String name, String brand, String discription,Double price, Integer discount) throws EtBadRequestException;

    void update(Integer id, Integer catId, Product product) throws EtBadRequestException;

    void removeById(Integer id, Integer catId) throws EtResourceNotFoundException;

}
