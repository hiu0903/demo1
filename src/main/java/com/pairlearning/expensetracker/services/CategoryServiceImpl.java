package com.pairlearning.expensetracker.services;

import com.pairlearning.expensetracker.domain.Category;
import com.pairlearning.expensetracker.exceptions.EtBadRequestException;
import com.pairlearning.expensetracker.exceptions.EtResourceNotFoundException;
import com.pairlearning.expensetracker.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> fetchAllCategories(Integer id) {
        return categoryRepository.findAll(id);
    }

    @Override
    public Category fetchCategoryById(Integer id) throws EtResourceNotFoundException {
        return categoryRepository.findById(id);
    }

//    Lỗi fix chưa xong
    @Override
    public Category addCategory(String name) throws EtBadRequestException {
		int id  = categoryRepository.create(name);
        return categoryRepository.findById(id);
    }

    @Override
    public void updateCategory(Integer id,Category category) throws EtBadRequestException {
        categoryRepository.update(id,null, category);
    }

    @Override
    public void removeCategoryWithAllTransactions(Integer id) throws EtResourceNotFoundException {
        this.fetchCategoryById(id);
        categoryRepository.removeById(id);
    }
}
