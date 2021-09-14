package com.pairlearning.expensetracker.services;

import com.pairlearning.expensetracker.domain.User;
import com.pairlearning.expensetracker.exceptions.EtAuthException;
import com.pairlearning.expensetracker.repositories.UserRepository;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser(String phone, String password) throws EtAuthException {
        if(phone != null) phone = phone.toLowerCase();
        return userRepository.findByPhoneAndPassword(phone, password);
    }

    @Override
    public User registerUser(Timestamp updated, Boolean sex, String phone, String name, String img, Timestamp created,
			String address, String password, Boolean role) throws EtAuthException {
        if(phone != null) phone = phone.toLowerCase();
        Integer count = userRepository.getCountByPhone(phone);
        if(count > 0)
            throw new EtAuthException("Phone already in use");
        Integer id = userRepository.create(updated,sex,phone,name,img,created,address,password,role);
        return userRepository.findById(id);
    }
}
