//package com.pairlearning.expensetracker.resources;
//
//import com.pairlearning.expensetracker.domain.Product;
//import com.pairlearning.expensetracker.services.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/categories/{catId}/product")
//public class ProductResource {
//
//    @Autowired
//    ProductService transactionService;
//
//    @GetMapping("")
//    public ResponseEntity<List<Product>> getAllTransactions(HttpServletRequest request,
//                                                                @PathVariable("catId") Integer catId) {
//        int id = (Integer) request.getAttribute("id");
//        List<Product> transactions = transactionService.fetchAllTransactions(id, catId);
//        return new ResponseEntity<>(transactions, HttpStatus.OK);
//    }
// 
//    @GetMapping("/{transactionId}")
//    public ResponseEntity<Product> getTransactionById(HttpServletRequest request,
//                                                          @PathVariable("catId") Integer catId){
//                                                           
//        int id = (Integer) request.getAttribute("id");
//        Product transaction = transactionService.fetchTransactionById(id, catId);
//        return new ResponseEntity<>(transaction, HttpStatus.OK);
//    }
//
//    @PostMapping("")
//    public ResponseEntity<Product> addTransaction(HttpServletRequest request,
//                                                      @PathVariable("catId") Integer catId,
//                                                      @RequestBody Map<String, Object> transactionMap) {
//        int id = (Integer) request.getAttribute("id");
//        Double name = Double.valueOf(transactionMap.get("name").toString()); 
//        
//        String note = (String) transactionMap.get("note");
//        Long transactionDate = (Long) transactionMap.get("transactionDate");
//        Product transaction = transactionService.addTransaction(catId, note, note, note, name, catId);
//        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{transactionId}")
//    public ResponseEntity<Map<String, Boolean>> updateTransaction(HttpServletRequest request,
//                                                                  @PathVariable("catId") Integer catId,
//                                                                  @RequestBody Product product) {
//        int id = (Integer) request.getAttribute("userId");
//        transactionService.updateTransaction(id, catId, product);
//        Map<String, Boolean> map = new HashMap<>();
//        map.put("success", true);
//        return new ResponseEntity<>(map, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{transactionId}")
//    public ResponseEntity<Map<String, Boolean>> deleteTransaction(HttpServletRequest request,
//                                                                  @PathVariable("catId") Integer catId
//                                                                ) {
//        int userId = (Integer) request.getAttribute("userId");
//        transactionService.removeTransaction(userId, catId);
//        Map<String, Boolean> map = new HashMap<>();
//        map.put("success", true);
//        return new ResponseEntity<>(map, HttpStatus.OK);
//    }
//}
