package com.pairlearning.expensetracker.repositories;

import com.pairlearning.expensetracker.domain.Category;
import com.pairlearning.expensetracker.exceptions.EtBadRequestException;
import com.pairlearning.expensetracker.exceptions.EtResourceNotFoundException;

import java.util.List;

public interface CategoryRepository {

    List<Category> findAll(Integer id ) throws EtResourceNotFoundException;

    Category findById(Integer id) throws EtResourceNotFoundException;

    Integer create(String name) throws EtBadRequestException;

    void update(Integer id, String name, Category category) throws EtBadRequestException;

    void removeById(Integer id);

}
