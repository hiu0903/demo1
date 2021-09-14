package com.pairlearning.expensetracker.services;

import com.pairlearning.expensetracker.domain.Category;
import com.pairlearning.expensetracker.exceptions.EtBadRequestException;
import com.pairlearning.expensetracker.exceptions.EtResourceNotFoundException;

import java.util.List;

public interface CategoryService {

    List<Category> fetchAllCategories(Integer id);

    Category fetchCategoryById(Integer id) throws EtResourceNotFoundException;

    Category addCategory(String name) throws EtBadRequestException;

    void updateCategory(Integer id, Category category) throws EtBadRequestException;

    void removeCategoryWithAllTransactions(Integer id) throws EtResourceNotFoundException;

}
