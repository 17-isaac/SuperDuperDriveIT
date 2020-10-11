package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    /**
     * Create new user
     * @param user
     * @return
     */
    Users register(Users user);

    Users getByUserName(String userName);

    Users getByUserid(Integer userid);
}
