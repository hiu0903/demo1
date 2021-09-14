//package com.pairlearning.expensetracker.repositories;
//
//import java.sql.PreparedStatement;
//import java.sql.Statement;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//
//import com.pairlearning.expensetracker.domain.Service;
//import com.pairlearning.expensetracker.exceptions.EtBadRequestException;
//import com.pairlearning.expensetracker.exceptions.EtResourceNotFoundException;
//
//public class ServiceRepositoryImpl<categoryRowMapper> {
//
//    private static final String SQL_FIND_ALL = "SELECT * FORM SERVICES";
//    private static final String SQL_FIND_BY_ID ="SELECT ID, NAME, MONEY, UNIT, PIORITY, DESCRIPTION " +
//            "FROM  SERVICES WHERE ID = ?";
//    private static final String SQL_CREATE = "INSERT INTO SERVICES (ID, NAME,  MONEY, UNIT, PIORITY, DESCRIPTION) VALUES(NEXTIVAL('CATEGORIES_SEQ'),?, ?)";
//    private static final String SQL_UPDATE = "UPDATE SERVICES SET NAME = ? " +
//            "WHERE ID = ? ";
//    private static final String SQL_DELETE_CATEGORY = "DELETE FROM  SERVICES WHERE ID = ? ";
//    private static final String SQL_DELETE_ALL_TRANSACTIONS = "DELETE FROM ET_TRANSACTIONS WHERE CATEGORY_ID = ?";
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    public List<Service> findAll(Integer id, String name, Double money, String unit, Integer piority, String description) throws EtResourceNotFoundException {
//        return jdbcTemplate.query(SQL_FIND_ALL, new Object[]{id}, serviceRowMapper);
//    }
//
//    public Service findById(Integer id) throws EtResourceNotFoundException {
//        try {
//            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{id}, serviceRowMapper);
//        }catch (Exception e) {
//            throw new EtResourceNotFoundException("Service not found");
//        }
//    }
//
//    public Integer create(Integer id, String name, Double money, String unit, Integer piority, String description) throws EtBadRequestException {
//        try {
//            KeyHolder keyHolder = new GeneratedKeyHolder();
//            jdbcTemplate.update(connection -> {
//                PreparedStatement ps = connection.prepareStatement(SQL_CREATE,Statement.RETURN_GENERATED_KEYS);
//                ps.setInt(1, id);
//                ps.setString(2, name);
//                ps.setDouble(3,money);
//                ps.setString(4, unit);
//                ps.setInt(5, piority);
//                ps.setString(6, description);
//                return ps;
//            }, keyHolder);
//            return (Integer) keyHolder.getKeys().get("ID");
//        }catch (Exception e) {
//            throw new EtBadRequestException("Invalid request");
//        }
//    }
//
//    public void update(Integer id, String name ,  Double money, String unit, Integer piority, String description ,Service service ) throws EtBadRequestException {
//        try {
//            jdbcTemplate.update(SQL_UPDATE, new Object[]{
//            		service.getId(),
//            		service.getName(), 
//            		service.getMoney(),
//            		service.getUnit(),
//            		service.getPiority(),
//            		service.getDescription(),});
//        }catch (Exception e) {
//            throw new EtBadRequestException("Invalid request");
//        }
//    }
//
//    public void removeById(Integer id) {
//        this.removeAllCatTransactions(id);
//        jdbcTemplate.update(SQL_DELETE_CATEGORY, new Object[]{id});
//    }
//
//    private void removeAllCatTransactions(Integer categoryId) {
//        jdbcTemplate.update(SQL_DELETE_ALL_TRANSACTIONS, new Object[]{categoryId});
//    }
//
//    private RowMapper<Service> serviceRowMapper = ((rs, rowNum) -> {
//        return new Service
//        		(rs.getInt("ID"),
//                rs.getString("NAME"),
//                rs.getDouble("MONEY"),
//                rs.getString("UNIT"),
//                rs.getInt("PIORITY"),
//                rs.getString("DESCRIPTION"));
//                
//               
//    });
//}
