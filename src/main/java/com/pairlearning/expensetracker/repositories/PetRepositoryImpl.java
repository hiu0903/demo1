package com.pairlearning.expensetracker.repositories;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.pairlearning.expensetracker.domain.Pet;
import com.pairlearning.expensetracker.exceptions.EtBadRequestException;
import com.pairlearning.expensetracker.exceptions.EtResourceNotFoundException;

@Repository
public class PetRepositoryImpl implements PetRepository{

	private static final String SQL_FIND_ALL =
    		"SELECT uid, name, birth , breed, kind, added, updated, img " +
            "FROM public.Pet WHERE uid = ?";
    private static final String SQL_CREATE =
    		"INSERT INTO public.Pet(petid,uid, name, birth , breed, kind, added, updated ,img ) "
    		+ "VALUES(nextval('\"Pet_PetID_seq\"'::regclass),?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_FIND_BY_ID =
    		"SELECT uid, name, birth , breed, kind, added, updated, img " +
            "FROM public.Pet WHERE uid = ?";
    private static final String SQL_UPDATE =
    		"UPDATE Pet SET name = ?, birth = ?,breed = ?, kind = ?, added = ?,updated = ?, img = ? WHERE id = ? AND petid = ?";
    
    private static final String SQL_DELETE_ALL_TRANSACTIONS = "DELETE FROM ET_TRANSACTIONS WHERE CATEGORY_ID = ?"; // chua sua
     
    @Autowired
    JdbcTemplate jdbcTemplate;

	@Override
	public List<Pet> findAll(Integer uid) {
		return jdbcTemplate.query(SQL_FIND_ALL, new Object[]{uid},   petRowMapper);
	}

	@Override
	public Pet findById(Integer uid) throws EtResourceNotFoundException {
		try {
			System.out.println("ErrLOG: "+SQL_FIND_BY_ID);
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{uid}, petRowMapper);
        }catch (Exception e) {
        	throw e;
//            throw new EtResourceNotFoundException("Pet not found");
        }
	}

	@Override
	public Integer create(Integer uid, String name, java.sql.Date birth, String breed, String kind,
			Timestamp added, Timestamp updated, String img) throws EtBadRequestException {
		try {
			java.util.Date date = new java.util.Date();
        	Timestamp tt = new Timestamp(date.getTime()); 
        	updated = new Timestamp(date.getTime());
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, uid);
                ps.setString(2, name);
                ps.setDate(3, birth);
                ps.setString(4, breed);
                ps.setString(5, kind);
                ps.setTimestamp(6, tt);
                ps.setTimestamp(7, tt);
                ps.setString(8, img);
                System.out.println("ErrLOG: "+ps);
                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("uid");
        }catch (Exception e) {
        	throw e;
//            throw new EtBadRequestException("Invalid request");
        }
	}

	@Override
	public void update( Integer uid, Pet pet) throws EtBadRequestException {
		try {
            jdbcTemplate.update(SQL_UPDATE, new Object[]{pet.getName(), pet.getBirth(), pet.getBreed(), pet.getKind(),pet.getAdded(),pet.getUpdated(),pet.getImg(), uid});
        }catch (Exception e) {
            throw new EtBadRequestException("Invalid request");
        }
		
	}
	
	 private RowMapper<Pet> petRowMapper = ((rs, rowNum) -> {
	        return new Pet(
	        		
	        		rs.getInt("uid"),
	                rs.getString("name"),
	                rs.getDate("birth"),
	                rs.getString("breed"),
	                rs.getString("kind"),
	                rs.getTimestamp("added"),
	                rs.getTimestamp("updated"),
	                rs.getString("img")
	        		);
	    });

	@Override
	public void removeById(Integer uid) {
		jdbcTemplate.update(SQL_DELETE_ALL_TRANSACTIONS, new Object[]{uid});
		
	}
}
