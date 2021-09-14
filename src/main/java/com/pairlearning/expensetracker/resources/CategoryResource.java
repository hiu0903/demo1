package com.pairlearning.expensetracker.resources;

import com.pairlearning.expensetracker.domain.Category;
import com.pairlearning.expensetracker.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryResource {

    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<Category>> getAllCategories(HttpServletRequest request) {
        int id = (Integer) request.getAttribute("id");
        List<Category> categories = categoryService.fetchAllCategories(id);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategoryById(HttpServletRequest request,
                                                    @PathVariable("id") Integer id) {
      
        Category category = categoryService.fetchCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Category> addCategory(HttpServletRequest request,
                                                @RequestBody Map<String, Object> categoryMap) {
    
        
        String name = (String) categoryMap.get("name");
        Category category = categoryService.addCategory(name);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

//    @PutMapping("/{categoryId}")
//    public ResponseEntity<Map<String, Boolean>> updateCategory(HttpServletRequest request,
//                                                               @PathVariable("id") Integer id,
//                                                               @RequestBody Category category) {
//        int id = (Integer) request.getAttribute("id");
//        categoryService.updateCategory(id, category);
//        Map<String, Boolean> map = new HashMap<>();
//        map.put("success", true);
//        return new ResponseEntity<>(map, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{categoryId}")
//    public ResponseEntity<Map<String, Boolean>> deleteCategory(HttpServletRequest request,
//                                                               @PathVariable("categoryId") Integer id) {
//        int id = (Integer) request.getAttribute("Id");
//        categoryService.removeCategoryWithAllTransactions(id);
//        Map<String, Boolean> map = new HashMap<>();
//        map.put("success", true);
//        return new ResponseEntity<>(map, HttpStatus.OK);
//    }
}
