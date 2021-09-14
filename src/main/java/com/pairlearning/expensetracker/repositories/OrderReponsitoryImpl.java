//package com.pairlearning.expensetracker.repositories;
//
//import java.sql.PreparedStatement;
//import java.sql.Statement;
//import java.sql.Timestamp;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//import org.springframework.stereotype.Repository;
//
//
//import com.pairlearning.expensetracker.domain.Order;
//import com.pairlearning.expensetracker.exceptions.EtBadRequestException;
//import com.pairlearning.expensetracker.exceptions.EtResourceNotFoundException;
//
//@Repository
//public class OrderReponsitoryImpl implements OrderReponsitory{
//
//	private static final String SQL_FIND_BY_ID ="SELECT ID, UID " +
//            "FROM  ORDER WHERE ID = ?";
//	private static final String SQL_CREATE = "INSERT INTO ORDER (ID,UID,ADDRESS,CREATED,UPDATED) VALUES(NEXTIVAL('ORDER_SEQ'),?, ?,?,?,?)";
//	private static final String SQL_UPDATE = "UPDATE ORDER SET ID = ?, UID = ?, ADDRESS = ?,CREATED = ? AND UPDATED = ?";
//	
//	@Autowired
//    JdbcTemplate jdbcTemplate;
//	
//	@Override
//	public Integer create(Integer id, Integer uId, String address, Timestamp created, Timestamp updated)
//			throws EtBadRequestException {
//		        try {
//		            KeyHolder keyHolder = new GeneratedKeyHolder();
//		            jdbcTemplate.update(connection -> {
//		                PreparedStatement ps = connection.prepareStatement(SQL_CREATE,Statement.RETURN_GENERATED_KEYS);
//		                ps.setInt(1, id);
//		                ps.setInt(2,uId);
//		                ps.setString(3, address);
//		                ps.setTimestamp(4, created);
//		                ps.setTimestamp(5, updated);
//		                return ps;
//		            }, keyHolder);
//		            return (Integer) keyHolder.getKeys().get("id");
//		        }catch (Exception e) {
//		            throw new EtBadRequestException("Invalid request");
//		        }
//		    }
//
//	@Override
//	public Order findById(Integer id, Integer uId) throws EtResourceNotFoundException {
//        try {
//            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{id}, orderRowMapper);
//        }catch (Exception e) {
//            throw new EtResourceNotFoundException("Order not found");
//        }
//    }
//
//	@Override
//	public void update(Integer id, Integer uId, String address, Timestamp created, Timestamp updated, Order order)
//			throws EtBadRequestException {
//        try {
//            jdbcTemplate.update(SQL_UPDATE, new Object[]{order.getAddress(), order.getCreated(),order.getUpdated(), id, uId});
//        }catch (Exception e) {
//            throw new EtBadRequestException("Invalid request");
//        }
//    }
//	
//	private RowMapper<Order> orderRowMapper = ((rs, rowNum) -> {
//        return new Order(
//        		rs.getInt("ID"),
//        		rs.getInt("UID"),
//                rs.getString("ADDRESS"),
//                rs.getTimestamp("CREATED"),
//                rs.getTimestamp("UPDATED"));
//    });
//
//}
