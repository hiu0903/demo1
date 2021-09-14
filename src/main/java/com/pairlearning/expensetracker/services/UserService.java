package com.pairlearning.expensetracker.services;



import java.sql.Timestamp;

import com.pairlearning.expensetracker.domain.User;
import com.pairlearning.expensetracker.exceptions.EtAuthException;

public interface UserService {

    User validateUser(String phone, String password) throws EtAuthException;

    User registerUser(Timestamp updated, Boolean sex, String phone, String name, String img, Timestamp created,
			String address, String password, Boolean role) throws EtAuthException;

}
