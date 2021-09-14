package com.pairlearning.expensetracker.repositories;

import com.pairlearning.expensetracker.domain.Product;
import com.pairlearning.expensetracker.exceptions.EtBadRequestException;
import com.pairlearning.expensetracker.exceptions.EtResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private static final String SQL_FIND_ALL = "SELECT ID, CATID, NAME, BRAND, DISCRIPTION, PRICE, DISCOUNT FROM PRODUCT WHERE ID = ? AND CATID = ?";
    private static final String SQL_FIND_BY_ID = "SELECT ID, CATID, NAME, BRAND, DISCRIPTION, PRICE, DISCOUNT FROM PRODUCT FROM PRODUCT WHERE ID = ? AND CATID = ?";
    private static final String SQL_CREATE = "INSERT INTO PRODUCT (ID, CATID, NAME, BRAND, DISCRIPTION, PRICE, DISCOUNT FROM PRODUCT) VALUES(NEXTVAL('PRODUCT_SEQ'), ?, ?, ?, ?, ?,?)";
    private static final String SQL_UPDATE = "UPDATE PRODUCT SET NAME = ?, BRAND = ?, DISCRIPTION = ?,PRICE = ?, DISCOUNT = ? WHERE ID = ? AND CATID = ?";
    private static final String SQL_DELETE = "DELETE FROM PRODUCT WHERE ID = ? AND CATID = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> findAll(Integer id, Integer catId) {
        return jdbcTemplate.query(SQL_FIND_ALL, new Object[]{id, catId}, transactionRowMapper);
    }

    @Override
    public Product findById(Integer id, Integer catId) throws EtResourceNotFoundException {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{id, catId}, transactionRowMapper);
        }catch (Exception e) {
            throw new EtResourceNotFoundException("Product not found");
        }
    }

    @Override
    public Integer create(Integer catId, String name, String brand, String discription,Double price, Integer discount) throws EtBadRequestException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, catId);
                ps.setString(2, name);
                ps.setString(3, brand);
                ps.setString(4, discription);
                ps.setDouble(5, price);
                ps.setInt(6, discount);
                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("TRANSACTION_ID");
        }catch (Exception e) {
            throw new EtBadRequestException("Invalid request");
        }
    }

    @Override
    public void update(Integer id, Integer catId, Product product) throws EtBadRequestException {
        try {
            jdbcTemplate.update(SQL_UPDATE, new Object[]{product.getName(), product.getBrand(), product.getDescription(), product.getPrice(), id, catId});
        }catch (Exception e) {
            throw new EtBadRequestException("Invalid request");
        }
    }

    @Override
    public void removeById(Integer id, Integer catId) throws EtResourceNotFoundException {
        int count = jdbcTemplate.update(SQL_DELETE, new Object[]{id, catId});
        if(count == 0)
            throw new EtResourceNotFoundException("Product not found");
    }

    private RowMapper<Product> transactionRowMapper = ((rs, rowNum) -> {
        return new Product(
        		rs.getInt("ID"),
        		rs.getInt("CATID"),
                rs.getString("NAME"),
                rs.getString("BRAND"),
                rs.getString("DISCRIPTION"),
                rs.getDouble("PRICE"),
                rs.getInt("DISCOUNT")
        		);
    });
}
