package com.pairlearning.expensetracker.repositories;



import java.sql.Timestamp;

import com.pairlearning.expensetracker.domain.User;
import com.pairlearning.expensetracker.exceptions.EtAuthException;

public interface UserRepository {

    Integer create(Timestamp updated, Boolean sex, String phone, String name, String img, Timestamp created,
			String address, String password, Boolean role) throws EtAuthException;

    User findByPhoneAndPassword(String phone, String password) throws EtAuthException;

    Integer getCountByPhone(String phone);

    User findById(Integer id);

}
