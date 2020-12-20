package com.j4v4code.dao.abstr;

import com.j4v4code.model.Admin;

import java.io.Serializable;
import java.util.List;

public interface AdminRepository {

    // Get Admin By userName
    List<Admin> getAllUser();
    Admin findByUserName(String userName);

}
